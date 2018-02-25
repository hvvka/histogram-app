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
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

/**
 * @author <a href="mailto:hanna.grodzicka@fingo.pl">Hanna Grodzicka - FINGO</a>
 */
public final class StudentsAnswersProvider {

    private StudentsAnswersProvider() {
    }

    static Set<StudentsAnswers> loadStudentsAnswers(Path answersPath, Template template) {
        try (
                final Reader reader = Files.newBufferedReader(answersPath);
                final CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);
        ) {
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            Iterator<CSVRecord> csvRecordIterator = csvRecords.iterator();
            int number = Integer.parseInt(csvRecordIterator.next().get(0));
            return IntStream.range(0, number)
                    .mapToObj(it -> getStudent(csvRecordIterator, template))
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static StudentsAnswers getStudent(Iterator<CSVRecord> csvRecordIterator, Template template) {
        String name = csvRecordIterator.next().get(0);
        List<List<Boolean>> answers = getAnswers(csvRecordIterator, template);
        return new StudentsAnswers(name, answers);
    }

    private static List<List<Boolean>> getAnswers(Iterator<CSVRecord> csvRecordIterator, Template template) {
        return IntStream.range(0, template.getQuestions().size())
                .mapToObj(it -> getQuestionAnswers(csvRecordIterator))
                .collect(Collectors.toList());
    }

    private static List<Boolean> getQuestionAnswers(Iterator<CSVRecord> csvRecordIterator) {
        return StreamSupport.stream(csvRecordIterator.next().spliterator(), false)
                .map(Boolean::valueOf)
                .collect(Collectors.toList());
    }
}
