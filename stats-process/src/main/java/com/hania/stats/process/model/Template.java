package com.hania.stats.process.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Template's model.
 *
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class Template {

    /**
     * The list of questions (with the answers) read from the template XML file.
     */
    private final List<Question> questions;

    /**
     * Default constructor.
     */
    public Template() {
        questions = new ArrayList<>(Collections.emptyList());
    }

    /**
     * Constructor for exam's template.
     *
     * @param questions the list of questions read from a XML file
     */
    public Template(List<Question> questions) {
        this.questions = questions;
    }

    /**
     * Returns all the questions that appeared in the file with exam's template.
     *
     * @return the list of questions read from a XML file
     */
    public List<Question> getQuestions() {
        return questions;
    }

}
