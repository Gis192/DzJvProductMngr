package ru.netology.ProductManager;

public class Book extends Product {
    private String author;

    public Book(int id, String name, String author, int price) {
        super(id, name, price);
        this.author = author;
    }

    public String getAuthor() {

        return author;
    }
}

