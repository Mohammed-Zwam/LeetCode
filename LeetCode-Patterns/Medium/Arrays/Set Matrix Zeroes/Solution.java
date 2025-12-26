import java.util.HashSet;
import java.util.Set;

class Solution {
    public static void setRowZeros(int rowIdx, int[][] matrix) {
        for (int i = 0; i < matrix[rowIdx].length; i++) {
            matrix[rowIdx][i] = 0;
        }
    }

    public static void setColZeros(int colIdx, int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][colIdx] = 0;
        }
    }

    public static void setZeroes(int[][] matrix) {
        Set<Integer> rows = new HashSet<>(), cols = new HashSet<>();
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == 0) {
                    rows.add(r);
                    cols.add(c);
                }
            }
        }

        for (int rowIdx : rows) {
            setRowZeros(rowIdx, matrix);
        }
        for (int colIdx : cols) {
            setColZeros(colIdx, matrix);
        }
    }
}
