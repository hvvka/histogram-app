package com.hania.stats.process;

import com.hania.stats.process.model.Answer;
import com.hania.stats.process.model.Question;
import com.hania.stats.process.model.Template;
import com.thoughtworks.xstream.XStream;

/**
 * The custom XStream setting to parse the XML template.
 *
 * @author <a href="mailto:226154@student.pwr.edu.pl">Hanna Grodzicka</a>
 */
class TemplateXStream extends XStream {

    /**
     * Default constructor that sets aliases for XML tags.
     */
    TemplateXStream() {
        super();
        this.alias("template", Template.class);
        this.alias("exercise", Question.class);
        this.alias("answer", Answer.class);
    }
}
