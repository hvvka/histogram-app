package com.hania.stats.process;

import com.hania.stats.process.model.Answer;
import com.hania.stats.process.model.Exercise;
import com.hania.stats.process.model.Template;
import com.thoughtworks.xstream.XStream;

import java.util.ArrayList;

/**
 * @author <a href="mailto:hanna.grodzicka@fingo.pl">Hanna Grodzicka - FINGO</a>
 */
class TemplateXStream extends XStream {

    TemplateXStream() {
        super();
        this.alias("template", Template.class);
        this.alias("exercise", Exercise.class);
        this.alias("answer", Answer.class);
    }
}
