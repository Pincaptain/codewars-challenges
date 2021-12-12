public class StringToSpiral {

    private static int smallestPossibleSize(String s) {
        return (int) Math.ceil(Math.sqrt(s.length()));
    }

    enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    private static char getNextChar(StringBuilder stringBuilder) {
        if (!(stringBuilder.length() == 0)) {
            char temp = stringBuilder.charAt(0);
            stringBuilder.deleteCharAt(0);
            return temp;
        } else {
            return ' ';
        }
    }

    private static String toSpiral(String s) {
        int size = smallestPossibleSize(s);
        StringBuilder stringBuilder = new StringBuilder(s);
        char[][] matrix = new char[size][size];
        Direction direction = Direction.RIGHT;
        int count = size * size;
        int cycle = 0;
        int i = 0;
        int j = 0;
        String temp = "";

        while (count != 0) {

            if (direction == Direction.RIGHT) {
                // Check if you need to switch direction
                if (j == size - 1 - cycle) {
                    direction = Direction.DOWN;
                    continue;
                }

                matrix[i][j] = getNextChar(stringBuilder);


                // Lastly increment the X axis pointer
                j++;
            } else if (direction == Direction.DOWN) {
                // Check if you need to switch direction
                if (i == size - 1 - cycle) {
                    direction = Direction.LEFT;
                    continue;
                }

                matrix[i][j] = getNextChar(stringBuilder);

                i++;
            } else if (direction == Direction.LEFT) {
                // Check if you need to switch direction
                if (j == cycle) {
                    direction = Direction.UP;
                    cycle++;
                    continue;
                }

                matrix[i][j] = getNextChar(stringBuilder);

                j--;
            } else {
                if (i == cycle) {
                    direction = Direction.RIGHT;
                    continue;
                }

                matrix[i][j] = getNextChar(stringBuilder);

                i--;
            }

            count--;
        }

        StringBuilder newStringBuilder = new StringBuilder();
        for (int k = 0; k < size; k++) {
            for (int l = 0; l < size; l++) {
                if (l == size - 1) {
                    if (k == size - 1) {
                        newStringBuilder.append(matrix[k][l]);
                    } else {
                        newStringBuilder.append(matrix[k][l]).append("\n");
                    }
                } else {
                    newStringBuilder.append(matrix[k][l]);
                }
            }
        }

        return newStringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.print(toSpiral("Once a post or page has been shared on Facebook, the images have been stored in a cache on their server for future shares. Facebook doesn’t look at the page again for new images until their cache expires. This time period is unpredictable, but can be days or weeks."));
    }
}
