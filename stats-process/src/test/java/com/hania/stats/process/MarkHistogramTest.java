package com.hania.stats.process;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class MarkHistogramTest extends HistogramTestCase {

    @Test
    public void createMarkHistogram() {
        // given
        MarkHistogram histogram = new MarkHistogram();

        // when
        Map<String, Long> markHistogram = histogram.createMarkHistogram(getSampleQuestions(), getSampleStudentsScores());

        // then
        assertEquals(getCorrectMarkHistogram(), markHistogram);
    }

    private Map<String, Long> getCorrectMarkHistogram() {
        Map<String, Long> correctHistogram = new HashMap<>();
        correctHistogram.put("2", 1L);
        correctHistogram.put("5,5", 1L);
        return correctHistogram;
    }
}