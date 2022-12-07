package en.codegym.task.pro.task13.task1308;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/* 
Studying the methods of the Collections class. Part 3
*/

public class Solution {

    public static int randomInt(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    public static void main(String[] args) {
        ArrayList<Integer> randNumbers = new ArrayList<>();
        for(int i = 0; i < 30; i++) {
            randNumbers.add(randomInt(1, 50));
        }
        System.out.println("30 random numbers between 1 and 50:");
        for(Integer i: randNumbers) {
            System.out.print(i + " ");
        }
        System.out.println();
        Collections.sort(randNumbers);
        System.out.println("The numbers sorted:");
        for(Integer i: randNumbers) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();

        System.out.println("Smallest number: " + Collections.min(randNumbers));
        System.out.println("Largest number: " + Collections.max(randNumbers));
        int randInt = randomInt(1, 20);
        System.out.println(randInt + " occurred " + Collections.frequency(randNumbers, randInt) + " " + (Collections.frequency(randNumbers, randInt) == 1 ? "time" : "times" + "."));

        randInt = randomInt(1, 20);
        int index = Collections.binarySearch(randNumbers, randInt);
        if(index >= 0) {
            System.out.println(randInt + " found at index " + index + ".");
        } else {
            System.out.println(randInt + " not found.");
        }
    }
}