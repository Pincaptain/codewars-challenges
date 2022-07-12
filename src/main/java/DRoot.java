import java.util.Arrays;

public class DRoot {

    public static int digitalRoot(int n) {
        return Arrays.stream(String.valueOf(n)
                .split(""))
                .map(Integer::parseInt)
                .reduce(Integer::sum)
                .map(s -> s < 10 ? s : digitalRoot(s))
                .orElse(0);
    }

    public static void main(String[] args) {
        System.out.println(digitalRoot(132189));
    }
}
