package com.hania.stats.process;

import com.hania.stats.process.model.StudentsAnswers;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class AnswersGenerator {

    private AnswersGenerator() {
        // util
    }

    static Set<StudentsAnswers> sampleStudents() {
        return Stream.of(
                new StudentsAnswers("Twilight Sparkle",
                        AnswersGenerator.createAnswers(Arrays.asList(Arrays.asList(true, false), Arrays.asList(false, true)))),
                new StudentsAnswers("Pinky Pie",
                        AnswersGenerator.createAnswers(Arrays.asList(Arrays.asList(false, false), Arrays.asList(true, true)))))
                .collect(Collectors.toSet());
    }

    static Map<Integer,List<Boolean>> createAnswers(List<List<Boolean>> lists) {
        Map<Integer,List<Boolean>> answers = new HashMap<>();
        return IntStream.range(0, lists.size())
                .boxed()
                .collect(Collectors.toMap(i -> i, lists::get));
    }
}
