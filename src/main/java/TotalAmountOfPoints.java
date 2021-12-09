import java.util.Arrays;
import java.util.stream.Collectors;

public class TotalAmountOfPoints {

    public static int points(String[] games) {
        return Arrays.stream(games)
                .map(string -> string.split(":"))
                .map(strings -> Arrays.stream(strings).map(Integer::parseInt).collect(Collectors.toList()))
                .map(integers -> integers.get(0) > integers.get(1) ? 3 : integers.get(0) == integers.get(1) ? 1 : 0)
                .reduce(Integer::sum).orElse(0);
    }
}
