package com.hania.stats.process.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Question's model.
 *
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

    /**
     * Default constructor.
     */
    public Question() {
        number = -1;
        question = null;
        answers = new ArrayList<>(Collections.emptyList());
    }

    /**
     * Constructor.
     *
     * @param number question's number (id)
     * @param question question's content as text
     * @param answers the list of answers for the question
     */
    public Question(int number, String question, List<Answer> answers) {
        this.number = number;
        this.question = question;
        this.answers = answers;
    }

    /**
     * {@link Question#number}
     *
     * @return question's number
     */
    public int getNumber() {
        return number;
    }

    /**
     * {@link Question#question}
     *
     * @return question's text
     */
    public String getQuestion() {
        return question;
    }

    /**
     * {@link Question#answers}
     *
     * @return the list of answers for the question
     */
    public List<Answer> getAnswers() {
        return answers;
    }

}
