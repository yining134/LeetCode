import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Sliding_Windows_Maximum_239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
            }
        });
        for (int i = 0; i < k; i++) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; i++) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < k; i++) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        result[0] = nums[dq.peekFirst()];
        for (int i = k; i < nums.length; i++) {
            while (!dq.isEmpty() && nums[i] >= nums[dq.peekLast()]) {
                dq.pollLast();
            }
            dq.offerLast(i);
            while (dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            result[i - k + 1] = nums[dq.peekFirst()];
        }
        return result;
    }

    public static void main(String[] args) {
        Sliding_Windows_Maximum_239 s = new Sliding_Windows_Maximum_239();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] results = s.maxSlidingWindow2(nums, k);
        for (int i : results) {
            System.out.printf(i + "\t");
        }
    }
}
