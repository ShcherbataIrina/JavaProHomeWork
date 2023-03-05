package ua.ithillel.lesson12;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] array = new double[10];
        double value = 5.25;
        for(int i = 0; i < array.length; i++){
            array[i] = value;
        }

        ArrayInitializer.init(array);

        System.out.println(Arrays.toString(array));
    }
}
