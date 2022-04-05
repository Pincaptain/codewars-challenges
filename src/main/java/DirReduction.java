import java.util.ArrayList;
import java.util.Arrays;

public class DirReduction {

    public static String[] filterRedundantMoves(String[] arr) {
        ArrayList<String> directions = new ArrayList<>(Arrays.asList(arr));
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < directions.size(); i++) {
            if (i == directions.size() - 1) {
                result.add(directions.get(i));

                break;
            }

            if (directions.get(i).equals("NORTH") && directions.get(i + 1).equals("SOUTH")) {
                i++;
            } else if (directions.get(i).equals("SOUTH") && directions.get(i + 1).equals("NORTH")) {
                i++;
            } else if (directions.get(i).equals("EAST") && directions.get(i + 1).equals("WEST")) {
                i++;
            } else if (directions.get(i).equals("WEST") && directions.get(i + 1).equals("EAST")) {
                i++;
            } else {
                result.add(directions.get(i));
            }
        }

        return result.toArray(new String[result.size()]);
    }

    public static String[] dirReduc(String[] arr) {
        String[] result = filterRedundantMoves(arr);

        while (true) {
            result = filterRedundantMoves(result);
            String[] result2 = filterRedundantMoves(result);

            if (Arrays.equals(result, result2)) {
                return result;
            }
        }
    }

    public static void main(String[] args) {
        String[] arr = new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"};
        System.out.println(Arrays.toString(dirReduc(arr)));
    }
}
