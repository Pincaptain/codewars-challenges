import java.util.Arrays;
import java.util.stream.IntStream;

import static java.lang.Math.sqrt;

public class PrimeStreaming {

    private static final int LIMIT = 15485864;

    private static final int[] primes = new int[LIMIT];

    public static IntStream stream() {
        initialize();

        return IntStream.iterate(2, n -> n + 1)
                .filter(n -> primes[n] == 1);
    }

    private static void initialize() {
        Arrays.fill(primes, 1);

        for (int i = 2; i <= sqrt(LIMIT); i++) {
            if (primes[i] == 0) {
                continue;
            }

            for (int j = 2; i * j < LIMIT; j++) {
                primes[i * j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        long startTime = System.nanoTime();

        stream()
                .limit(1000000)
                .forEach(System.out::println);

        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;

        System.out.println("Execution time: " + duration + "ms");
    }
}
