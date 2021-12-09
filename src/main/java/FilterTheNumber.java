public class FilterTheNumber {

    public static long filterString(final String value) {
        return Long.parseLong(value.chars()
                .mapToObj(i -> (char) i)
                .filter(Character::isDigit)
                .reduce(new StringBuilder(), StringBuilder::append, StringBuilder::append)
                .toString());
    }

    public static void main(String[] args) {
        filterString("123");
    }
}
