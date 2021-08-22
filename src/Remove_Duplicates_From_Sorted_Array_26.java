public class Remove_Duplicates_From_Sorted_Array_26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int n = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                n++;
                nums[n] = nums[i];
            }
        }
        return n + 1;
    }

    public static void main(String[] args) {
        Remove_Duplicates_From_Sorted_Array_26 s = new Remove_Duplicates_From_Sorted_Array_26();
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int n = s.removeDuplicates(nums);
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i]);
        }
    }
}
