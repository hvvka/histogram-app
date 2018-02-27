package com.hania.stats.process.model;

/**
 * Answer's model.
 *
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

    /**
     * Default constructor.
     */
    public Answer() {
        text = null;
        correct = false;
    }

    /**
     * Constructor.
     *
     * @param text answer's text
     * @param correct boolean that determines whether the answer is correct
     */
    public Answer(String text, boolean correct) {
        this.text = text;
        this.correct = correct;
    }

    /**
     * {@link Answer#text}
     *
     * @return answer's text
     */
    public String getText() {
        return text;
    }

    /**
     * {@link Answer#correct}
     *
     * @return boolean indicating answer's correctness
     */
    public boolean isCorrect() {
        return correct;
    }

}
