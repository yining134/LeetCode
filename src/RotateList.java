import utils.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode pre = head;
        ListNode node = head;
        int length = 1;
        while (pre.next != null) {
            pre = pre.next;
            length++;
            if (length > k + 1) {
                node = node.next;
            }
        }
        if (k == length) return head;
        else if (k > length) return rotateRight(head, k % length);

        pre.next = head;
        ListNode result = node.next;
        node.next = null;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.createListNode(nums);
        RotateList solution = new RotateList();
        System.out.println(solution.rotateRight(head, 5));
    }
}
