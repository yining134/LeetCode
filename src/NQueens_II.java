import java.util.Arrays;
import java.util.List;
public class NQueens_II {
    public static final int INF = Integer.MAX_VALUE;
    private int[] array;
    public List<List<String>> solveNQueens(int n) {
        array = new int[n];
        Arrays.fill(array, INF);
        int row = 0, col = 0;
        while (row < n) {
            while (col < n) {
                if (valid(row, col)) {
                    array[row] = col;
                    col = 0;
                    break;
                } else {
                    col++;
                }
            }

            if (array[row] == INF) {
                if (row == 0) break;
                else {
                    row--;
                    col = array[row] + 1;
                    array[row] = INF;
                    continue;
                }
            }

            if (row == n - 1) {
                print();
                col = array[row] + 1;
                array[row] = INF;
                continue;
            }
            row++;
        }
        return null;
    }

    public void print() {
        for (int row : array) {
            for (int j = 0; j < array.length; j++) {
                if (j != row) {
                    System.out.print(" . ");
                } else {
                    System.out.print(" Q ");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print("---");
        }
        System.out.println();
    }

    private boolean valid(int row, int col) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == col || Math.abs(i - row) == Math.abs(array[i] - col)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens_II s = new NQueens_II();
        s.solveNQueens(8);
    }
}
