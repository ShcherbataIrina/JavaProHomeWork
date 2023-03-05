package ua.ithillel.lesson12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ArrayInitializerTest {
    @Test
    void shouldArrayInitializer(){
        double[] array = new double[10];
        int half = array.length / 2;
        double value = 5.25;

        for(int i = 0; i < array.length; i++){
            array[i] = value;
        }

        ArrayInitializer.init(array);
        for(int i = 0; i < half; i++) {
            assertEquals(array[i], array[half+i]);
        }
    }
}
