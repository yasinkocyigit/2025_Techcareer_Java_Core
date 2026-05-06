package com.yasin.tutorials.javacore;

public class _12_Conditional_1 {

    public static void conditional1(int number){
        if(number>0){
            System.out.println("Sayı pozitif");
        }else {
            System.out.println("Sayı negatif");
        }
    }

    public static void conditional2(int number){
        if(number>0)
            System.out.println("Sayı pozitif");
        else
            System.out.println("Sayı negatif");
    }

    // PSVM
    public static void main(String[] args) {
        int number=5;

        // 1.YOL
        conditional1(number);

        // 2.YOL
        conditional2(number);
    }
}
