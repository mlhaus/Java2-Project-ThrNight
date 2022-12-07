package generics.textbook;

import generics.*;
import java1review.*;

import java.math.*;
import java.util.*;

public class Pair <T, V extends T>{
}

class MainFour {
    public static void main(String[] args) {
        Pair<Candy, Chocolate> stuff;
        Pair<Number, BigDecimal> stuff2;
//        Pair<Snickers, Skittles> stuff3;
        
        List<Chocolate> candy = new ArrayList<>();
        Collections.addAll(candy, new Snickers());
        Collections.max(candy);
        
        List<Integer> nums = new ArrayList<>();
        Collections.addAll(nums, 6, 4, 9, 2);
        Collections.max(nums);
    }
}

