package com.hania.stats.process.model;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class Answer {

    /**
     * Answer's text content.
     */
    private final String text;

    /**
     * Indicates if the answers is correct or not.
     */
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
