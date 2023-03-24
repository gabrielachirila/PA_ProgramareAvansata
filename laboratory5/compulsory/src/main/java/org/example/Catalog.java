package org.example;

import java.io.Serializable;
import java.util.*;

public class Catalog implements Serializable {
    private String name;
    private static List<Document> docs = new ArrayList<>();
    public static void add(Document doc) {
        docs.add(doc);
    }

    public Catalog() {
    }
    public Catalog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Document> getDocs() {
        return docs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDocs(List<Document> docs) {
        this.docs = docs;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Catalog{");
        sb.append("name='").append(name).append('\'');
        sb.append(", docs=").append(docs);
        sb.append('}');
        return sb.toString();
    }
}
