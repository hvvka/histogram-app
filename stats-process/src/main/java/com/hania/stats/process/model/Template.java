package com.hania.stats.process.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class Template {

    /**
     * The list of questions (with the answers) read from the template XML file.
     */
    private final List<Question> questions;

    public Template() {
        questions = new ArrayList<>(Collections.emptyList());
    }

    public Template(List<Question> questions) {
        this.questions = questions;
    }

    public List<Question> getQuestions() {
        return questions;
    }

}
