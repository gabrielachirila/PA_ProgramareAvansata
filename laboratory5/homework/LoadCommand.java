package org.example;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LoadCommand implements Command{
    private String  location;
    private Catalog catalog;
    public LoadCommand(String path)
    {
        this.location = path;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            this.catalog = objectMapper.readValue(new File(path), Catalog.class);
        }
        catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void execute()
    {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Catalog catalog = objectMapper.readValue(new File(this.location), Catalog.class);
            this.catalog = catalog;
        }
        catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        final StringBuffer sb = new StringBuffer("From location ");
        sb.append(this.location).append(" the catalog ").append(catalog.toString());
        System.out.println(sb);
    }

}