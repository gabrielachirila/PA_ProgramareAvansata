package org.example;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ViewCommand implements Command {

    private Document document;

    public ViewCommand(Document doc) {
        this.document = doc;
    }

    public void execute() throws IOException {
        if (document.getLocation() != null) {
            Desktop.getDesktop().open(new File(document.getLocation()));
        }
        else {
            throw new RuntimeException("No path specified for document " + document.getTitle());
        }
    }
}
