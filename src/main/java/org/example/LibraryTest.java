package org.example;

import org.example.entity.Book;
import org.example.entity.Library;

import java.util.List;

public class LibraryTest {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Преступление и наказание", "Фёдор Достоевский", 1866);
        Book book2 = new Book("Война и мир", "Лев Толстой", 1869);
        Book book3 = new Book("Анна Каренина", "Лев Толстой", 1877);
        Book book4 = new Book("Идиот", "Фёдор Достоевский", 1869);
        Book book5 = new Book("1984", "Джордж Оруэлл", 1949);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        System.out.println("Тестирование системы управления библиотекой");

        library.printAllBooks();

        library.printUniqueAuthors();

        library.printAuthorStatistics();

        System.out.println("\nКниги Льва Толстого:");
        List<Book> tolstoyBooks = library.findBooksByAuthor("Лев Толстой");
        for (Book book : tolstoyBooks) {
            System.out.println(book);
        }

        System.out.println("\nКниги 1869 года:");
        List<Book> books1869 = library.findBooksByYear(1869);
        for (Book book : books1869) {
            System.out.println(book);
        }

        System.out.println("\nУдаляем книгу '1984'");
        library.removeBook(book5);

        library.printAllBooks();
        library.printAuthorStatistics();
    }
}