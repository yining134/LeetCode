import java.util.*;
import java.util.stream.Stream;

public class TopKFrequentElements_347 {
    public int[] topFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        Comparator<Map.Entry<Integer, Integer>> comparator = new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };

        for (int i : nums) {
            if (map.containsKey(i)) {
                int val = map.get(i) + 1;
                map.put(i, val);
            } else {
                map.put(i, 1);
            }
        }
        
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, comparator);

        int [] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }
        return result;
    }

    public int[] topFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return map.get(o1) - map.get(o2);
            }
        });

        for (int i : nums) {
            if (map.containsKey(i)) {
                int val = map.get(i) + 1;
                map.put(i, val);
            } else {
                map.put(i, 1);
            }
        }

        for (Integer key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (map.get(key) > map.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        int [] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.remove();
        }
        return result;
    }

    public int[] topFrequent3(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        for (int i : nums) {
            if (map.containsKey(i)) {
                int val = map.get(i) + 1;
                map.put(i, val);
            } else {
                map.put(i, 1);
            }
        }

        pq.addAll(map.keySet());
        int [] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.remove();
        }
        return result;
    }
    public static void main(String[] args) {
        TopKFrequentElements_347 s = new TopKFrequentElements_347();
        int[] nums = {1, 2, 3, 1, 2, 3, 1, 4, 1, 5, 1, 6, 1, 2, 2, 2, 2, 2};
        int[] result = s.topFrequent3(nums, 4);
        for (int i : result) {
            System.out.print(i + "\t");
        }
    }
}
