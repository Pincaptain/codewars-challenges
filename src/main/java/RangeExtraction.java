import java.util.Stack;

public class RangeExtraction {

    public static String rangeExtraction(int[] arr) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            Stack<Integer> chain = new Stack<>();
            chain.push(arr[i]);

            if (i == arr.length - 1) {
                result.append(arr[i]).append(",");
            }

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] - 1 == chain.peek()) {
                    chain.push(arr[j]);

                    if (j == arr.length - 1) {
                        if (chain.size() == 1) {
                            result.append(arr[i]).append(",");
                        } else if (chain.size() == 2) {
                            result.append(arr[i]).append(",");
                            result.append(chain.pop()).append(",");
                            i++;
                        } else {
                            result.append(arr[i]).append("-").append(chain.pop()).append(",");
                            i += chain.size();
                        }
                    }
                } else {
                    if (chain.size() == 1) {
                        result.append(arr[i]).append(",");
                    } else if (chain.size() == 2) {
                        result.append(arr[i]).append(",");
                        result.append(chain.pop()).append(",");
                        i++;
                    } else {
                        result.append(arr[i]).append("-").append(chain.pop()).append(",");
                        i += chain.size();
                    }
                    break;
                }
            }
        }

        return result.substring(0, result.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(rangeExtraction(new int[]{-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20}));
    }
}
