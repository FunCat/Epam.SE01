package javase01.t05;

import java.util.Arrays;

public class MultyArray {

    public static void main(String[] args) {
        int length = 9;
        int[][] array = new int[length][length];
        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j || i == (length - 1 - j))
                    array[i][j] = 1;
                System.out.print(array[i][j]);
            }
            System.out.println("");
        }
    }


}
