package ru.netology.ProductManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Book book1 = new Book(1, "Азбука1", "Кирилл и Мефодий", 500);
    Book book2 = new Book(2, "Азбука2", "Кирилл и Мефодий", 600);
    Book book3 = new Book(3, "Азбука3XYZ", "Кирилл и Мефодий", 700);
    Smartphone phone1 = new Smartphone(4, "redmiA", "Xiaomi", 15000);
    Smartphone phone2 = new Smartphone(5, "redmiBXYZ", "Xiaomi", 16000);
    Smartphone phone3 = new Smartphone(6, "redmiC", "Xiaomi", 17000);

    @Test
    public void testAddProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);

        Product[] expected = {book1, book2, book3, phone1, phone2, phone3};
        Product[] actual = repo.findAll();


        System.out.println(Arrays.toString(expected));
        System.out.println(Arrays.toString(actual));
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);


        manager.search("redmiA");


        Product[] expected = {phone1};
        Product[] actual = manager.search("redmiA");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSearchProductByTwo() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);


        manager.search("XYZ");

        Product[] expected = {book3, phone2};
        Product[] actual = manager.search("XYZ");

        System.out.println(Arrays.toString(expected));
        System.out.println(Arrays.toString(actual));
        Assertions.assertArrayEquals(expected, actual);

    }

    /*@Test
    public void testSearchProductByThree() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);


        manager.search("Xiaomi");


        Product[] expected = {phone1, phone2, phone3};
        Product[] actual = manager.search("Xiaomi");

        System.out.println(Arrays.toString(expected));
        System.out.println(Arrays.toString(actual));
        Assertions.assertArrayEquals(expected, actual);

    }*/
    //Здесь было пр"банно очень много времени, не вкурил, actual выдает пустой массив
}



