public class BuildTower {

    public static String[] buildTower(int floors) {
        String[] tower = new String[floors];
        for (int i = 0; i < floors; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < floors - i - 1; j++) {
                sb.append(" ");
            }
            for (int j = 0; j < i * 2 + 1; j++) {
                sb.append("*");
            }
            for (int j = 0; j < floors - i - 1; j++) {
                sb.append(" ");
            }
            tower[i] = sb.toString();
        }
        return tower;
    }
}
