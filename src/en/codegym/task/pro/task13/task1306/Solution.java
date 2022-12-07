package en.codegym.task.pro.task13.task1306;

import java.util.ArrayList;
import java.util.Collections;

/* 
Studying the methods of the Collections class. Part 1
*/

public class Solution {

    public static void copy(ArrayList<String> destination, ArrayList<String> source) {
        Collections.copy(destination, source);
    }

    public static void addAll(ArrayList<String> list, String... strings) {
        Collections.addAll(list, strings);
    }

    public static void replaceAll(ArrayList<String> list, String oldValue, String newValue) {
        Collections.replaceAll(list, oldValue, newValue);
    }

    public static void main(String[] args) {
        ArrayList<String> favoriteCandy = new ArrayList<>();
        addAll(favoriteCandy, "Nerds", "Laffy Taffy", "Rolos", "Butterfinger", "Starburst");
        System.out.println("My favorite candy as a kid:");
        for(String candy: favoriteCandy) {
            System.out.println("\t" + candy);
        }
        System.out.println();

        ArrayList<String> newCandy = new ArrayList<>();
        addAll(newCandy, "Reese's Peanut Butter Cups", "Peanut Butter m&m's");
        copy(favoriteCandy, newCandy);
        System.out.println("My favorite candy of all time:");
        for(String candy: favoriteCandy) {
            System.out.println("\t" + candy);
        }
        System.out.println();

        replaceAll(favoriteCandy, "Butterfinger", "Snickers");
        System.out.println("No, my actual favorite candy is:");
        for(String candy: favoriteCandy) {
            System.out.println("\t" + candy);
        }
        System.out.println();
    }
}