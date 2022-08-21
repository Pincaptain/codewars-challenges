import java.util.Comparator;
import java.util.stream.Collectors;

public class NextBiggerNumberWithTheSameDigits {

    public static long nextBiggerNumber(long n) {
        if (!nextBiggerNumberExists(n)) {
            return -1;
        }

        long temp = n;

        while (true) {
            if (areMadeOfSameDigits(n, ++temp)) {
                return temp;
            }
        }
    }

    private static boolean nextBiggerNumberExists(long n) {
        return n != Long.parseLong(String.valueOf(n).chars()
                .mapToObj(value -> (char) value)
                .map(Character::getNumericValue)
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .collect(Collectors.joining()));
    }

    private static boolean areMadeOfSameDigits(long n, long m) {
        return String.valueOf(n).chars()
                .sorted()
                .boxed()
                .toList()
                .equals(String.valueOf(m).chars()
                        .sorted()
                        .boxed()
                        .toList());
    }

    public static void main(String[] args) {
        System.out.println(nextBiggerNumberExists(12));
    }
}
