package com.hania.stats.process;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class QuestionHistogramTest extends HistogramTestCase {

    @Test
    public void createQuestionHistogram() {
        // given
        QuestionHistogram histogram = new QuestionHistogram();

        // when
        Map<Integer, Integer> questionHistogram =
                histogram.createQuestionHistogram(getSampleQuestions(),AnswersGenerator.sampleStudents());

        // then
        assertEquals(getCorrectQuestionHistogram(), questionHistogram);
    }

    private Map<Integer, Integer> getCorrectQuestionHistogram() {
        Map<Integer, Integer> correctHistogram = new HashMap<>();
        correctHistogram.put(1,1);
        correctHistogram.put(2,1);
        return correctHistogram;
    }
}