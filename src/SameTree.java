import utils.TreeNode;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null) return false;
        if (q == null && p != null) return false;

        if (p == null && q == null) return true;
        else if (p.val != q.val) return false;
        else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }

    public static void main(String[] args) {
        SameTree solution = new SameTree();
        TreeNode p = TreeNode.createTree(new Integer[]{1, 2});
        TreeNode q = TreeNode.createTree(new Integer[]{1, 2, 3});
        System.out.println(solution.isSameTree(p, q));
    }
}
