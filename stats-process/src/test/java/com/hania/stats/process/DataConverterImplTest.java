package com.hania.stats.process;

import com.hania.stats.process.model.Answer;
import com.hania.stats.process.model.Exercise;
import com.hania.stats.process.model.StudentsAnswers;
import com.hania.stats.process.model.Template;
import com.thoughtworks.xstream.XStream;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class DataConverterImplTest {

    private DataConverterImpl converter;

    @Before
    public void init() {
        converter = new DataConverterImpl();
    }

    @Test
    public void loadData() {
        // given TODO ścieżki dać na psf na atrybuty
        final String resourcesPath = "src/test/resources";
        final Path sampleTemplateFile = Paths.get(resourcesPath, "sample-template.xml");
        final Path expectedTemplateFile = Paths.get(resourcesPath, "expected-template.xml");
        final Path answersFile = Paths.get(resourcesPath,"answers.csv");
        Template templateBean = getTemplate();


        // when
        converter.loadData(sampleTemplateFile, answersFile);

        // then
        Set<StudentsAnswers> expectedStudents = getStudentsAnswers();
        assertEquals(expectedStudents, converter.getStudents());

        // and
        String expectedTemplate = getExpectedTemplate(expectedTemplateFile);
        String actualTemplate = getActualTemplate(converter.getTemplate());
        assertEquals(expectedTemplate, actualTemplate);
//        assertNotNull(expectedTemplateFile);
//        assertThat(converter.getTemplate(), sameBeanAs(templateBean));
//        Assert.assertEquals(converter.getTemplate(), templateBean);
    }

    private String getActualTemplate(Template template) {
        XStream xStream = new TemplateXStream();
        return xStream.toXML(template);
    }

    private String getExpectedTemplate(Path sampleTemplateFile) {
        try {
            byte[] encoded = Files.readAllBytes(sampleTemplateFile.toAbsolutePath());
            return new String(encoded, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

//    private Template getExpectedTemplate(Path generatedTemplateFile) {
//        try {
//            XStream xStream = new TemplateXStream();
//            Template templateBean = new Template();
//            xStream.toXML(templateBean, new FileOutputStream(String.valueOf(generatedTemplateFile)));
//            return templateBean;
//        } catch (IOException e) {
//            throw new UncheckedIOException(e);
//        }
//    }

    private Template getTemplate() {
        List<Exercise> questionList = new ArrayList<>();

        final String question1 = "Semafory Dijkstry";
        final String q1answer1 = "Sluza do synchronizacji procesow wspolbieznych";
        final String q1answer2 = "Sa to flagi dwustanowe, na ktorych zdefiniowane sa nieprzerywalne operacje P i V";

        final String question2 = "Algorytm przelaczania procesow w systemie Unix";
        final String q2answer1 = "Jest algorytmem z wywlaszczeniem procesow systemowych i uzytkowych";
        final String q2answer2 = "Jest algortmem priorytetowym, w którym priorytet jest wewnetrznie zmieniany w " +
                "trakcie wykonywania procesu";

        questionList.add(new Exercise(1, question1,
                Arrays.asList(new Answer(q1answer1, true), new Answer(q1answer2, false))));
        questionList.add(new Exercise(2, question2,
                Arrays.asList(new Answer(q2answer1, false), new Answer(q2answer2, true))));

        return new Template(questionList);
    }

    private Set<StudentsAnswers> getStudentsAnswers() {
        return Stream.of(
                new StudentsAnswers("Preston", Arrays.asList(Arrays.asList(true, false), Arrays.asList(false, true))),
                new StudentsAnswers("Bober", Arrays.asList(Arrays.asList(false, false), Arrays.asList(true, true))))
                .collect(Collectors.toSet());
    }

    @Test
    public void createScoreHistogram() {
    }

    @Test
    public void createMarkHistogram() {
    }

    @Test
    public void createExerciseHistogram() {
    }
}