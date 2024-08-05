package com.library;

import com.library.service.BookService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class LibraryManagementApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = context.getBean("bookService", BookService.class);

        // Add some sample books
        bookService.addBook("The Silent Patient", "Alex Michalides", "9781409181637");
        bookService.addBook("1984", "George Orwell", "9780451524935");
        bookService.addBook("Pride and Prejudice", "Jane Austen", "9780141439518");
        bookService.addBook("The Great Gatsby", "F. Scott Fitzgerald", "9780743273565");
        bookService.addBook("The Woman in the window", "A,j Finn", "9780008294373");

        Scanner scanner = new Scanner(System.in);
        String choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. List all books");
            System.out.println("2. Search for a book by ISBN");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");

            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    bookService.listBooks();
                    break;
                case "2":
                    System.out.print("Enter the ISBN to search: ");
                    String isbn = scanner.nextLine();
                    bookService.findBookByIsbn(isbn);
                    break;
                case "3":
                    System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (!choice.equals("3"));

        scanner.close();
    }
}