import java.util.List;
import java.util.stream.Collectors;

public class NumberToReverseDigitsArray {

    private static int[] digitize(long n) {
        List<Integer> integers = String.valueOf(n)
                .chars()
                .mapToObj(c -> (char)c)
                .map(c -> Integer.valueOf(String.valueOf(c)))
                .collect(Collectors.toList());
        int count = 0;
        int[] array = new int[integers.size()];
        for (int i = integers.size() - 1; i >= 0; i--, count++) {
            array[count] = integers.get(i);
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = digitize(3151789);
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%d ", array[i]);
        }
    }
}
