import java1review.Book;

import java.util.*;
import java.util.function.Consumer;

public class Main {


    public static void main(String[] args) {
        Book book1 = new Book("PHP", "Marc Hauschildt", 300, true);
        Book book2 = new Book("Java A Beginner's Guide", "Herbert Schildt", 10, true);
//        System.out.println(book1);
//        System.out.println(book2);
        List<Book> library  = new ArrayList<>();
        library.add(book1);
        library.add(book2);
        library.add(new Book("PHP", "Unknown", 150, false));
        library.add(new Book());
        Collections.sort(library);
        for(Book book: library) {
            System.out.println(book);
        }
        Book bookToDelete = library.get(library.size() - 1);
        library.remove(library.size() - 1);
        System.out.println();
        for(int i = 0; i < library.size(); i++) {
            System.out.println(library.get(i));
        }
        System.out.println();
        library.forEach(book -> System.out.println(book));
        library.forEach(System.out::println);
    }
}