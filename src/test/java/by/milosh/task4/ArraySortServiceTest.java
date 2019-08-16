package by.milosh.task4;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;

public class ArraySortServiceTest {

    private ArraySortService arraySortService = new ArraySortService();

    @Test
    public void testSortArray() {
        int[] array = {5, 3, 2, 8, 1, 4};
        int[] expectedArray = {1, 3, 2, 8, 5, 4};
        int[] returnedArray = arraySortService.sortArray(array);
        boolean isTwoArraysEqual = Arrays.equals(returnedArray, expectedArray);
        assertTrue(isTwoArraysEqual);
    }
}
