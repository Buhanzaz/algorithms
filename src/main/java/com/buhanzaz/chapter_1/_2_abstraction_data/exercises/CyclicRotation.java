package com.buhanzaz.chapter_1._2_abstraction_data.exercises;

public class CyclicRotation {
    public static void main(String[] args) {
        String t = "TGACGAC";
        String s = "ACTGACG";

        System.out.printf("\"%s\" it's a cyclic rotation of \"%s\": %s\n",
                t, s, isCircularShift(t, s) ? "yes" : "no");
    }

    public static boolean isCircularShift(String t, String s) {
        return t.length() == s.length() && (t + t).contains(s);
    }
}
