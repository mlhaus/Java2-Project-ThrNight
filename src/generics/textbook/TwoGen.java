package generics.textbook;

import java1review.Person;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

// A simple generic class with two type
// parameters: T and V.
class TwoGen<T, V> {
    T ob1;
    V ob2;

    // Pass the constructor a reference to
    // an object of type T.
    TwoGen(T o1, V o2) {
        ob1 = o1;
        ob2 = o2;
    }

    // Show types of T and V.
    void showTypes() {
        System.out.println("Type of T is " +
                ob1.getClass().getSimpleName());

        System.out.println("Type of V is " +
                ob2.getClass().getSimpleName());
    }

    T getob1() {
        return ob1;
    }

    V getob2() {
        return ob2;
    }
}

// Demonstrate TwoGen.
class MainTwo {
    public static void main(String args[]) {

        TwoGen<Integer, String> tgObj =
                new TwoGen<Integer, String>(88, "Generics");

        // Show the types.
        tgObj.showTypes();

        // Obtain and show values.
        int v = tgObj.getob1();
        System.out.println("value: " + v);

        String str = tgObj.getob2();
        System.out.println("value: " + str);

        Person marc = new Person("Marc", "Hauschildt");
        LocalDate marcbd = LocalDate.of(1981, 2, 6);
        TwoGen<LocalDate, Person> birthday = new TwoGen<>(marcbd, marc);
        birthday.showTypes();
        LocalDate p = birthday.getob1();
        Person ld = birthday.getob2();
        
        Map<Person, LocalDate> birthdays = new HashMap<>();
    }
}