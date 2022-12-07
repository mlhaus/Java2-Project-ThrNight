package generics;

import java1review.Book;
import java1review.Person;

public class Generics {
    public static void main(String[] args) {
        Box<Candy> box1 = new Box<>();
        Snickers snickers = new Snickers();
        add(snickers, box1);
        Skittles skittles = new Skittles();
        add(skittles, box1);
        Candy candy = box1.remove();
        add(skittles, box1);
        box1.remove();

        
    }

    public static <T extends Candy> void add(T item, Box<T> box) {
        box.add(item);
    }

    public static <T extends Candy> T remove(Box<T> box) {
        return box.remove();
    }


}
