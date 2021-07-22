import utils.ListNode;
import utils.TreeNode;

import java.util.*;

public class ConvertSortListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return sortNumsToBST(list, 0, list.size() - 1);
//        return sortNumsToBST2(list);
    }

    //Recursion
    public TreeNode sortNumsToBST(List<Integer> list, int left, int right) {
        if (left >= right) return new TreeNode(list.get(left));
        int mid = left + right;
        mid = mid % 2 == 0 ? mid / 2 : (mid + 1) / 2;
        TreeNode node = new TreeNode(list.get(mid));
        if (mid - 1 >= left)
            node.left = sortNumsToBST(list, left, mid - 1);
        if (mid + 1 <= right)
            node.right = sortNumsToBST(list,mid + 1, right);
        return node;
    }

    public TreeNode sortNumsToBST2(List<Integer> list) {
        if (list.isEmpty()) return null;
        Queue<Integer> left_queue = new LinkedList<>();
        Queue<Integer> right_queue = new LinkedList<>();
        Queue<TreeNode> node_queue = new LinkedList<>();

        int left = 0, right = list.size() - 1;
        int mid = (left + right) % 2 == 0 ? (left + right) / 2 : ((left + right) + 1) / 2;

        //do something
        TreeNode root = new TreeNode(list.get(mid));
        left_queue.add(left);
        right_queue.add(mid - 1);
        left_queue.add(mid + 1);
        right_queue.add(right);
        node_queue.add(root);
        while (!left_queue.isEmpty()) {
            TreeNode node = node_queue.poll();
            TreeNode left_node, right_node;
            left = left_queue.poll();
            right = right_queue.poll();
            if (left == right) {
                left_node = new TreeNode(list.get(left));
                node.left = left_node;
            } else if (left < right) {
                mid = (left + right) % 2 == 0 ? (left + right) / 2 : ((left + right) + 1) / 2;
                left_node = new TreeNode(list.get(mid));
                left_queue.add(left);
                right_queue.add(mid - 1);
                left_queue.add(mid + 1);
                right_queue.add(right);
                node_queue.add(left_node);
                node.left = left_node;
            }

            left = left_queue.poll();
            right = right_queue.poll();
            if (left == right) {
                right_node = new TreeNode(list.get(left));
                node.right = right_node;
            } else if (left < right) {
                mid = (left + right) % 2 == 0 ? (left + right) / 2 : ((left + right) + 1) / 2;
                right_node = new TreeNode(list.get(mid));
                left_queue.add(left);
                right_queue.add(mid - 1);
                left_queue.add(mid + 1);
                right_queue.add(right);
                node_queue.add(right_node);
                node.right = right_node;
            }
        }

        return root;
    }

    public static void main(String[] args) {
        ConvertSortListToBinarySearchTree solution = new ConvertSortListToBinarySearchTree();
        int[] nums = {-10,-3,0,5,9};
        ListNode head = ListNode.createListNode(nums);
        System.out.println(head);
        TreeNode node = solution.sortedListToBST(head);
        TreeNode.printTree(node);

    }
}
