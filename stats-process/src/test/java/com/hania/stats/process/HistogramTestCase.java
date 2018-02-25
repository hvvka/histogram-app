package com.hania.stats.process;

import com.hania.stats.process.model.Answer;
import com.hania.stats.process.model.Question;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
class HistogramTestCase {

    List<Question> getSampleQuestions() {
        List<Answer> answers1 = Arrays.asList(new Answer("a", true), new Answer("b", false));
        List<Answer> answers2 = Arrays.asList(new Answer("c", false), new Answer("d", true));
        return Arrays.asList(new Question(1, "pytanie", answers1),
                new Question(2, "pytanko", answers2));
    }

    Set<StudentsScore> getSampleStudentsScores() {
        return AnswersGenerator.sampleStudents().stream()
                .map(StudentsScore::new)
                .collect(Collectors.toSet());
    }
}
