package com.epam.javase.units.unit1.t04;

import java.util.Arrays;

public class SingleArray {

    public static void main(String[] args) {
        int[] myArray = generateRandomArray(10);
        int max = maxValue(myArray);
        System.out.println(Arrays.toString(myArray));
        System.out.println("Max = " + max);
    }

    /** Генерация массива на указанную длину, заполненного рандомными числами от -100 до 100.
     *
     *  @param length
     *      Длина массива
     *  @return
     *      Ссылка на массив чисел
     */
    public static int[] generateRandomArray(int length){
        int[] newArray = new int[length];
        for(int i = 0; i < length; i++){
            newArray[i] = (int)(Math.random() * 200 - 100);
        }
        return newArray;
    }

    /** Выбор максимального числа из массива
     *
     *  @param array
     *      Ссылка на массив
     *  @return
     *      Наибольшее число
     */
    public static int maxValue(int[] array){
        if(array.length == 1) return array[0];
        if(array.length == 2) return array[0] + array[1];
        int maxValue = array[0] + array[1];
        int i = 2;
        while(i < array.length){
            if(i == array.length - 1) {
                if (maxValue < array[i]) maxValue = array[i];
                break;
            }
            if(maxValue < array[i] + array[i + 1]) maxValue = array[i] + array[i + 1];
            i += 2;
        }
        return maxValue;
    }
}
