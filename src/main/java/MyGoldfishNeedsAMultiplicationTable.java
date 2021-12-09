public class MyGoldfishNeedsAMultiplicationTable {

    public static String table(int row, int column) {
        StringBuilder outerBuilder = new StringBuilder();
        StringBuilder innerBuilder = new StringBuilder();

        for (int i = 1; i <= row; i++) {
            innerBuilder.setLength(0);

            for (int j = 1; j <= column; j++) {
                innerBuilder.append((i * j) % 10);
            }

            if (i == row) {
                outerBuilder.append(innerBuilder);
            } else {
                outerBuilder.append(innerBuilder).append("\n");
            }
        }

        return outerBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(table(5, 5));
    }
}
