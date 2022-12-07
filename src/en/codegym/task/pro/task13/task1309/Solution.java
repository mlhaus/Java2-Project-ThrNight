package en.codegym.task.pro.task13.task1309;

import java.util.HashMap;

/*
Student performance
*/

public class Solution {
    public static HashMap<String, Long> grades = new HashMap<>();

    public static void main(String[] args) {
        addStudents();
        System.out.println(grades);
    }

    public static void addStudents() {
        grades.put("Marc", 100L);
        grades.put("Allison", 50000000000000000L);
//        grades.put("Amy", 5.5);
//        grades.put("Andrew", 5.5);
//        grades.put("Alan", 5.5);
    }
}
