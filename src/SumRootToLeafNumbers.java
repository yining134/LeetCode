import utils.TreeNode;

import java.util.Stack;

public class SumRootToLeafNumbers {
    private int sum = 0;
    public int sumNumbers(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                System.out.print(root.val + " ");
                stack.push(root.left);
                root = root.left;
            }
            if (!stack.empty()) {
                root = stack.pop();
                root = root.right;
            }
        }
        return 1;
    }

    public int sumNumbers2(TreeNode root) {
        preOrder(root);
        return sum;
    }

    public int preOrder(TreeNode root) {
        if (root.left == null && root.right == null) {
            sum += root.val;
            return 1;
        }
        else {
            int l_num = 0, r_num = 0;
            if (root.left != null) {
                l_num = 10 * preOrder(root.left);
            }
            if (root.right != null) {
                r_num = 10 * preOrder(root.right);
            }
            sum += (l_num + r_num) * root.val;
            return l_num + r_num;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree(new Integer[]{4, 9, 0, 5, 1});
        TreeNode.printTree(root);
        SumRootToLeafNumbers solution = new SumRootToLeafNumbers();
        System.out.println(solution.sumNumbers2(root));
    }
}
