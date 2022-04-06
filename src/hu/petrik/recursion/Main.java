package hu.petrik.recursion;

public class Main {

    public static void main(String[] args) {
        //printExceptHanoi();
        Hanoi.runHanoi(3);
    }

    static void printPyramid() {
        int tall = 12;
        for (int i = 0; i < tall; i++) {
            System.out.print(Recusives.reapeatString(" ", (tall - i) * 2));
            for (int j = 0; j < i; j++) {
                System.out.printf("%4d", Recusives.bin(i, j));
            }
            System.out.println();
        }
    }

    static void printExceptHanoi(){
        System.out.println(Recusives.reapeatString("pff;", 3));
        System.out.println(Recusives.power(2, 4));
        for (int i = 0; i < 10; i++) {
            System.out.print(Recusives.nthFibonacci(i) + " ");
        }
        printPyramid();
        System.out.println("ABCDE -> " + Recusives.reverseString("ABCDE"));
        System.out.println(Recusives.sum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
    }
}
