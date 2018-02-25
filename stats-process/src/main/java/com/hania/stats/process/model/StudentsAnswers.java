package com.hania.stats.process.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class StudentsAnswers {

    /**
     * Student's name. May be full name with the index.
     */
    private final String name;

    /**
     * The map associating question's number with the list of student's answers.
     */
    private final Map<Integer, List<Boolean>> answers;

    public StudentsAnswers(String name, Map<Integer, List<Boolean>> answers) {
        this.name = name;
        this.answers = answers;
    }

    public String getName() {
        return name;
    }

    public Map<Integer, List<Boolean>> getAnswers() {
        return answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentsAnswers that = (StudentsAnswers) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(answers, that.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, answers);
    }

}
