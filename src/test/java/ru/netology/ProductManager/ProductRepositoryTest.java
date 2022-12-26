package ru.netology.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();

    Book book1 = new Book(1, "Азбука1", "Кирилл и Мефодий", 500);
    Book book2 = new Book(2, "Азбука2", "Кирилл и Мефодий", 600);
    Book book3 = new Book(3, "Азбука3XYZ", "Кирилл и Мефодий", 700);
    Smartphone phone1 = new Smartphone(4, "redmiA", "Xiaomi", 15000);
    Smartphone phone2 = new Smartphone(5, "redmiXYZ", "Xiaomi", 16000);
    Smartphone phone3 = new Smartphone(6, "redmiC", "Xiaomi", 17000);

    @Test
    public void testAdd() {
        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(phone1);
        repo.add(phone2);
        repo.add(phone3);

        Product[] expected = {book1, book2, book3, phone1, phone2, phone3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testremoveById() {
        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(phone1);
        repo.add(phone2);
        repo.add(phone3);

        repo.removeById(2);

        Product[] expected = {book1, book3, phone1, phone2, phone3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testremoveByIdNull() {
        repo.add(book1);

        repo.removeById(1);

        Product[] expected = {};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testremoveByIdTwo() {
        repo.add(book1);
        repo.add(book2);
        repo.add(book3);
        repo.add(phone1);
        repo.add(phone2);
        repo.add(phone3);

        repo.removeById(2);
        repo.removeById(5);

        Product[] expected = {book1, book3, phone1, phone3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }
}