import java.util.ArrayList;
import java.util.List;

public class NQueens {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] array = new char[n][n];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = '.';
            }
        }
        search(array, 0);
        return result;
    }

    public void search(char[][] array, int col) {
        for(int row = 0; row < array.length; row++) {
            if (check(array, col, row)) {
                if (col == array.length - 1) {
                    array[col][row] = 'Q';
                    add(array);
                    array[col][row] = '.';
                    return;
                }
                else {
                    array[col][row] = 'Q';
                    search(array, col + 1);
                    array[col][row] = '.';
                }
            }
        }
    }

    public void add(char[][] array) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            list.add(String.valueOf(array[i]));
        }
        result.add(list);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.printf(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public boolean check(char[][] array, int col, int row) {
        // 横纵
        for (int i = 0; i < row; i++) {
            if (array[col][i] == 'Q') return false;
        }
        for (int i = 0; i < col; i++) {
            if (array[i][row] == 'Q') return false;
        }
        // 斜向
        int i = col, j = row;
        while (--i >= 0 && --j >= 0) {
            if (array[i][j] == 'Q') return false;
        }
        i = col; j = row;
        while (--i >= 0 && ++j < array.length) {
            if (array[i][j] == 'Q') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        NQueens s = new NQueens();
        s.solveNQueens(4);
    }
}
