package ua.ithillel.lesson14;

import java.util.concurrent.CompletableFuture;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public class SimpleCalculator {

    public CompletableFuture<Integer> squareSum(int first, int second) {

        CompletableFuture<Integer> future1 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return first * first;
            }
        });
        CompletableFuture<Integer> future2 = CompletableFuture.supplyAsync(new Supplier<Integer>() {
            @Override
            public Integer get() {
                return second * second;
            }
        });
        return future1.thenCombine(future2, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer int1, Integer int2) {
                return int1 + int2;

            }
        });

    }

}
