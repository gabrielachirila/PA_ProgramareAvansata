package org.example;

import java.io.Serializable;
import java.util.*;

public class Catalog implements Serializable {
    private String name;
    private List<Document> docs;
    public Catalog() {
        docs = new ArrayList<>();
    }
    public Catalog(String name) {
        this.name = name;
        docs = new ArrayList<>();
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

    public void addDocument(Document doc) {
        docs.add(doc);
    }

    public Document findById(String id) {
        return docs.stream()
                .filter(d -> d.getId().equals(id)).findFirst().orElse(null);
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
