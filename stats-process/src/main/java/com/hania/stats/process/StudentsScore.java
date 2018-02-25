package com.hania.stats.process;

import com.hania.stats.process.model.StudentsAnswers;
import com.hania.stats.process.model.Template;

import java.util.Set;
import java.util.stream.IntStream;

/**
 * @author <a href="mailto:hanna.grodzicka@fingo.pl">Hanna Grodzicka - FINGO</a>
 */
public class StudentsScore {

    private final StudentsAnswers student;

    private Integer score;

    public StudentsScore(StudentsAnswers student) {
        this.student = student;
    }

    public StudentsAnswers getStudent() {
        return student;
    }

    public int getScore(Template template) {
        if (score == null) {
            score = calculateScore();
        }
        return score;
    }

    private int calculateScore(Template template) {
        return IntStream.range(0, student.getAnswers().size())
                .boxed()
                .map(i -> template.getQuestions().get(i).getAnswers().stream().isCorrect() == student.getAnswers());
    }
}
