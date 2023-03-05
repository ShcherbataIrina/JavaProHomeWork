package ua.ithillel.lesson12;

public class ArrayInitializer {

    public static void init(double[] array) {
        int half = array.length / 2;

        double[] firstPart = new double[half];
        double[] secondPart = new double[half];
        System.arraycopy(array, 0, firstPart, 0, firstPart.length);
        System.arraycopy(array, half, secondPart, 0, secondPart.length);

        var thread1 = new Thread(new ArrayInitializerCalculator(firstPart), "thread-1");
        var thread2 = new Thread(new ArrayInitializerCalculator(secondPart), "thread-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.arraycopy(firstPart, 0, array, 0, firstPart.length);
        System.arraycopy(secondPart, 0, array, half , secondPart.length);
        System.out.println();
    }

    private record ArrayInitializerCalculator(double[] array) implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < array.length; i++) {
                array[i] = (array[i] * Math.sin(0.2 + i / 5.0) * Math.cos(0.2 + i / 5.0) * Math.cos(0.4 + i / 2.0));
            }
        }

    }

}

