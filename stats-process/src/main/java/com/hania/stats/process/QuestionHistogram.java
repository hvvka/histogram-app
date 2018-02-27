package com.hania.stats.process;

import com.hania.stats.process.model.Answer;
import com.hania.stats.process.model.Question;
import com.hania.stats.process.model.StudentsAnswers;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Creates question histogram.
 *
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
class QuestionHistogram {

    /**
     * {@link Histograms#createQuestionHistogram(List, Set)}
     */
    Map<Integer, Integer> createQuestionHistogram(List<Question> questions, Set<StudentsAnswers> students) {
        return IntStream.range(0, questions.size())
                .boxed()
                .collect(Collectors.toMap(i -> i + 1,
                        i -> countCorrectAnswers(i, filterOnlyAnswers(questions.get(i).getAnswers()), students)));
    }

    /**
     * Filters through the list of answers to husk only the list of booleans.
     *
     * @param answers the list of answers
     * @return the list of booleans
     */
    private List<Boolean> filterOnlyAnswers(List<Answer> answers) {
        return answers.stream()
                .map(Answer::isCorrect)
                .collect(Collectors.toList());
    }

    /**
     * Counts correct answers obtained from the student.
     *
     * @param key question's number (id)
     * @param answers the list of student's answers
     * @param students the set of StudentsAnswers
     * @return the number of correct answers
     */
    private int countCorrectAnswers(Integer key, List<Boolean> answers, Set<StudentsAnswers> students) {
        return (int) students.stream()
                .map(s -> s.getAnswers().get(key))
                .filter(a -> a.equals(answers))
                .count();
    }
}
