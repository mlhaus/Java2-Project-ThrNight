import java1review.Book;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book();
        Book book2 = new Book("Java A Beginner's Guide", "Herbert Schildt", 850, true);
//        System.out.println(book1);
//        System.out.println(book2);
        Book[] library = new Book[5];
        library[0] = book1;
        library[1] = book2;
        library[2] = new Book();
        library[3] = new Book();
        for(Book book: library) {
            System.out.println(book);
        }
        for(int i = 0; i < Book.getBookCount(); i++) {
            System.out.println(library[i]);
        }
    }
}