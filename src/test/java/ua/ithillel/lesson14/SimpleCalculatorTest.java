package ua.ithillel.lesson14;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class SimpleCalculatorTest {
    private final int first = 5;
    private final int second = 9;


    @Test
    void shouldCalculator() throws ExecutionException, InterruptedException {
        SimpleCalculator futureExample = new SimpleCalculator();

        int expectedSum = first * first + second * second;
        assertEquals(expectedSum, futureExample.squareSum(first, second).get());

    }

}