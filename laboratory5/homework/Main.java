package org.example;

import java.io.IOException;
import freemarker.template.TemplateException;

public class Main {
    public static void main(String[] args) throws Exception {
        Catalog catalog =
                new Catalog("MyDocuments");
        var article = new Document("1","article1");
        article.addTag("author","James Clear");
        article.addTag("title","The Ultimate Productivity Hack is Saying No");
        article.setLocation("C:/Users/gaby/OneDrive/Desktop/article1.txt");

        var book = new Document("2","book1");
        book.addTag("author", "Ion Creanga");
        book.addTag("title", "Amintiri din Copilarie");
        //book.setLocation("C:/Users/gaby/OneDrive/Desktop/document2.json");


        CatalogManager.execute(new AddCommand(catalog,article));
        CatalogManager.execute(new AddCommand(catalog,book));
        CatalogManager.execute(new ListCommand(catalog));
        CatalogManager.execute(new SaveCommand(catalog,"C:/Users/gaby/OneDrive/Desktop/catalog1.json"));
        CatalogManager.execute(new LoadCommand("C:/Users/gaby/OneDrive/Desktop/catalog1.json"));
        CatalogManager.execute(new ViewCommand(article));
        //CatalogManager.execute(new ViewCommand(book))
        //CatalogManager.execute(new ReportCommand(catalog,"C:/Users/gaby/OneDrive/Desktop/raport.html"));
    }
}

