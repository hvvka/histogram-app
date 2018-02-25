package com.hania.stats.process;

import com.hania.stats.process.model.Answer;
import com.hania.stats.process.model.Question;
import com.hania.stats.process.model.StudentsAnswers;
import com.hania.stats.process.model.Template;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class StudentsScoreTest {

    @Test
    public void getScore() {
        // given
        Map<Integer, List<Boolean>> answers =
                AnswersGenerator.createAnswers(Arrays.asList(Arrays.asList(false, false), Arrays.asList(false, true)));
        StudentsAnswers studentsAnswers = new StudentsAnswers("Twilight Sparkle", answers);
        StudentsScore studentsScore = new StudentsScore(studentsAnswers);

        // when
        int score = studentsScore.getScore(getTemplate().getQuestions());

        // then
        Assert.assertEquals(1, score);
    }

    private Template getTemplate() {
        List<Question> questionList = new ArrayList<>();

        final String question1 = "Semafory Dijkstry";
        final String q1answer1 = "Sluza do synchronizacji procesow wspolbieznych";
        final String q1answer2 = "Sa to flagi dwustanowe, na ktorych zdefiniowane sa nieprzerywalne operacje P i V";

        final String question2 = "Algorytm przelaczania procesow w systemie Unix";
        final String q2answer1 = "Jest algorytmem z wywlaszczeniem procesow systemowych i uzytkowych";
        final String q2answer2 = "Jest algortmem priorytetowym, w którym priorytet jest wewnetrznie zmieniany w " +
                "trakcie wykonywania procesu";

        questionList.add(new Question(1, question1,
                Arrays.asList(new Answer(q1answer1, true), new Answer(q1answer2, false))));
        questionList.add(new Question(2, question2,
                Arrays.asList(new Answer(q2answer1, false), new Answer(q2answer2, true))));

        return new Template(questionList);
    }
}