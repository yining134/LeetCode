import utils.ListNode;

public class LinkedListCycleII {
    public static ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        boolean isCycle = false;
        while (fast!= null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                isCycle = true;
                break;
            }
        }
        if (isCycle) {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            System.out.println(fast.val);
            return fast;
        } else {
            return null;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode head = ListNode.createListNode(nums, 4);
        LinkedListCycleII.detectCycle(head);
    }
}
