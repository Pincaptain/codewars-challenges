public class SumStringsAsNumbers {

    private static String trimNumberString(String numberString) {
        return numberString.replaceAll("^0+", "");
    }

    private static String[] getNumberStringsSizeArray(String a, String b) {
        return a.length() >= b.length() ? new String[]{a, b} : new String[]{b, a};
    }

    public static String sumStrings(String a, String b) {
        a = trimNumberString(a);
        b = trimNumberString(b);

        System.out.println(a);
        System.out.println(b);

        String[] numberStringsSizeArray = getNumberStringsSizeArray(a, b);
        String longerNumberString = new StringBuilder(numberStringsSizeArray[0]).reverse().toString();
        String shorterNumberString = new StringBuilder(numberStringsSizeArray[1]).reverse().toString();
        boolean hasReminder = false;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < longerNumberString.length(); i++) {
            if (i >= shorterNumberString.length()) {
                int currentDigit = Integer.parseInt(String.valueOf(longerNumberString.charAt(i)));
                if (hasReminder) {
                    currentDigit++;
                    hasReminder = currentDigit > 9;
                }
                result.append(currentDigit % 10);
                continue;
            }

            int aDigit = Integer.parseInt(String.valueOf(longerNumberString.charAt(i)));
            int bDigit = Integer.parseInt(String.valueOf(shorterNumberString.charAt(i)));
            int sum = aDigit + bDigit;

            if (hasReminder) {
                sum++;
            }

            hasReminder = sum > 9;

            result.append(sum % 10);
        }

        if (hasReminder) {
            result.append(1);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(sumStrings("800", "9567"));
    }
}
