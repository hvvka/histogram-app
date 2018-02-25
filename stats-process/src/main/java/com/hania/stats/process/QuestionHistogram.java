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
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
class QuestionHistogram {

    // Map<K,V>
    // K = numer zadania
    // V = liczba poprawnych odpowiedzi na to zadanie
    Map<Integer, Integer> createQuestionHistogram(List<Question> questions, Set<StudentsAnswers> students) {
        return IntStream.range(0, questions.size())
                .boxed()
                .collect(Collectors.toMap(i -> i + 1,
                        i -> countCorrectAnswers(i, filterOnlyAnswers(questions.get(i).getAnswers()), students)));
    }

    private List<Boolean> filterOnlyAnswers(List<Answer> answers) {
        return answers.stream()
                .map(Answer::isCorrect)
                .collect(Collectors.toList());
    }

    private int countCorrectAnswers(Integer key, List<Boolean> answers, Set<StudentsAnswers> students) {
        return (int) students.stream()
                .map(s -> s.getAnswers().get(key))
                .filter(a -> a.equals(answers))
                .count();
    }
}
