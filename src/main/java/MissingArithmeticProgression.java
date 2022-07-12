import java.util.Comparator;
import java.util.HashMap;

public class MissingArithmeticProgression {

    public static int findMissing(int[] numbers) {
        HashMap<Integer, Integer> differenceMap = new HashMap<>();

        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers.length - 1) break;
            int difference = Math.abs(numbers[i] - numbers[i + 1]);
            if (differenceMap.containsKey(difference)) {
                int currentDifference = differenceMap.get(difference);
                differenceMap.put(difference, ++currentDifference);
            } else {
                differenceMap.put(difference, 1);
            }
        }

        int mostCommonDifference = differenceMap.keySet()
                .stream()
                .max(Comparator.comparing(differenceMap::get))
                .orElse(0);

        for (int i = 0; i < numbers.length; i++) {
            if (i == numbers.length - 1) break;
            int currentNumber = numbers[i];
            int nextNumber = numbers[i + 1];
            if (Math.abs(currentNumber - nextNumber) != mostCommonDifference) {
                if (currentNumber > nextNumber) {
                    return currentNumber -= mostCommonDifference;
                } else {
                    return currentNumber += mostCommonDifference;
                }
            }
        }

        return numbers[0];
    }

    public static void main(String[] args) {
        System.out.println(findMissing(new int[]{4, 3, 1}));
    }
}
