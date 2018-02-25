package com.hania.stats.process;

import com.hania.stats.process.model.Question;
import com.hania.stats.process.model.StudentsAnswers;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class Histograms {

    private final ScoreHistogram scoreHistogram;
    private final MarkHistogram markHistogram;
    private final QuestionHistogram questionHistogram;

    Histograms() {
        scoreHistogram = new ScoreHistogram();
        markHistogram = new MarkHistogram();
        questionHistogram = new QuestionHistogram();
    }

    List<Integer> createScoreHistogram(List<Question> questions, Set<StudentsScore> students) {
        return scoreHistogram.createScoreHistogram(questions, students);
    }


    Map<String, Long> createMarkHistogram(List<Question> questions, Set<StudentsScore> students) {
        return markHistogram.createMarkHistogram(questions, students);
    }

    Map<Integer, Integer> createQuestionHistogram(List<Question> questions, Set<StudentsAnswers> students) {
        return questionHistogram.createQuestionHistogram(questions, students);
    }
}
