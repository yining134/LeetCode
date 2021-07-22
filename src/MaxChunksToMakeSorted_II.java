import java.util.Stack;

public class MaxChunksToMakeSorted_II {
    static class Block {
        int min, max;
        Block(int min, int max) {
            this.min = min;
            this.max = max;
            System.out.println("min: " + min + " max: " + max);
        }
        static boolean check(Block now, Block pre) {
            if (now.min >= pre.max) return true;
            else return false;
        }
        void merge(Block b) {
            if (this.min > b.min) {
                this.min = b.min;
            }
            System.out.println("merge!, min: " + min + " max " + max);
        }
    }

    public int maxChunksToSorted(int[] arr) {
        if (arr.length == 0) return 0;
        int count = 1;
        int max = arr[0];
        int min = arr[0];
        Block now;
        Stack<Block> stack = new Stack<>();
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            else if (arr[i] >= max) {
                now = new Block(min, max);
                if (stack.empty()) {
                    stack.push(now);
                } else {
                    while (!stack.empty() && !Block.check(now, stack.peek())) {
                        now.merge(stack.pop());
                    }
                    stack.push(now);
                }
                max = arr[i];
                min = arr[i];
            }
        }
        now = new Block(min, max);
        if (stack.empty()) {
            stack.push(now);
        } else {
            while (!stack.empty() && !Block.check(now, stack.peek())) {
                now.merge(stack.pop());
            }
            stack.push(now);
        }
        return stack.size();
    }

    public static void main(String[] args) {
        MaxChunksToMakeSorted_II solution = new MaxChunksToMakeSorted_II();
        int[] nums = {5,4,3,2,1};
        int result = solution.maxChunksToSorted(nums);
        System.out.println(result);
    }
}
