package com.hania.stats.process;

import com.hania.stats.process.model.Question;
import com.hania.stats.process.model.StudentsAnswers;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Histograms' facade.
 *
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class Histograms {

    /**
     * @see ScoreHistogram
     */
    private final ScoreHistogram scoreHistogram;
    /**
     * @see MarkHistogram
     */
    private final MarkHistogram markHistogram;
    /**
     * @see QuestionHistogram
     */
    private final QuestionHistogram questionHistogram;

    /**
     * Default constructor.
     */
    Histograms() {
        scoreHistogram = new ScoreHistogram();
        markHistogram = new MarkHistogram();
        questionHistogram = new QuestionHistogram();
    }

    /**
     * Returns histogram with scores.
     *
     * @param questions the list of questions
     * @param students the set of students
     * @return the list with the number of achieved scores
     */
    List<Integer> createScoreHistogram(List<Question> questions, Set<StudentsScore> students) {
        return scoreHistogram.createScoreHistogram(questions, students);
    }

    /**
     * Returns histogram with marks.
     *
     * @param questions the list of questions
     * @param students students the set of students
     * @return the map with marks and the number of these marks
     */
    Map<String, Long> createMarkHistogram(List<Question> questions, Set<StudentsScore> students) {
        return markHistogram.createMarkHistogram(questions, students);
    }

    /**
     * Returns histogram with the number of correct answers for all the questions.
     *
     * @param questions the list of questions
     * @param students students the set of students
     * @return the maps with question's number and the number of correct answers for that question
     */
    Map<Integer, Integer> createQuestionHistogram(List<Question> questions, Set<StudentsAnswers> students) {
        return questionHistogram.createQuestionHistogram(questions, students);
    }
}
