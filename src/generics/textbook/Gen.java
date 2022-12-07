package generics.textbook;

import generics.Candy;
import generics.Skittles;
import java1review.Book;

// A simple generic class.
// Here, T is a type parameter that
// will be replaced by a real type
// when an object of type Gen is created.
class Gen<T> {
    T ob; // declare an object of type T

    // Pass the constructor a reference to
    // an object of type T.
    Gen(T o) {
        ob = o;
    }

    // Return ob.
    T getob() {
        return ob;
    }

    // Show type of T.
    void showType() {
        System.out.println("Type of T is " +
                ob.getClass().getSimpleName());
    }
}

// Demonstrate the generic class.
class Main {
    public static void main(String args[]) {
        // Create a Gen reference for Integers.
        Gen<Integer> iOb = new Gen<>(88);

        // Show the type of data used by iOb.
        iOb.showType();

        // Get the value in iOb. Notice that
        // no cast is needed.
        int v = iOb.getob();
        System.out.println("value: " + v);

        System.out.println();

        // Create a Gen object for Strings.
        Gen<String> strOb = new Gen<String>("Generics Test");

        // Show the type of data used by strOb.
        strOb.showType();

        // Get the value of strOb. Again, notice
        // that no cast is needed.
        String str = strOb.getob();
        System.out.println("value: " + str);

        Gen<Candy> candyObj = new Gen<>(new Skittles());
        candyObj.showType();
        Candy candy = candyObj.getob();
        System.out.println("value: " + candy);

        Gen<Character> doubleObj;
    }
}
