public class NetworkDelayTime {
    private static final int INF = Integer.MAX_VALUE;
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] d = new int[n];
        for(int i : d) {
            i = INF;
        }
        return 0;
    }

    public int[] dijkstra(int[][] weight, int start) {
        //init
        boolean[] visited = new boolean[weight.length];
        int[] d = new int[weight.length];
        int[] pre = new int[weight.length];
        for (int i = 0; i < weight.length; i++) {
            d[i] = weight[start][i];
            if (d[i] != INF) pre[i] = start;
            visited[i] = false;
        }
        visited[start] = true;

        for (int i = 1; i < weight.length; i++) {
            //find the min
            int min = INF, index = -1;
            for (int j = 0; j < weight.length; j++) {
                if (visited[j]) continue;
                if (d[j] < min) {
                    min = d[j];
                    index = j;
                }
            }
            if (index == -1) return d;
            //update
            for (int j = 0; j < weight.length; j++) {
                if (visited[j] || weight[index][j] == INF) continue;
                if (d[j] > d[index] + weight[index][j]) {
                    d[j] = d[index] + weight[index][j];
                    pre[j] = index;
                }
            }

            visited[index] = true;
        }
        for (int i : d) System.out.print(i + "\t");
        for (int i : pre) System.out.print(i + "\t");

        return d;
    }

    public static void main(String[] args) {
        NetworkDelayTime s = new NetworkDelayTime();
        int[][] graph = {
                {0,1,3,6},
                {1,0,1,6},
                {3,1,0,2},
                {6,6,2,0}
        };
        int[] d = s.dijkstra(graph, 0);
//        for (int i : d) System.out.print(i + "\t");
    }
}
