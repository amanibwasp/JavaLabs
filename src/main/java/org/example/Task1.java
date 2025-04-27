package org.example;

import java.util.HashSet;

public class Task1 {
    public static void main(String[] args) {
        String input = "abcabcbb";
        System.out.println("Наибольшая подстрока без повторений: " + longestUniqueSubstring(input));
    }

    public static String longestUniqueSubstring(String s) {
        if (s == null || s.isEmpty()) return "";

        HashSet<Character> set = new HashSet<>();
        String longest = "";
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (set.contains(c)) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(c);
            if (i - start + 1 > longest.length()) {
                longest = s.substring(start, i + 1);
            }
        }
        return longest;
    }
}
