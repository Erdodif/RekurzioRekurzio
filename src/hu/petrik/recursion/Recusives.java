package hu.petrik.recursion;

import java.util.Arrays;

public class Recusives {
    static String reapeatString(String string, int repeat) {
        if (repeat > 1) {
            return string + reapeatString(string, repeat - 1);
        }
        return string;
    }

    static int power(int number, int power) {
        if (power > 0) {
            return number * power(number, power - 1);
        }
        return 1;
    }

    static int nthFibonacci(int n) {
        if (n > 1) {
            return nthFibonacci(n - 1) + nthFibonacci(n - 2);
        }
        return 1;
    }

    static int bin(int n, int k) {
        if (k != n) {
            if (k == 0) {
                return 1;
            }
            if (n == 0) {
                return 0;
            }
            return bin(n - 1, k - 1) + bin(n - 1, k);
        }
        return 0;
    }

    static String reverseString(String s) {
        if (s.length() > 1) {
            return s.charAt(s.length() - 1) + reverseString(s.substring(0, s.length() - 1));
        }
        return s;
    }

    static int sum(int[] array) {
        if (array.length > 1) {
            int temp = array[0];
            array = Arrays.copyOfRange(array, 1, array.length);
            return temp + sum(array);
        }
        return array[0];
    }


}
