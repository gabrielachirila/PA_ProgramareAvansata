package org.example;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class CatalogManager {
    public static void save(Catalog catalog, String path)
    {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(
                    new File(path),
                    catalog);
        }
        catch (IOException e)
        {
            System.out.println("File can't be opened!");
        }
    }
    public static Catalog load(String path)
    {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Catalog catalog = objectMapper.readValue(
                    new File(path),
                    Catalog.class);
            return catalog;
        }
        catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void add(Catalog catalog, Document doc)
    {
            Catalog.add(doc);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CatalogManager{");
        sb.append('}');
        return sb.toString();
    }
}
