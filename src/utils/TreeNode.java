package utils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int val) {
        this.val = val;
    }
    public TreeNode (int val, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
    }

    public static TreeNode createTree(Integer[] nums) {
        if (nums == null) return null;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int n = nums.length;

        TreeNode root = new TreeNode(nums[0]);
        queue.add(root);
        for (int i = 0; !queue.isEmpty() && i < n; i++) {
            TreeNode node = queue.poll();
            if (node == null) continue;
            int left_num = i * 2 + 1;
            int right_num = i * 2 + 2;
            if (left_num < n && nums[left_num] != null) {
                TreeNode left = new TreeNode(nums[left_num]);
                node.left = left;
                queue.add(left);
            } else {
                //为了保证i的正确性
                queue.add(null);
            }
            if (right_num < n && nums[right_num] != null) {
                TreeNode right = new TreeNode(nums[right_num]);
                node.right = right;
                queue.add(right);
            } else {
                queue.add(null);
            }
        }
        return root;
    }

    public static void preOrder(TreeNode root) {
        if (root != null) {
            System.out.printf(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void preOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.empty()) {
            while (root != null) {
                System.out.print(root.val + " ");
                stack.push(root);
                root = root.left;
            }
            if (!stack.empty()) {
                root = stack.pop();
                root = root.right;
            }
        }
    }

    public static void inOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            System.out.print(root.val + " ");
            root = root.right;
        }
    }

    public static void postOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode last = null;

        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if (root.right == null || root.right == last) {
                System.out.print(root.val + " "); // visit
                last = root;
                stack.pop();
                root = null;
            } else {
                root = root.right;
            }
        }
    }

    public static void BSF(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.printf(node.val + " ");
            if (node.left != null) queue.add(node.left);
            if (node.right!= null) queue.add(node.right);
        }
    }

    public static int getTreeDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right));
        // return root == null ? 0 : Math.max(getTreeNodeDepth(root.left), getTreeNodeDepth(root.right)) + 1;
    }

    public static int getTreeDepthBFS(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            depth++;
        }
        return depth;
    }

    private static void printBlank(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print("  ");
        }
    }
    
    public static void printTree(TreeNode root) {
        if (root == null) return;
        int depth = getTreeDepth(root);
        int depth_now = 1;
        int pre, gap;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (depth_now <= depth) {
            int size = queue.size();
            pre = (int) Math.pow(2, depth - depth_now + 1) - 1;
            gap = (int) Math.pow(2, depth - depth_now + 2) - 1;
            printBlank(pre);
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node!= null) {
                    queue.add(node.left);
                    queue.add(node.right);
                    System.out.printf("%2d", node.val);
                }
                else {
                    queue.add(null);
                    queue.add(null);
                    System.out.printf("  ");
                }
                printBlank(gap);
            }
            System.out.println("");
            depth_now++;
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5 , 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        TreeNode root = TreeNode.createTree(nums);

        TreeNode.printTree(root);
        System.out.println("\nPre Order:");
        TreeNode.preOrder2(root);
        System.out.println("\nIn Order:");
        TreeNode.inOrder(root);
        System.out.println("\nPost Order:");
        TreeNode.postOrder(root);

    }
}
