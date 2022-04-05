public class BuildTower {

    public static String[] buildTower(int floors) {
        String[] tower = new String[floors];
        for (int i = 0; i < floors; i++) {
            String sb = " ".repeat(floors - i - 1) +
                    "*".repeat(Math.max(0, i * 2 + 1)) +
                    " ".repeat(floors - i - 1);
            tower[i] = sb;
        }
        return tower;
    }
}
