package en.codegym.task.pro.task13.task1307;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

/*
Studying the methods of the Collections class. Part 2
*/

public class Solution {

    public static void reverse(ArrayList<Integer> list) {
        Collections.reverse(list);
    }

    public static void sort(ArrayList<Integer> list) {
        Collections.sort(list);
    }

    public static void rotate(ArrayList<Integer> list, int distance) {
        Collections.rotate(list, distance);
    }

    public static void shuffle(ArrayList<Integer> list) {
        Collections.shuffle(list);
    }

    public static int randomInt(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

    public static void main(String[] args) {
        ArrayList<Integer> winningLottoNumbers = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            winningLottoNumbers.add(randomInt(1, 70));
        }
        System.out.println("Tonight's winning lotto numbers are:");
        for(Integer number: winningLottoNumbers) {
            System.out.println("\t" + number);
        }
        System.out.println();

        sort(winningLottoNumbers);
        System.out.println("Sorted:");
        for(Integer number: winningLottoNumbers) {
            System.out.println("\t" + number);
        }
        System.out.println();

        reverse(winningLottoNumbers);
        System.out.println("Reverse:");
        for(Integer number: winningLottoNumbers) {
            System.out.println("\t" + number);
        }
        System.out.println();

        rotate(winningLottoNumbers, 1);
        System.out.println("Shifted:");
        for(Integer number: winningLottoNumbers) {
            System.out.println("\t" + number);
        }
        System.out.println();

        shuffle(winningLottoNumbers);
        System.out.println("Random order:");
        for(Integer number: winningLottoNumbers) {
            System.out.println("\t" + number);
        }
        System.out.println();
    }
}