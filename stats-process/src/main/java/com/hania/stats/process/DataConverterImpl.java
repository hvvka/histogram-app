package com.hania.stats.process;

import com.hania.stats.process.model.StudentsAnswers;
import com.hania.stats.process.model.Template;
import com.thoughtworks.xstream.XStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Implementation of data converter.
 *
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class DataConverterImpl implements DataConverter {

    /**
     * Histogram's facade.
     */
    private final Histograms histograms;

    /**
     * Template containing test scheme (questions and correct answers).
     */
    private Template template;

    /**
     * The set of student's scores (along with their names).
     */
    private Set<StudentsScore> students;

    public DataConverterImpl() {
        histograms = new Histograms();
    }

    /**
     * @see DataConverter#loadData(Path, Path)
     */
    @Override
    public void loadData(Path templatePath, Path answersPath) throws IOException {
        XStream xStream = new TemplateXStream();
        template = (Template) xStream.fromXML(new FileInputStream(String.valueOf(templatePath)));
        students = StudentsAnswersProvider.loadStudentsAnswers(answersPath, template).stream()
                .map(StudentsScore::new)
                .collect(Collectors.toSet());
    }

    /**
     * @see DataConverter#createScoreHistogram()
     */
    @Override
    public List<Integer> createScoreHistogram() {
        return histograms.createScoreHistogram(template.getQuestions(), students);
    }

    /**
     * @see DataConverter#createMarkHistogram()
     */
    @Override
    public Map<String, Long> createMarkHistogram() {
        return histograms.createMarkHistogram(template.getQuestions(), students);
    }

    /**
     * @see DataConverter#createQuestionHistogram()
     */
    @Override
    public Map<Integer, Integer> createQuestionHistogram() {
        return histograms.createQuestionHistogram(template.getQuestions(), getStudentsAnswers());
    }

    /**
     * {@link Template}
     * @return the template read from a file
     */
    Template getTemplate() {
        return template;
    }

    /**
     * Maps StudentsScore to StudentsAnswers and returns as the set of objects.
     *
     * @return the set of StudentsAnswers
     */
    Set<StudentsAnswers> getStudentsAnswers() {
        return students.stream()
                .map(StudentsScore::getStudent)
                .collect(Collectors.toSet());
    }
}
