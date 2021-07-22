import java.util.*;

public class SudokuSolver_37 {
    private List<List<Character>> colList;
    private List<List<Character>> rowList;
    private List<List<Character>> gridList;
    private char[][] result;
    private boolean flag;

    public void solveSudoku(char[][] board) {
        init(board);
        search(board, 0, 0);

    }

    public void search(char[][] board, int col, int row) {
        boolean find = false;
        for (;col < 9 && !find; col++) {
            for (row = 0; row < 9 && !find; row++) {
                if(board[col][row] == '.') {
                    find = true;
                    row--;col--;
                }
            }
        }
        if (find) {
            ArrayList<Character> list = (ArrayList<Character>) colList.get(col);
            int n = list.size();
            for (int i = 0; i < n; i++) {
                Character ch = list.get(i);
                if (check(ch, col, row)) {
                    put(board, ch, col, row);
                    search(board, col, row);
                    if (flag) return;
                    undo(board, ch, col, row, i);
                }
            }
        }else {
            flag = true;
        }
    }

    public void put(char[][] board,char ch, int col, int row) {
        board[col][row] = ch;
        colList.get(col).remove(Character.valueOf(ch));
        rowList.get(row).remove(Character.valueOf(ch));
        gridList.get(getGrid(col, row)).remove(Character.valueOf(ch));
    }

    public void undo(char[][] board, char ch, int col, int row, int index) {
        board[col][row] = '.';
        colList.get(col).add(index, ch);
        rowList.get(row).add(0, ch);
        gridList.get(getGrid(col, row)).add(0, ch);
    }

    public boolean check(char ch, int col, int row) {
        if (!rowList.get(row).contains(ch)) {
            return false;
        }
        return gridList.get(getGrid(col, row)).contains(ch);
    }

    public void init(char[][] board) {
        colList = new ArrayList<>();
        rowList = new ArrayList<>();
        gridList = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            colList.add(new ArrayList<Character>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9')));
            rowList.add(new ArrayList<Character>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9')));
            gridList.add(new ArrayList<Character>(Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9')));
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if(c != '.') {
                    colList.get(i).remove(Character.valueOf(c));
                    rowList.get(j).remove(Character.valueOf(c));
                    gridList.get(getGrid(i, j)).remove(Character.valueOf(c));
                }
            }
        }
        System.out.println();
    }

    public int getGrid(int i, int j) {
        int x = j / 3;
        int y = i / 3;
        return 3 * y + x;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        SudokuSolver_37 s = new SudokuSolver_37();
        s.solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
