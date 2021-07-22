public class TrappingRainWater_42 {
    public int trap(int[] height) {
        int max = -1;
        int sum = 0, count;
        boolean first = true;
        for (int i : height) {
            if (max < i) max = i;
        }
        for (int h = 0; h <= max; h++) {
            first = true;
            count = 0;
            for (int i = 0; i < height.length; i++) {
                if (first) {
                    if (height[i] == 0) continue;
                    else {
                        first = false;
                    }
                } else {
                    if (height[i] == 0) {
                        count++;
                    } else {
                        sum += count;
                        count = 0;
                    }
                }

                if (height[i] > 0) height[i]--;
            }
        }
        return sum;
    }

    public int trap2(int[] height) {
        int maxIndex, left = -1, right = -1;
        int result = 0;
        maxIndex = findMaxIndex(height, 0, height.length);
        left = findMaxIndex(height, 0, maxIndex);
        right = findMaxIndex(height, maxIndex + 1, height.length);
        result += count(height, left, maxIndex);
        result += count(height, maxIndex, right);

        while (left != -1 || right != -1) {
            if (left != -1) {
                int l = findMaxIndex(height, 0, left);
                result += count(height, l, left);
                left = l;
            }
            if (right != -1) {
                int r = findMaxIndex(height, right + 1, height.length);
                result += count(height, right, r);
                right = r;
            }
        }
        return result;
    }

    public int findMaxIndex(int[] height, int begin, int end) {
        int max = 0, maxIndex = end;
        for (int i = begin; i < end; i++) {
            if (max < height[i]) {
                max = height[i];
                maxIndex = i;
            }
        }
        if (max == 0) return -1;
        else return maxIndex;
    }

    public int count(int[] height, int begin, int end) {
        if (begin == -1 || end == -1) return 0;
        int min = Math.min(height[begin], height[end]);
        int sum = 0;
        for (int i = begin + 1; i < end; i++) {
            sum += min - height[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        TrappingRainWater_42 solution = new TrappingRainWater_42();
        int result = solution.trap2(new int[] {100,1,99,0,0,0});
        System.out.println(result);
    }
}
