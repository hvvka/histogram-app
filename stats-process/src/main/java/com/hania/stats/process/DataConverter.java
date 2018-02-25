package com.hania.stats.process;

import java.nio.file.Path;
import java.util.Map;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public interface DataConverter {

    void loadData(Path templatePath, Path answersPath);

    Map<Integer, Integer> createScoreHistogram();

    Map<Integer, Integer> createMarkHistogram();

    Map<Integer, Integer> createExerciseHistogram();
}
