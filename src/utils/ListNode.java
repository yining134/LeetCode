package utils;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode(){};
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


    public static ListNode createListNode (int[] nums) {
        if (nums.length == 0) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode next = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            next.next = node;
            next = node;
        }
        return head;
    }

    public static ListNode createListNode(int[] nums, int p) {
        if (nums.length == 0) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode cycle = null, next = head;
        if (p == 0) cycle = head;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            if (i == p) cycle = node;
            next.next = node;
            next = node;
        }
        next.next = cycle;
        return head;
    }

    @Override
    public String toString() {
        ListNode node = this;
        String string = new String();
        string = string.concat(String.valueOf(node.val));
        while (node.next != null) {
            node = node.next;
            string = string.concat(" " + node.val);
        }
        return string;
    }
}