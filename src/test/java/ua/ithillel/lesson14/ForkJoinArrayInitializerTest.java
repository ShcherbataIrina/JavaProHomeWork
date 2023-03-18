package ua.ithillel.lesson14;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ForkJoinArrayInitializerTest {
    @Test
    void shouldArrayInitializer(){
        double[] array = new double[10];
        double[] expectedArray = new double[10];
        double value = 5.25;

        for(int i = 0; i < array.length; i++){
            array[i] = value;
            expectedArray[i] = value;
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] * Math.sin(0.2 + i / 5.0) * Math.cos(0.2 + i / 5.0) * Math.cos(0.4 + i / 2.0));
        }

        ForkJoinArrayInitializer.init(expectedArray);

            assertArrayEquals(array, expectedArray);

    }

}