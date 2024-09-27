import java.math.BigInteger;

public class TotalIncreasingOrDecreasingNumbers {

    public static BigInteger totalIncDec(int n) {
        BigInteger total = BigInteger.ZERO;
        BigInteger[] inc = new BigInteger[n + 1];
        BigInteger[] dec = new BigInteger[n + 1];
        inc[0] = BigInteger.ONE;
        dec[0] = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            inc[i] = inc[i - 1].multiply(BigInteger.valueOf(10 - i));
            dec[i] = dec[i - 1].multiply(BigInteger.valueOf(i + 1));
            total = total.add(inc[i].add(dec[i]));
        }
        return total.subtract(BigInteger.ONE);
    }

    public static void main(String[] args) {
        System.out.println(totalIncDec(2));
    }
}
