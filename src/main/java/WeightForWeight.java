import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class WeightForWeight {

    static class Weight {

        private String value;
        private int sumOfDigits;

        public Weight(String value, int sumOfDigits) {
            this.value = value;
            this.sumOfDigits = sumOfDigits;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getSumOfDigits() {
            return sumOfDigits;
        }

        public void setSumOfDigits(int sumOfDigits) {
            this.sumOfDigits = sumOfDigits;
        }
    }

    public static String orderWeight(String strng) {
        return Arrays.stream(strng.trim().split("\s+"))
                .map(s -> new Weight(s, s.chars()
                        .mapToObj(c -> (char) c)
                        .map(c -> Integer.parseInt(String.valueOf(c)))
                        .reduce(Integer::sum).orElse(0)))
                .sorted(Comparator.comparing(Weight::getSumOfDigits).thenComparing(Weight::getValue))
                .map(Weight::getValue)
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {

    }
}
