package javase01.t04;

import java.util.Arrays;

public class SingleArray {

    public static void main(String[] args) {
        int[] myArray = generateRandomArray(4);
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
        int maxValue = array[0] + array[array.length - 1];
        int i = 1;
        int j = array.length - 2;
        while(j - i != -1){
            if(i == j) {
                if (maxValue < array[i]) maxValue = array[i];
                break;
            }
            if(maxValue < array[i] + array[j]) maxValue = array[i] + array[j];
            i++;
            j--;
        }
        return maxValue;
    }
}
