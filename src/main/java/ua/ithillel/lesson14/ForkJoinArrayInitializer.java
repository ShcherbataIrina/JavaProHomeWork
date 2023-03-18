package ua.ithillel.lesson14;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinArrayInitializer {
    public static void init(double[] array) {

        var pool = new ForkJoinPool();
        ArrayInitializerCalculator task = new ArrayInitializerCalculator(array, 0, array.length);
        pool.invoke(task);

    }

    private static class ArrayInitializerCalculator extends RecursiveAction {
        private double[] array;
        private int start;
        private int end;

        private ArrayInitializerCalculator(double[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if (end - start <= 10) {

                for (int i = start; i < end; i++) {
                    array[i] = (array[i] * Math.sin(0.2 + i / 5.0) * Math.cos(0.2 + i / 5.0) * Math.cos(0.4 + i / 2.0));
                }
            } else {
                int half = (end - start) / 2;
                var fork1 = new ArrayInitializerCalculator(array, start, half);
                var fork2 = new ArrayInitializerCalculator(array, half, array.length);

                fork1.fork();
                fork2.fork();

                fork1.join();
                fork2.join();

            }

        }

    }
}
