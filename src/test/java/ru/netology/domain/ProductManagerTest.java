package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;


class ProductManagerTest {
    private ProductRepository repository = new ProductRepository();
    private ProductManager manager = new ProductManager(repository);

    @Test
    void searchByNameBook() {
        String text = "Колыбельная";
        Product first = new Book(1, "Мастер и Маргарита", 499, "Булгаков");
        Product second = new Book(2, "Колыбельная", 390, "Паланик");
        Product third = new Smartphone(1, "Iphone", 49900, "Apple");
        Product four = new Smartphone(2, "Samsung Galaxy", 29900, "Samsung");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);

        Product[] expected = new Product[]{second};
        Product[] actual = manager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByNameSmartphone() {
        String text = "Iphone";
        Product first = new Book(1, "Мастер и Маргарита", 499, "Булгаков");
        Product second = new Book(2, "Колыбельная", 390, "Паланик");
        Product third = new Smartphone(1, "Iphone", 49900, "Apple");
        Product four = new Smartphone(2, "Samsung Galaxy", 29900, "Samsung");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);

        Product[] expected = new Product[]{third};
        Product[] actual = manager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByAuthor() {
        String text = "Булгаков";
        Product first = new Book(1, "Мастер и Маргарита", 499, "Булгаков");
        Product second = new Book(2, "Собачье сердце", 390, "Булгаков");
        Product third = new Smartphone(1, "Iphone", 49900, "Apple");
        Product four = new Smartphone(2, "Samsung Galaxy", 29900, "Samsung");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);

        Product[] expected = new Product[]{first, second};
        Product[] actual = manager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByManufacturingCompany() {
        String text = "Samsung";
        Product first = new Book(1, "Мастер и Маргарита", 499, "Булгаков");
        Product second = new Book(2, "Колыбельная", 390, "Паланик");
        Product third = new Smartphone(1, "Iphone", 49900, "Apple");
        Product four = new Smartphone(2, "Samsung Galaxy", 29900, "Samsung");

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);

        Product[] expected = new Product[]{four};
        Product[] actual = manager.searchBy(text);

        assertArrayEquals(expected, actual);
    }

    @Test
    void searchByName() {
        String text = "Huawei";
        Product first = new Book(1, "Мастер и Маргарита", 499, "Булгаков");
        Product second = new Book(2, "Колыбельная", 390, "Паланик");
        Product third = new Smartphone(3, "Iphone", 49900, "Apple");
        Product four = new Product(4, "Samsung Galaxy", 29900);

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(four);

        Product[] expected = new Product[0];
        Product[] actual = manager.searchBy(text);

        assertArrayEquals(expected, actual);
    }
}