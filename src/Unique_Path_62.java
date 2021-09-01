public class Unique_Path_62 {
    public int uniquePaths (int m, int n) {
        if (m <= 1 || n <= 1) return 1;
        int i = Math.min(m - 1, n - 1);
        int j = Math.max(m - 1, n - 1) + i;
        long result = 1;
        for (int k = 1; k <= i; k++, j--) {
            result = result * j / k;
        }
        return (int)result;
    }

    public int uniquePaths2(int m, int n) {
        int[] paths = new int[n];
        for (int i = 0; i < n; i++) {
            paths[i] = 1;
        }
        for (int i = 0; i < m - 1; i++) {
            for (int j = 1; j < n; j++) {
                paths[j] = paths[j] + paths[j - 1];
            }
        }
        return  paths[n - 1];
    }

    public static void main(String[] args) {
        Unique_Path_62 s = new Unique_Path_62();
        System.out.print(s.uniquePaths2(3, 7));
    }
}
