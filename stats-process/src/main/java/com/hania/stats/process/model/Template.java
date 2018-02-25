package com.hania.stats.process.model;

import java.util.List;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class Template {

    private List<Exercise> questions;

    public Template(List<Exercise> questions) {
        this.questions = questions;
    }

    public Template() {
        super();
    }

    public List<Exercise> getQuestions() {
        return questions;
    }
}

//1. czy da się sensownie serializować mapę?
//2. stworzyć listę, która będzie zawierała obiekt, który będzie zawierał indeks; opakować
//3.
