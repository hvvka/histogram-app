package com.hania.stats.process;

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
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
public class DataConverterImplTest {

    private DataConverterImpl converter;
    private static final String RESOURCES_PATH = "src/test/resources";
    private static final Path SAMPLE_TEMPLATE_FILE_PATH = Paths.get(RESOURCES_PATH, "sample-template.xml");
    private static final Path EXPECTED_TEMPLATE_FILE_PATH = Paths.get(RESOURCES_PATH, "expected-template.xml");
    private static final Path ANSWERS_FILE_PATH = Paths.get(RESOURCES_PATH,"answers.csv");

    @Before
    public void init() {
        converter = new DataConverterImpl();
    }

    @Test
    public void loadData() throws IOException {
        // when
        converter.loadData(SAMPLE_TEMPLATE_FILE_PATH, ANSWERS_FILE_PATH);

        // then
        Set<StudentsAnswers> expectedStudents = AnswersGenerator.sampleStudents();
        assertEquals(expectedStudents, converter.getStudentsAnswers());

        // and
        String expectedTemplate = getExpectedTemplate(EXPECTED_TEMPLATE_FILE_PATH);
        String actualTemplate = getActualTemplate(converter.getTemplate());
        assertEquals(expectedTemplate, actualTemplate);
    }

    private String getActualTemplate(Template template) {
        XStream xStream = new TemplateXStream();
        return xStream.toXML(template);
    }

    private String getExpectedTemplate(Path expectedTemplateFile) {
        try {
            byte[] encoded = Files.readAllBytes(expectedTemplateFile.toAbsolutePath());
            return new String(encoded, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}