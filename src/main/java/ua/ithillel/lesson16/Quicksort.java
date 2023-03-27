package ua.ithillel.lesson16;

public class Quicksort {
    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int chooseElement = partition(array, left, right);
        quickSort(array, left, chooseElement - 1);
        quickSort(array, chooseElement, right);
    }

    public static int partition(int[] array, int left, int right) {
        int middleIndex = left + (right - left) / 2;
        int middleValue = array[middleIndex];
        int leftIndex = left;
        int rightIndex = right;
        while (leftIndex <= rightIndex) {
            while (array[leftIndex] < middleValue) {
                leftIndex++;
            }
            while (array[rightIndex] > middleValue) {
                rightIndex--;
            }

            if (leftIndex > rightIndex) {
                break;
            } else {
                swap(array, leftIndex, rightIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    public static void swap(int[] array, int leftIndex, int rightIndex) {
        int temp = array[leftIndex];
        array[leftIndex] = array[rightIndex];
        array[rightIndex] = temp;
    }

}
