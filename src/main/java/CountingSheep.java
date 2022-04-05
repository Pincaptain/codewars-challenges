import java.util.Arrays;
import java.util.Objects;

public class CountingSheep {

    public static int countSheep(Boolean[] array) {
        return (int) Arrays.stream(array)
                .filter(Objects::nonNull)
                .filter(Boolean::booleanValue)
                .count();
    }

    public static void main(String[] args) {
        System.out.println(countSheep(new Boolean[]{true, true, true, false, null}));
    }
}
