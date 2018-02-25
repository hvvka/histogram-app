package com.hania.stats.process.model;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class Answer {

    private final String text;

    private final boolean correct;

    public Answer() {
        text = null;
        correct = false;
    }

    public Answer(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
    }

    public String getText() {
        return text;
    }

    public boolean isCorrect() {
        return correct;
    }
}
