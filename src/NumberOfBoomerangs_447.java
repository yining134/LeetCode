import java.util.HashMap;

public class NumberOfBoomerangs_447 {
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            int[] middle = points[i];
            map.clear();
            for (int j = 0; j < points.length; j++) {
                int[] others = points[j];
                int d = dist(middle, others);
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
            for (int key : map.keySet()) {
                result += count(map.get(key));
            }
        }
        return result;
    }

    private int dist(int[] point1, int[] point2) {
        return (int) (Math.pow((point1[0] - point2[0]), 2) + Math.pow((point1[1] - point2[1]), 2));
    }

    private int count(int num) {
        return num * (num - 1);
    }

    public static void main(String[] args) {
        NumberOfBoomerangs_447 s = new NumberOfBoomerangs_447();
        int [][] points = new int[][] {
                {0, 0},{1, 0},{2,0},{3,0},{4,0}
        };
        System.out.print(s.numberOfBoomerangs(points));
    }
}
