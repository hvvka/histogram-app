package com.hania.stats.process;

import com.hania.stats.process.model.Answer;
import com.hania.stats.process.model.Question;
import com.hania.stats.process.model.StudentsAnswers;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
class StudentsScore {

    /**
     * Student's name and answers for the test.
     */
    private final StudentsAnswers student;

    /**
     * Total student's score for the test. All the answers must be correct (comparing to the template) to get a point.
     */
    private Integer score;

    public StudentsScore(StudentsAnswers student) {
        this.student = student;
    }

    public StudentsAnswers getStudent() {
        return student;
    }

    /**
     * Performs lazy evaluation of the list of student's questions (with answers).
     *
     * @param questions the list of questions (and answers) from template
     * @return student's number of correct answers (total score)
     */
    public int getScore(List<Question> questions) {
        if (score == null) {
            score = calculateScore(questions);
        }
        return score;
    }

    /**
     * Compares the list of correct answers from template with student's answers.
     *
     * @param questions the list of questions (and answers) from template
     * @return student's number of correct answers (total score)
     */
    private int calculateScore(List<Question> questions) {
        return (int) student.getAnswers().entrySet().stream()
                .filter(a -> Objects.equals(a.getValue(), filterOnlyAnswers(a.getKey(), questions)))
                .count();
    }

    /**
     * For certain question's number associated with the list of questions converts Question (from template) and husks
     * the list of booleans from it.
     *
     * @param key question's number
     * @param questions the list of questions from template
     * @return the list of booleans representing answers for the question
     */
    private List<Boolean> filterOnlyAnswers(int key, List<Question> questions) {
        return questions.get(key).getAnswers().stream()
                .map(Answer::isCorrect)
                .collect(Collectors.toList());
    }
}
