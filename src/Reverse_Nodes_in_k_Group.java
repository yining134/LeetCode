import utils.ListNode;

public class Reverse_Nodes_in_k_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode myHead = new ListNode(0);
        myHead.next = head;
        ListNode step = head, left = myHead, right = head, remove;
        while (true) {
            for (int i = 0; i < k; i++) {
                if (step == null) return myHead.next;
                step = step.next;
            }
            for (int i = 0; i < k - 1; i++) {
                remove = right.next;
                right.next = right.next.next;
                remove.next = left.next;
                left.next = remove;
            }
            left = right;
            right = right.next;
        }
    }

    public static void main(String[] args) {
        Reverse_Nodes_in_k_Group s = new Reverse_Nodes_in_k_Group();
//        int[] nums = {1,2,3,4,5};
        int[] nums = {1};
        ListNode head = ListNode.createListNode(nums);
        ListNode result = s.reverseKGroup(head, 1);
        System.out.println(result);
    }
}
