import java.util.Arrays;
import java.util.stream.Collectors;

public class SpinWords {

    public static String spinWords(String sentence) {
        return Arrays.stream(sentence.split(" "))
                .map(s -> s.length() <= 4 ? s : new StringBuilder(s).reverse().toString())
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        System.out.println(spinWords("Hey wollef sroirraw"));
    }
}
