import java.util.Arrays;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums.length == 1) return;
        for (int n = nums.length - 2; n >= 0; n--) {
            for (int m = nums.length - 1; m > n; m--) {
                if (nums[n] < nums[m]) {
                    int temp = nums[n];
                    nums[n] = nums[m];
                    nums[m] = temp;
                    Arrays.sort(nums, n + 1, nums.length);
                    return;
                }
            }
        }
        Arrays.sort(nums);
    }

    public static void main(String[] args) {
        int[] nums = {2,1,3};
        NextPermutation solution = new NextPermutation();
        solution.nextPermutation(nums);
        for (int i : nums) {
            System.out.print(i + "\t");
        }
    }
}
