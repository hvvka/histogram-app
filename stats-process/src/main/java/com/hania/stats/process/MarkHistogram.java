package com.hania.stats.process;

import com.hania.stats.process.model.Question;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Creates mark histogram.
 *
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
class MarkHistogram {

    /**
     * {@link Histograms#createMarkHistogram(List, Set)}
     */
    Map<String, Long> createMarkHistogram(List<Question> questions, Set<StudentsScore> students) {
        List<Integer> percentRange = Arrays.asList(50, 60, 70, 80, 90, 95, 100);
        int maxScore = questions.size();
        return students.stream()
                .map(st -> st.getScore(questions))
                .map(sc -> getMark(getPercent(maxScore, sc), percentRange))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /**
     * Returns exam's result in percent.
     *
     * @param maxScore maximum score for the exam
     * @param sc score achieved by the student
     * @return percentage score
     */
    private int getPercent(int maxScore, Integer sc) {
        return sc * 100 / maxScore;
    }

    /**
     * Returns the mark achieved by the student.
     *
     * @param percent percentage score
     * @param percentRange score's boundaries
     * @return the mark
     */
    private String getMark(int percent, List<Integer> percentRange) {
        switch(getMarkNumber(percent, percentRange)) {
            case 0: return "2";
            case 1: return "3";
            case 2: return "3,5";
            case 3: return "4";
            case 4: return "4,5";
            case 5: return "5";
            case 6: return "5,5";
            default: throw new RuntimeException("Incorrect mark number");
        }
    }

    /**
     * Checks where the score belongs to (which range).
     *
     * @param percent percentage score
     * @param percentRange score's boundaries
     * @return the number (integer) from 0 to 6
     */
    private int getMarkNumber(int percent, List<Integer> percentRange) {
        for (int i = 0; i < percentRange.size(); i++) {
            if (percent <= percentRange.get(i))
                return i;
        }
        throw new RuntimeException("Incorrect percent value");
    }
}
