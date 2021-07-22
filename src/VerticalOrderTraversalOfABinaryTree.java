import utils.ListNode;
import utils.TreeNode;

import java.util.*;

public class VerticalOrderTraversalOfABinaryTree {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) return null;
        List<List<Integer>> list = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> rows = new LinkedList<>();
        List<Integer> sizes = new ArrayList<>();
        int fix = 0, row; //row是节点的逻辑列，row+fix是在list中的真实下标
        queue.add(root);
        rows.add(0);

        while (!queue.isEmpty()) {
            sizes.clear();
            //保存在每层遍历前，list的size
            for (List<Integer> l: list) {
                sizes.add(l.size());
            }
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                row = rows.poll();
                if (row + fix < 0) {
                    fix++;
                    list.add(0, new ArrayList<>());
                    sizes.add(0, 1);
                } else if (row + fix >= list.size()) {
                    list.add(list.size(), new ArrayList<>());
                    sizes.add(sizes.size(), 1);
                }

                insert(list.get(row + fix), sizes.get(row + fix), node);
                if (node == null) continue;
                else {
                    if (node.left != null) {
                        queue.add(node.left);
                        rows.add(row - 1);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                        rows.add(row + 1);
                    }
                }
            }
        }
        return list;
    }

    public void insert(List<Integer> list, int index, TreeNode node) {
        int val = node.val;
        for (int i = index; i < list.size(); i++) {
            if (list.get(i) >= val) {
                list.add(i, val);
                return;
            }
        }
        list.add(val);
    }

    public static void main(String[] args) {
        VerticalOrderTraversalOfABinaryTree s = new VerticalOrderTraversalOfABinaryTree();
        TreeNode root = TreeNode.createTree(new Integer[]{15,14,13,12,11,10,9,8,7,6,5,4,3,2,1});
        List<List<Integer>> list = s.verticalTraversal(root);

        for (List<Integer> l : list) {
            for (int n : l) {
                System.out.printf(n + "\t");
            }
            System.out.println();
        }
    }
}
