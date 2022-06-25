import java.util.stream.Collectors;

public class PangramChecker {

    public static boolean check(String sentence) {
        return sentence.chars()
                .mapToObj(value -> (char)value)
                .map(Character::toLowerCase)
                .filter(Character::isAlphabetic)
                .collect(Collectors.toSet())
                .size() == 26;
    }

    public static void countCharacters(String sentence) {
        sentence.chars()
                .mapToObj(value -> (char)value)
                .map(Character::toLowerCase)
                .map(Character::isAlphabetic)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        String sentence = "The quick brown fox jumps over the lazy dog.";
        countCharacters(sentence);
    }
}
