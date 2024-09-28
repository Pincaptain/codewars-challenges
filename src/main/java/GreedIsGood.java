import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GreedIsGood {

    public static int greedy(int[] dice) {
        Map<Integer, Integer> threeOfAKind = Map.of(1, 1000, 2, 200, 3, 300, 4, 400, 5, 500, 6, 600);
        Map<Integer, Integer> single = Map.of(1, 100, 5, 50);
        Map<Integer, Integer> counts = Arrays.stream(dice).boxed().collect(HashMap::new,
                (map, key) -> map.put(key, map.getOrDefault(key, 0) + 1), HashMap::putAll);
        int score = 0;

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (value >= 3) {
                score += threeOfAKind.get(key);
                value -= 3;
            }

            score += single.getOrDefault(key, 0) * value;
        }

        return score;
    }

    public static void main(String[] args) {
        System.out.println(greedy(new int[]{5, 1, 3, 4, 1}));
        System.out.println(greedy(new int[]{1, 1, 1, 3, 1}));
        System.out.println(greedy(new int[]{2, 4, 4, 5, 4}));
    }
}
