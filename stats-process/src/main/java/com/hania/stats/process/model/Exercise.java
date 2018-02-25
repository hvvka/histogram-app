package com.hania.stats.process.model;

import java.util.List;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class Exercise {

    private int number;

    private String question;

    private List<Answer> answers;

    public Exercise(int number, String question, List<Answer> answers) {
        this.number = number;
        this.question = question;
        this.answers = answers;
    }

    public Exercise() {
        super();
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
