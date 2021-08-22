public class Search_A_2d_Matrix_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int col = matrix.length, row = matrix[0].length;
        int left = 0, right = col * row - 1, mid, i, j;
        while (right - left >= 0) {
            mid = left + ((right - left) >> 2);
            i = mid / row;
            j = mid % row;
            if (matrix[i][j] > target) {
                right = mid - 1;
            } else if (matrix[i][j] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Search_A_2d_Matrix_74 s = new Search_A_2d_Matrix_74();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 11, 13, 14}
        };
        System.out.print(s.searchMatrix(matrix, 10));
    }
}
