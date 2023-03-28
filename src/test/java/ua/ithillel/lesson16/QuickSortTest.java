package ua.ithillel.lesson16;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {
    @Test
    public void shouldQuickSort1() {
        int[] array = {8, 0, 4, 17, -3, 7, 36, 10, 12};
        QuickSort.quickSort(array, 0, array.length - 1);
        int[] expected = {-3, 0, 4, 7, 8, 10, 12, 17, 36};
        assertEquals(Arrays.toString(expected), Arrays.toString(array));
    }

    @Test
    public void shouldQuickSort2() {
        int[] array = {102, 85, -47, -35, 98, 10};
        QuickSort.quickSort(array, 0, array.length - 1);
        int[] expected = {-47, -35, 10, 85, 98, 102};
        assertEquals(Arrays.toString(expected), Arrays.toString(array));
    }

    @Test
    public void shouldQuickSort3() {
        int[] array = {-5, 15, 27, 9, 31, 23, 1};
        QuickSort.quickSort(array, 0, array.length - 1);
        int[] expected = {-5, 1, 9, 15, 23, 27, 31};
        assertEquals(Arrays.toString(expected), Arrays.toString(array));
    }
}