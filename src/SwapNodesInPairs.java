import utils.ListNode;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node, pre, next, result;
        result = head.next;

        //first swap
        next = head.next;
        head.next = next.next;
        next.next = head;

        pre = head;
        node = head.next;
        if (node == null) return result;
        next = node.next;
        if (next == null) return result;
        while (true) {
            pre.next = next;
            node.next = next.next;
            next.next = node;

            pre = node;
            node = node.next;
            if (node == null) break;
            next = node.next;
            if (next == null) break;
        }
        return result;
    }

    public static void main(String[] args) {
        SwapNodesInPairs solution = new SwapNodesInPairs();
        int[] nums = {1,2};
        ListNode head = ListNode.createListNode(nums);
        System.out.println(head);
        head = solution.swapPairs(head);
        System.out.println(head);
    }
}

