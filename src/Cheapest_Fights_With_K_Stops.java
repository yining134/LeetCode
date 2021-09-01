public class Cheapest_Fights_With_K_Stops {
    public int findCheapestPrice(int n, int[][] fights, int src, int dst, int k) {
        int[][] graph = init(n, fights);
        return 1;
    }
    public int[][] init(int n, int[][] fights) {
        int[][] graph = new int[n][n];
        for (int k = 0; k < fights.length; k++) {
            int i = fights[n][0];
            int j = fights[n][1];
            int price = fights[n][2];
            graph[i][j] = price;
        }
        return graph;
    }
}
