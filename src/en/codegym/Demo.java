package en.codegym;

import java.util.*;
import java.util.stream.Collectors;

public class Demo {
    public static void main(String[] args) {
        List<String> greetings = new ArrayList<>();
//        greetings.add("hello");
//        greetings.add("hola");
//        greetings.add("Bonjour");
//        greetings.add("Ciao");
//        greetings.add("Ciao");
//        greetings.add("Namaste");
//        greetings.add("hello");
        Collections.addAll(greetings, "hello", "hola", "bonjour", "ciao");
        System.out.println(String.join(", ", greetings));
        Collections.fill(greetings, "namaste");
        System.out.println(String.join(", ", greetings));
        List<String> greetingsImmutable = Collections.nCopies(4, "namaste");
        System.out.println(String.join(", ", greetingsImmutable));
//        greetingsImmutable.add("hello"); // Cannot add to an immutable list
//        System.out.println(String.join(", ", greetingsImmutable));
        ArrayList<Integer> nums = new ArrayList<>();
        Collections.addAll(nums, 8, 6, 9, 2, 6, 7);
        Collections.replaceAll(nums, 6, 5);
        System.out.println(nums.stream().map(Object::toString)
                .collect(Collectors.joining(", ")));
        ArrayList<Integer> nums2 = new ArrayList<>();
        Collections.addAll(nums, 1, 1, 1, 1);
        Collections.copy(nums, nums2);
        System.out.println(nums2.stream().map(Object::toString)
                .collect(Collectors.joining(", ")));
    }
}
