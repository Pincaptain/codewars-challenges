public class Maskify {

    public static String maskify(String str) {
        if (str.length() <= 4) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("#".repeat(str.length() - 4));
        sb.append(str.substring(str.length() - 4));

        return sb.toString();
    }
}
