package com.hania.stats.process;

import com.hania.stats.process.model.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
class ScoreHistogram {

    List<Integer> createScoreHistogram(List<Question> questions, Set<StudentsScore> students) {
        int maxScore = questions.size();
        List<Integer> histogram = new ArrayList<>(Collections.nCopies(maxScore + 1, 0));
        students.stream()
                .map(st -> st.getScore(questions))
                .forEach(sc -> histogram.set(sc, histogram.get(sc) + 1));
        return histogram;
    }
}
