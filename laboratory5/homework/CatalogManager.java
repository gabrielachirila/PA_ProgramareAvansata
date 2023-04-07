package org.example;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.IOException;

public class CatalogManager {
    public static void execute(Command c) throws Exception {
        c.execute();
    }
}