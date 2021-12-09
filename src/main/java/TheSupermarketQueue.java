import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TheSupermarketQueue {

    public static int solveSuperMarketQueue(int[] customers, int n) {
        // If customers array is empty return 0
        if (customers.length == 0) {
            return 0;
        }

        // Initialize the waiting time
        int waitingTime = 0;

        // Create a new queue
        Queue<Integer> customersQueue = new LinkedList<>();

        // Populate the queue with the provided customers
        Arrays.stream(customers).forEach(customersQueue::add);

        // Create the tills array
        ArrayList<Integer> tills = new ArrayList<>();

        // Populate the tills array
        for (int i = 0; i < n; i++) {
            if (customersQueue.isEmpty()) break;
            tills.add(customersQueue.remove());
        }

        while (true) {
            for (int i = 0; i < tills.size(); i++) {
                if (tills.get(i) == 0) continue;

                tills.set(i, tills.get(i) - 1);

                if (!customersQueue.isEmpty()) {
                    if (tills.get(i) == 0) {
                        tills.set(i, customersQueue.remove());
                    }
                }
            }

            waitingTime++;

            if (tills.stream().allMatch(i -> i == 0)) {
                break;
            }
        }

        return waitingTime;
    }

    public static void main(String[] args) {
        System.out.println(solveSuperMarketQueue(new int[]{5}, 6));
    }
}
