package generics.textbook;

import generics.Candy;
import generics.Chocolate;
import generics.Skittles;
import generics.Snickers;
import java1review.Book;

import java.math.BigDecimal;
import java.util.*;

// NumericFns attempts (unsuccessfully) to create
// a generic class that can compute various
// numeric functions, such as the reciprocal or the
// fractional component, given any type of number.
class NumericFns<T extends Number> {
    T num;

    // Pass the constructor a reference to
    // a numeric object.
    NumericFns(T n) {
        num = n;
    }

    // Return the reciprocal.
    double reciprocal() {
        return 1 / num.doubleValue(); // Error!
    }

    // Return the fractional component.
    double fraction() {
        return num.doubleValue() - num.intValue(); // Error!
    }

    boolean absEqual(NumericFns<?> ob) {
        return Math.abs(num.doubleValue()) == Math.abs(ob.num.doubleValue());
    }
}

// Demonstrate NumericFns.
class MainThree {
    public static void main(String args[]) {

        NumericFns<Integer> iOb =
                new NumericFns<Integer>(5);

        System.out.println("Reciprocal of iOb is " +
                iOb.reciprocal());
        System.out.println("Fractional component of iOb is " +
                iOb.fraction());

        System.out.println();

        NumericFns<Double> dOb =
                new NumericFns<Double>(5.25);

        System.out.println("Reciprocal of dOb is " +
                dOb.reciprocal());
        System.out.println("Fractional component of dOb is " +
                dOb.fraction());

        NumericFns<Integer> nf1= new NumericFns<>(6);
        NumericFns<Integer> nf5= new NumericFns<>(-6);
        System.out.println(nf1.absEqual(nf5));
        NumericFns<Double> nf2= new NumericFns<>(-6.0);
        System.out.println(nf1.absEqual(nf2));
        NumericFns<BigDecimal> nf3= new NumericFns<>(new BigDecimal("-6"));
        System.out.println(nf1.absEqual(nf3));
        NumericFns<Long> nf4= new NumericFns<>(6L);
        System.out.println(nf1.absEqual(nf4));

        List<Candy> candy = new ArrayList<>();
        candy.add(new Snickers());
        candy.add(new Skittles());
        Collections.reverse(candy);
        candy.forEach(System.out::println);

        Set<Book> books = new HashSet<>();
        books.add(new Book("Java a Beginner's Guide"));
        books.add(new Book("Candy Cravers"));
//        Collections.reverse(books);
        books.forEach(System.out::println);

        List<Integer> lottoNumbers = new ArrayList<>();
        Collections.addAll(lottoNumbers, 7,8,6,4,2,6, 82,7,1,9,6,8,5,3,2,4,1,7);
        Collections.sort(lottoNumbers);
        int result = Collections.binarySearch(lottoNumbers, 10);
        System.out.println(result);
        result = Collections.binarySearch(lottoNumbers, (int)'R');
        System.out.println(result);

    }
}