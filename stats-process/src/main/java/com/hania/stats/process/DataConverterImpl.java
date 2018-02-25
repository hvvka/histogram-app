package com.hania.stats.process;

import com.hania.stats.process.model.StudentsAnswers;
import com.hania.stats.process.model.Template;
import com.thoughtworks.xstream.XStream;

import java.io.*;
import java.nio.file.Path;
import java.util.*;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class DataConverterImpl implements DataConverter {

    private Template template;

    @Override
    public void loadData(Path templatePath, Path answersPath) {
        XStream xStream = new TemplateXStream();
        try {
            template = (Template) xStream.fromXML(new FileInputStream(String.valueOf(templatePath)));
            students = StudentsAnswersProvider.loadStudentsAnswers(answersPath, template);
        } catch (FileNotFoundException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public Map<Integer, Integer> createScoreHistogram() {
        return null;
    }

    @Override
    public Map<Integer, Integer> createMarkHistogram() {
        return null;
    }

    @Override
    public Map<Integer, Integer> createExerciseHistogram() {
        return null;
    }

    Template getTemplate() {    // todo usunac
        return template;
    }

    Set<StudentsAnswers> getStudents() {   // todo up
        return students;
    }
}
