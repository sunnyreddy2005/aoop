package com.array;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArraySumTest {

    @Test
    public void testSumOfPositiveElements() {
        int[] positiveArray = {1, 2, 3, 4, 5};
        int result = ArraySum.sumOfArrayElements(positiveArray);
        assertEquals(15, result);
    }

    @Test
    public void testSumOfNegativeElements() {
        int[] negativeArray = {-1, -2, -3, -4, -5};
        int result = ArraySum.sumOfArrayElements(negativeArray);
        assertEquals(-15, result);
    }

    @Test
    public void testSumOfMixedElements() {
        int[] mixedArray = {1, -2, 3, -4, 5};
        int result = ArraySum.sumOfArrayElements(mixedArray);
        assertEquals(3, result);
    }

    @Test
    public void testSumOfEmptyArray() {
        int[] emptyArray = {};
        int result = ArraySum.sumOfArrayElements(emptyArray);
        assertEquals(0, result);
    }
}

