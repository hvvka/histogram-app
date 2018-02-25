package com.hania.stats.process;

import com.hania.stats.process.model.StudentsAnswers;
import com.hania.stats.process.model.Template;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
final class StudentsAnswersProvider {

    private StudentsAnswersProvider() {
        // util
    }

    /**
     * Reads the CSV file given by path. Parsed students' names and their answers are mapped to objects and collected to
     * the set of StudentsAnswers. The template sets the boundaries between students providing the number of questions
     * and answers. The first line of the file is the number of students.
     *
     * @param answersPath the path to the CSV file with students' names and answers
     * @param template    the path to the XML file with the test template
     * @return the set containing students' names associated with one's answers
     */
    static Set<StudentsAnswers> loadStudentsAnswers(Path answersPath, Template template) throws IOException {
        final Reader reader = Files.newBufferedReader(answersPath);
        Iterable<CSVRecord> csvRecords;
        Iterator<CSVRecord> csvRecordIterator;
        int number;
        try (CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
            csvRecords = csvParser.getRecords();
        }
        csvRecordIterator = csvRecords.iterator();
        number = Integer.parseInt(csvRecordIterator.next().get(0));
        return IntStream.range(0, number)
                .mapToObj(it -> getStudent(csvRecordIterator, template))
                .collect(Collectors.toSet());
    }

    private static StudentsAnswers getStudent(Iterator<CSVRecord> csvRecordIterator, Template template) {
        String name = csvRecordIterator.next().get(0);
        Map<Integer, List<Boolean>> answers = getAnswers(csvRecordIterator, template);
        return new StudentsAnswers(name, answers);
    }

    private static Map<Integer, List<Boolean>> getAnswers(Iterator<CSVRecord> csvRecordIterator, Template template) {
        return IntStream.range(0, template.getQuestions().size())
                .boxed()
                .map(i -> new AbstractMap.SimpleEntry<>(i, getQuestionAnswers(csvRecordIterator)))
                .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue));
    }

    private static List<Boolean> getQuestionAnswers(Iterator<CSVRecord> csvRecordIterator) {
        return StreamSupport.stream(csvRecordIterator.next().spliterator(), false)
                .map(Boolean::valueOf)
                .collect(Collectors.toList());
    }
}
