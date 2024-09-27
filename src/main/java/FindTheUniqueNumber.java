import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class FindTheUniqueNumber {

    public static double findUniq(double arr[]) {
        return Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(Double::doubleValue, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(-1D);
    }

    public static void main(String[] args) {
        System.out.println(findUniq(new double[]{1, 1, 1, 2, 1, 1}));
    }
}
