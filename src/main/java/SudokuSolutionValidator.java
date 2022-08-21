public class SudokuSolutionValidator {

    public static boolean check(int[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                if (sudoku[i][j] == 0) return false;
                if (!isFieldValid(sudoku, i, j)) return false;
            }
        }

        return true;
    }

    private static boolean isFieldValid(int[][] sudoku, int x, int y) {
        // Check if the field is horizontally valid
        for (int j = 0; j < sudoku.length; j++) {
            if (j == y) continue;
            if (sudoku[x][j] == sudoku[x][y]) return false;
        }

        // Check if the field is vertically valid
        for (int i = 0; i < sudoku.length; i++) {
            if (i == x) continue;
            if (sudoku[i][y] == sudoku[x][y]) return false;
        }

        // Check if the field is valid in its square
        int squareX = x / 3;
        int squareY = y / 3;

        for (int i = squareX * 3; i < (squareX * 3) + 3; i++) {
            for (int j = squareY * 3; j < (squareY * 3) + 3; j++) {
                if (i == x && j == y) continue;
                if (sudoku[i][j] == sudoku[x][y]) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] sudoku = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };

        System.out.println(check(sudoku));
    }
}
