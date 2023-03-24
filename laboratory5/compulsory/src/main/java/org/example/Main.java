package org.example;

public class Main {
    public static void main(String[] args) {
        Catalog catalog =
                new Catalog("MyDocuments");
        var book = new Document("article1");
        book.setId("1");
        book.setLocation("Iasi");
        book.addTag("autor","Abel");

        var article = new Document("book1");
        catalog.add(book);
        catalog.add(article);

        CatalogManager.save(catalog, "C:/Users/gaby/OneDrive/Desktop/catalog.json");

        Catalog catalog1 = new Catalog("Catalog2");
        CatalogManager.load("C:/Users/gaby/OneDrive/Desktop/catalog.json");
        System.out.println(catalog1);
    }
}

