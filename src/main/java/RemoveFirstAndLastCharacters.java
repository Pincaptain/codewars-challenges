public class RemoveFirstAndLastCharacters {

    private static String remove(String str) {
        return new StringBuilder(str).deleteCharAt(0)
                .deleteCharAt(str.length() - 2)
                .toString();
    }

    public static void main(String[] args) {
        System.out.println(remove("Borjan"));
    }
}
