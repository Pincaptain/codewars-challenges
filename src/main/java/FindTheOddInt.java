import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindTheOddInt {

    public static int findIt(int[] a) {
        HashMap<Integer, Integer> numberCountMap = new HashMap<>();

        Arrays.stream(a).forEach(value -> {
            if (!numberCountMap.containsKey(value)) {
                numberCountMap.put(value, 1);
            } else {
                numberCountMap.put(value, numberCountMap.get(value) + 1);
            }
        });

        return numberCountMap.entrySet().stream()
                .filter(entry -> entry.getValue() % 2 != 0)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(-1);
    }

    public static void main(String[] args) {
        System.out.println(findIt(new int[] {1, 1, 0}));
    }
}
