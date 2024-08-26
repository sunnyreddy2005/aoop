package com.array;

public class ArraySum {

   
    public static int sumOfArrayElements(int[] array) {
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return sum;
    }
}
