import java.util.Arrays;

public class StripComments {

    public static String stripCommentsV2(String text, String[] commentSymbols) {
        String joinedCommentSymbols = Arrays.stream(commentSymbols)
                .reduce(new StringBuilder(), StringBuilder::append, StringBuilder::append)
                .toString();

        String result = Arrays.stream(text.split("\n"))
                .map(line -> line.split(String.format("([%s])", joinedCommentSymbols)))
                .map(lineArray -> lineArray.length > 0 ? lineArray[0] : "")
                .map(line -> line.equals(" ") ? line : line.replaceAll("\\s+$", ""))
                .reduce(new StringBuilder(), ((stringBuilder, s) -> stringBuilder.append(s).append("\n")), StringBuilder::append)
                .toString();

        return result.substring(0, result.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(stripCommentsV2("apples, pears # and bananas\ngrapes\nbananas !apples\n!jolly",
                new String[]{"#", "!"}));
    }
}
