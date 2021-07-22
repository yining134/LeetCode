import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters_3 {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int n = s.length(), i = 0, j = 0, max = 0;
        for (; i < n; i++) {
            if (set.contains(s.charAt(i))) {
                set.remove(s.charAt(j));
                j++;
            }
            max = Math.max(max, i - j + 1);
            set.add(s.charAt(i));
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        LongestSubstringWithoutRepeatingCharacters_3 solution = new LongestSubstringWithoutRepeatingCharacters_3();
        int maxLength = solution.lengthOfLongestSubstring(s);
        System.out.println(maxLength);
    }
}
