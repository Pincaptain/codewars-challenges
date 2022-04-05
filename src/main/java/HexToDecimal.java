public class HexToDecimal {

    public static int hexToDecimal(String hex) {
        int decimal = 0;
        boolean isNegative = false;
        for (int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(i);
            if (c == '-') {
                isNegative = true;
            } else if (c >= '0' && c <= '9') {
                decimal = decimal * 16 + (c - '0');
            } else if (c >= 'A' && c <= 'F') {
                decimal = decimal * 16 + (c - 'A' + 10);
            } else if (c >= 'a' && c <= 'f') {
                decimal = decimal * 16 + (c - 'a' + 10);
            }
        }
        return isNegative ? -decimal : decimal;
    }

    public static void main(String[] args) {
        System.out.println(hexToDecimal("1A"));
    }
}
