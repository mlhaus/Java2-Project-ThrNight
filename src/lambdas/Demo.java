package lambdas;

import final_project.MyException;
import final_project.data.MyDAO;
import final_project.data.MyDAOFactory;
import java1review.Book;
import java1review.Person;

import java.time.*;
import java.time.format.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.*;

public class Demo {
    public static void main(String[] args) throws MyException {
        List<Integer> lottoNumbers = Arrays.asList(34, 49, 62, 16, 8, 6);
        lottoNumbers.forEach(System.out::println);


        MyDAO people_dao = MyDAOFactory.getMyDAO("csv").get(0);
        people_dao.readInData();
        List<Person> people = people_dao.getAll();
        String lookup = "ro";
        System.out.println("Retrieved:");


        MyAnalyzer<String> contains = (str1, str2) -> str1.toLowerCase().contains(str2.toLowerCase());
        people.forEach((person) -> {
            if(contains.analyze(person.getFirstName(), lookup) || contains.analyze(person.getLastName(), lookup)) {
                System.out.println(person.getFirstName() + " " + person.getLastName());
            }
        });
        System.out.println();

//        Consumer<String> nameLength = (str) -> System.out.println(str + " " + str.length());
//        people.forEach((person) ->  {
//            nameLength.accept(person.getFirstName());
//        });

        people.forEach((person) -> {
            int count = person.getFirstName().length();
            System.out.println(person.getFirstName() + " " + count);
        });

        Supplier<String> today = () -> {
          DateTimeFormatter df =  DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
          return df.format(ZonedDateTime.now());
        };
        System.out.println(today.get());

        Supplier<Integer> diceRoll = () -> ThreadLocalRandom.current().nextInt(1, 7);
        for(int i =0; i < 20; i++) {
            System.out.print(diceRoll.get() + " ");
        }
        System.out.println();

        Supplier<Book> bs = Book::new; // equivalent to () -> new Book()
        Book book1 = bs.get();
        Book book2 = bs.get();
        book1.setTitle("Java");
        book2.setTitle("C#");
        System.out.println(book1);
        System.out.println(book2);


        Consumer<Integer> factorial = (num) -> {
            int result = 1;
            for(int i = 2; i <= num; i++) {
                result *= i;
            }
            System.out.println(result);
        };
        factorial.accept(10);
        factorial.accept(5);
        factorial.accept(4);

        System.out.println(factorial(10));
        System.out.println(factorial(5));
        System.out.println(factorial(4));

        Consumer<Person> calcAge = (person) -> {
            System.out.println(person.toString() + ", Age: " + Period.between(person.getDateOfBirth().toLocalDate(), LocalDate.now()).getYears());
        };
        people.forEach((person) -> calcAge.accept(person));

        BiConsumer<Integer, Integer> sum = (n1, n2) -> System.out.println(n1 + n2);
        sum.accept(2,3);

        Map<String, LocalDate> coolpeople = new HashMap<>();
        coolpeople.put("Sam", LocalDate.of(2000, 9, 9));
        coolpeople.put("Samantha", LocalDate.of(2000, 12, 9));
        BiConsumer<String, LocalDate> calAge = (str, date) -> {
            System.out.println(str + ", Age: " + Period.between(date, LocalDate.now()).getYears());
        };
        coolpeople.forEach(calAge);

        Map<String, String> states = new HashMap<>();
        states.put("Iowa", "Des Moines");
        states.put("Wisconsin", "Madison");
        states.put("Minnesota", "St. Paul");
        BiConsumer<String, String> printCapital = (state, capital) -> System.out.println("The capital of " + state + " is " + capital);
        states.forEach(printCapital);

        Book book3 = bs.get();
        book3.setTitle("I Love Lambda Expressions");
        book3.setAuthor(people.get(people.size() - 2));

        Consumer<Book> figureOutAuthor = (book) -> {
            System.out.println("\"" +book.getTitle()+ ",\" wirtten by "+ book.getAuthor()+ ".");
        };
        figureOutAuthor.accept(book3);

        Consumer<Book> bookName = (book) -> System.out.println(book.getTitle() + ", written by" + book.getAuthor());
        bookName.accept(book3);

        Predicate<Integer> isEven = (num) -> num % 2 == 0;
        System.out.println("4 " + (isEven.test(4) ? "is even" : "is odd"));
        System.out.println("5 " + (isEven.test(5) ? "is even" : "is odd"));
        System.out.println("-4 " + (isEven.test(-4) ? "is even" : "is odd"));



        BiPredicate<String, String> firstName = (n1, n2) -> n1.equals(n2);
        Person a = new Person("James", "Monroe");
        Person b = new Person("James", "Madison");
        System.out.println(a + " " + (firstName.test(a.getFirstName(), b.getFirstName()) ? "True" : "False")) ;
        b = new Person("Joe", "Biden");
        System.out.println(a + " " + (firstName.test(a.getFirstName(), b.getFirstName()) ? "True" : "False")) ;

        List<Integer> nums = new ArrayList<>(Arrays.asList(8, -1, 9, -2, -6, 7));
        Predicate<Integer> noNeg = num -> num < 0;
        nums.removeIf(noNeg);
        nums.forEach(System.out::println);



        List<Integer> nums2 = new ArrayList<>(Arrays.asList(2,19,15,4,25,0,13));
        Predicate<Integer> noTeen = num -> num >= 13 && num <= 20;
        nums2.removeIf(noTeen);
        nums2.forEach(System.out::println);

        List<String> strs = new ArrayList<>(Arrays.asList("cat", "dog", "turtle", "pizza", "beef"));
        Predicate<String> no34 = str -> str.length() == 3 || str.length() == 4;
        strs.removeIf(no34);
        strs.forEach(System.out::println);
    }

    public static void sum (int n1, int n2) {
        System.out.println(n1 + n2);
    }

    public static int factorial(int num) {
        if(num == 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }



}
