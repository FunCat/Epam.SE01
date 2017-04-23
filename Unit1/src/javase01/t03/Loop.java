package javase01.t03;

public class Loop {

    public static void main(String[] args) {
        f(10,20,1);
    }

    public static void f(int a, int b, int h){
        for(int i = a; i <= b; i += h){
            float res = (float)Math.tan(2 * i) - 3;
            System.out.printf("%d\t%.3f", i, res);
            System.out.println("");
        }
    }
}
