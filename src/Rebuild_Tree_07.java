import utils.TreeNode;

import java.util.Stack;

public class Rebuild_Tree_07 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        return buildTree(preorder, inorder, 0, preorder.length,0, preorder.length);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int pre_left, int pre_right, int in_left, int in_right) {
        TreeNode root = new TreeNode(preorder[pre_left]);
        int index = find(root.val, inorder, in_left, in_right);
        int left_nodes = index - in_left;
        int right_nodes = in_right - index - 1;
        if (left_nodes != 0)
            root.left = buildTree(preorder, inorder, pre_left + 1, pre_left + 1 + left_nodes, in_left, index);
        if (right_nodes != 0)
            root.right = buildTree(preorder, inorder, pre_left + 1 + left_nodes, pre_right, index + 1, in_right);
        return root;
    }

    public int find(int x, int[]n, int left, int right) {
        for (int i = left; i < right; i++) {
            if (n[i] == x) return i;
        }
        return -1;
    }


    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder.length == 0) return null;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> index_stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0]);
        TreeNode result = root;

        int left = 0, right = find(preorder[0], inorder, 0, inorder.length);
        index_stack.add(preorder.length);
        stack.add(root);

        for (int i = 1; i < preorder.length; i++) {
            //如果在中序index的左边找到，则表示属于左子树,否则出栈
            int val = preorder[i];
            int index = find(val, inorder, left, right);
            if (index != -1) {
                root.left = new TreeNode(preorder[i]);
                root = root.left;
                stack.add(root);
                index_stack.add(right);
                right = index;
            } else {
                do {
                    root = stack.pop();
                    left = right;
                    right = index_stack.pop();
                    index = find(val ,inorder, left, right);
                } while (index == -1);
                root.right = new TreeNode(preorder[i]);
                root = root.right;
                stack.add(root);
                index_stack.add(right);
                right = index;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Rebuild_Tree_07 s = new Rebuild_Tree_07();
//        int[] preorder = { 3,9,20,15,7 };
//        int[] inorder = { 9,3,15,20,7 };
        int[] preorder = {1,2,4,8,9,5,10,11,3,6,7};
        int[] inorder = {8,4,9,2,10,5,11,1,6,3,7};
        TreeNode root = s.buildTree2(preorder, inorder);
        TreeNode.printTree(root);
    }
}
