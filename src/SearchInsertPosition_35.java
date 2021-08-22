public class SearchInsertPosition_35 {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = 0;
        while (right - left >= 0) {
            mid = left + ((right - left) >> 2);
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        SearchInsertPosition_35 s = new SearchInsertPosition_35();
        int[] nums = {1, 3, 5, 6};
        int result = s.searchInsert(nums, 2);
        System.out.println(result);
    }
}
