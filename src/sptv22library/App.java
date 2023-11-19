/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sptv22library;

import managers.HistoryManager;
import managers.ReaderManager;
import entity.Book;
import entity.History;
import entity.Reader;
import java.util.Arrays;
import java.util.Scanner;
import managers.BookManager;

/**
 *
 * @author admin
 */
public class App {
    private final Scanner scanner; 
    private Book[] books;
    private Reader[] readers;
    private History[] histories;
    private final BookManager bookManager;
    private final ReaderManager readerManager;
    private final HistoryManager historyManager;

    public App() {
        this.scanner = new Scanner(System.in);
        this.books = new Book[0];
        this.readers = new Reader[0];
        this.histories = new History[0];
        this.bookManager = new BookManager(scanner);
        this.readerManager = new ReaderManager(scanner);
        this.historyManager = new HistoryManager(scanner,readerManager,bookManager);
    }
    
    
    
    public void run() {
        boolean repeat = true;
        System.out.println("------- Library -------");
        do{
            System.out.println("List taks:");
            System.out.println("0. Exit");
            System.out.println("1. Add new book");
            System.out.println("2. Print list books");
            System.out.println("3. Add new reader");
            System.out.println("4. Print list readers");
            System.out.println("5. Take out book");
            System.out.println("6. Print list reading books");
            
            System.out.print("Enter task number: ");
            int task = scanner.nextInt(); scanner.nextLine();
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    this.books = Arrays.copyOf(this.books, this.books.length+1);
                    this.books[this.books.length - 1] = bookManager.addBook();
                    break;
                case 2:
                    bookManager.printListBooks(books);
                    break;
                case 3:
                    this.readers = Arrays.copyOf(this.readers, this.readers.length+1);
                    this.readers[this.readers.length - 1] = readerManager.addReader(readers);
                    break;
                case 4:
                    readerManager.printListReaders(readers);
                    break;
                case 5:
                    this.histories = Arrays.copyOf(this.histories, this.histories.length+1);
                    this.histories[this.histories.length - 1] = historyManager.takeOutBook(books, readers);
                    break;
                case 6:
                    historyManager.printListReadingBooks(histories);
                    break;
                default:
                    System.out.println("Select from list tasks!");
            }
            System.out.println("-----------------------");
        }while(repeat);
        System.out.println("By-by!");
    }
    
}
