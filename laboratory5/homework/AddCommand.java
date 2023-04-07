package org.example;

public class AddCommand implements Command{
    private Catalog catalog;
    private Document document;
    public AddCommand(Catalog c, Document d)
    {
        this.catalog = c;
        this.document = d;
    }

    public void execute()
    {
        this.catalog.addDocument(document);
    }
}
