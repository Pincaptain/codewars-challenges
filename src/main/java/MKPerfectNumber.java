public class MKPerfectNumber {

    private static int sumOfDivisors(int n) {
        if (n == 1) {
            return 1;
        }

        int sum = n;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (i == (n / i)) {
                    sum += i;
                } else {
                    sum += (i + n / i);
                }
            }
        }

        return ++sum;
    }

    private static int calcFirst(int m, int k) {
        int i = 1;

        while (true) {
            int t = i;
            for (int j = 0; j < m; j++) {
                t = sumOfDivisors(t);
            }

            if (t == k * i) {
                break;
            }

            i++;
        }

        return i;
    }

    public static void main(String[] args) {
        System.out.println(calcFirst(2, 3));
    }
}
