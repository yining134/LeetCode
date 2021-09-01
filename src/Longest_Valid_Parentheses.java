import java.util.Deque;
import java.util.LinkedList;

public class Longest_Valid_Parentheses {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Longest_Valid_Parentheses s = new Longest_Valid_Parentheses();
        String str = ")(())()()()))(())()";
        System.out.print(s.longestValidParentheses(str));
    }
}
