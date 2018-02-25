package com.hania.stats.process;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class ScoreHistogramTest extends HistogramTestCase {

    @Test
    public void createScoreHistogram() {
        // given
        ScoreHistogram histogram = new ScoreHistogram();

        // when
        List<Integer> scoreHistogram = histogram.createScoreHistogram(getSampleQuestions(), getSampleStudentsScores());

        // then
        List<Integer> correctScoreHistogram = Arrays.asList(1, 0, 1);
        assertEquals(correctScoreHistogram, scoreHistogram);
    }
}