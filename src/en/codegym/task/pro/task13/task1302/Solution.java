package en.codegym.task.pro.task13.task1302;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

/*
Verifying existence
*/

public class Solution {
    public static Set<String> languagesIKnow =
            new HashSet<>(asList("HTML CSS JavaScript SQL Java Python".split(" ")));

    public static void checkWords(String word) {
        System.out.println(String.format("The word %s %s in the set",
                word, languagesIKnow.contains(word) ? "is" : "is not"));
    }

    public static void main(String[] args) {
        checkWords("C#");
        checkWords("Java");
    }
}