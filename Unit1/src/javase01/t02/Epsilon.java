package javase01.t02;

public class Epsilon {

    public static void main(String[] args) {
        float[] myArray = createArray(20);
        // Необходимо задать эпсилон
        int index = getIndex(myArray, 0.05f);
        if(index != -1) {
            System.out.println("Index = " + index);
            for (int i = 0; i < index; i++)
                System.out.print(myArray[i] + "; ");
            System.out.println(myArray[index] + ".");
        }
        else{
            System.out.println("Такого числа нету!");
        }
    }

    /** Создание массива на указанную длину.
     *  @param length
     *      Длина массива
     *  @return
     *      Ссылка на созданный массив
     * */
    public static float[] createArray(int length) {
        float[] newArray = new float[length];
        for (int i = 1; i < length + 1; i++)
            newArray[i - 1] = 1 / (float)Math.pow( i + 1, 2);
        return newArray;
    }

    /** Поиск индекса элемента, который удовлетворяет условию array[i] < eps
     *  @param array
     *     Ссылка на массив
     *  @param eps
     *      Число для сравнение
     *  @return
     *      Индекс
     * */
    public static int getIndex(float[] array, float eps){
        for(int i = 1; i < array.length + 1; i++)
            if(array[i - 1] < eps) return i - 1;
        return -1;
    }

}
