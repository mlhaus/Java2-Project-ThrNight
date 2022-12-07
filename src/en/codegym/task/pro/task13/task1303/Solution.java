package en.codegym.task.pro.task13.task1303;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/*
Displaying the elements of a set
*/

public class Solution {

    public static void print(HashSet<String> words) {
        int i = 0;
        while(i < 6) {
            System.out.println(i);
            i++;
        }
        System.out.println();

        for(i = 0; i < 6; i++) {
            System.out.println(i);
        }
        System.out.println();


        Iterator<String> it = words.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println();

        for(it = words.iterator(); it.hasNext(); ) {
            System.out.println(it.next());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        HashSet<String> words = new HashSet<>(Arrays.asList("Programming is usually taught using examples.".split(" ")));
        print(words);
    }
}
