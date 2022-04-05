public class GiveMeADiamond {

    public static String print(int n) {
        if (n <= 0 || n % 2 == 0) {
            return null;
        }
        n = (n / 2) + 1;
        StringBuilder sb = new StringBuilder();
        int spaces = n - 1;
        int stars = 1;
        int i = 1;
        while (i <= n) {
            sb.append(" ".repeat(Math.max(0, spaces)));
            sb.append("*".repeat(Math.max(0, stars)));
            sb.append("\n");
            spaces--;
            stars += 2;
            i++;
        }
        spaces = 1;
        stars -= 4;
        i--;
        while (i > 1) {
            sb.append(" ".repeat(Math.max(0, spaces)));
            sb.append("*".repeat(Math.max(0, stars)));
            sb.append("\n");
            spaces++;
            stars -= 2;
            i--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(print(4));
    }
}
