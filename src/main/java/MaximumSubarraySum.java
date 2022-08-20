import java.util.Stack;

public class MaximumSubarraySum {

    public static int sequence(int[] arr) {
        Stack<Integer> sums = new Stack<>();
        sums.push(0);
        // 1 -2 4 9 -6 -1
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                sums.push(arr[j] + sums.peek());
            }
            sums.push(0);
        }

        return sums.stream()
                .max(Integer::compareTo)
                .orElse(0);
    }

    public static void main(String[] args) {
        System.out.println(sequence(new int[]{1, 2, 3, -8, 4, -1, 3}));
    }
}
