package com.epam.javase.units.unit1.t03;

public class Loop {

    public static void main(String[] args) {
        f(10,30,1);
    }

    public static void f(int a, int b, int h){
        for(int i = a; i <= b; i += h){
            float res = (float)Math.tan(2 * i) - 3;
            System.out.printf("%d\t%.3f", i, res);
            System.out.println("");
        }
    }
}
