package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SaveCommand implements Command{

    private Catalog catalog;
    private String location;
    public SaveCommand(Catalog c, String path)
    {
        this.catalog = c;
        this.location = path;
    }

    public void execute()
    {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(location), catalog);
        }
        catch (IOException e)
        {
            System.out.println("File can't be opened!");
        }
    }
}