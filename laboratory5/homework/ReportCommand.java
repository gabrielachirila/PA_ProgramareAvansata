package org.example;

import java.io.*;
import java.util.*;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import java.awt.*;
import java.util.List;

public class ReportCommand implements Command{
    private Catalog catalog;
    private String filename;

    public ReportCommand(Catalog catalog, String filename) {
        this.catalog = catalog;
        this.filename = filename;
    }

    public void execute() throws Exception {
        Velocity.init();
        Template template = Velocity.getTemplate("./src/main/java/org/example/html-report.vm");

        VelocityContext context = new VelocityContext();
        context.internalPut("documents", catalog.getDocs());
        Writer writer = new StringWriter();
        ((org.apache.velocity.Template) template).merge(context, writer);

        System.out.println(writer);
    }
}
