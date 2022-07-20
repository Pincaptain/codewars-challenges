import java.util.Arrays;
import java.util.stream.Collectors;

public class SimplePigLatin {

    public static String pigItForWord(String word) {
        boolean isValidWord = word.chars()
                .mapToObj(c -> (char) c)
                .allMatch(Character::isAlphabetic);

        if (!isValidWord) {
            return word;
        }

        return word.substring(1) + word.charAt(0) + "ay";
    }

    public static String pigIt(String str) {
        return Arrays.stream(str.split("\s+"))
                .map(SimplePigLatin::pigItForWord)
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {

    }
}
