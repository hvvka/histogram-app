package com.hania.stats.process;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public interface DataConverter {

    /**
     * Parses and loads objects from XML and CSV files.
     *
     * @param templatePath  the location for the XML file with template containg test structure and correct answers
     * @param answersPath   the location for the CSV file containg all the students' answers
     */
    void loadData(Path templatePath, Path answersPath) throws IOException;

    /**
     * Returns a list which index indicates the student's score and the Integer found for the index is the number
     * of students that achieved that score.
     *
     * @return a list with the number of scores achieved by certain number of students
     */
    List<Integer> createScoreHistogram();

    /**
     * Returns a map which key indicates the student's mark (as a string) and the value is the number of students
     * that got that mark.
     *
     * @return a map with the number of marks achieved by certain number of students
     */
    Map<String, Long> createMarkHistogram();

    /**
     * Returns a map which key indicates the question's number and the value is the number of students that answered
     * that question correct.
     *
     * @return a map with the number of correct answers for certain question given by a certain number of students
     */
    Map<Integer, Integer> createQuestionHistogram();

}
