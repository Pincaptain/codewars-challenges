public class HighAndLow {

    public static String highAndLow(String numbers) {
        String[] nums = numbers.split(" ");
        int max = Integer.parseInt(nums[0]);
        int min = Integer.parseInt(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int n = Integer.parseInt(nums[i]);
            if (n > max) {
                max = n;
            }
            if (n < min) {
                min = n;
            }
        }
        return max + " " + min;
    }
}
