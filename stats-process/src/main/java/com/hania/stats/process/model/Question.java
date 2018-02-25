package com.hania.stats.process.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class Question {

    /**
     * Question's identifier (number).
     */
    private final int number;

    /**
     * Question's text content.
     */
    private final String question;

    /**
     * The list of answers for the question.
     */
    private final List<Answer> answers;

    public Question() {
        number = -1;
        question = null;
        answers = new ArrayList<>(Collections.emptyList());
    }

    public Question(int number, String question, List<Answer> answers) {
        this.number = number;
        this.question = question;
        this.answers = answers;
    }

    public int getNumber() {
        return number;
    }

    public String getQuestion() {
        return question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

}
