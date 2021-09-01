import utils.ListNode;

public class Reverse_Linked_List_206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = head, next;
        head = head.next;
        pre.next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) return head;
        if (left == 1) {
            ListNode left_node = head, pre = head, next;
            head = head.next;
            pre.next = null;
            for (int i = 1; i < right; i++) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            left_node.next = head;
            return pre;
        } else {
            int i = 1;
            ListNode result = head;
            for (; i < left - 1; i++) {
                head = head.next;
            }
            ListNode left_node = head;
            head = head.next;
            ListNode pre = head, begin = head, next;
            head = head.next;
            pre.next = null;
            for (i++; i < right; i++) {
                next = head.next;
                head.next = pre;
                pre = head;
                head = next;
            }
            left_node.next = pre;
            begin.next = head;
            return result;
        }
    }

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        // 定义一个dummyHead, 方便处理
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // 初始化指针
        ListNode g = dummyHead;
        ListNode p = dummyHead.next;

        // 将指针移到相应的位置
        for(int step = 0; step < m - 1; step++) {
            g = g.next; p = p.next;
        }

        // 头插法插入节点
        for (int i = 0; i < n - m; i++) {
            ListNode removed = p.next;
            p.next = p.next.next;

            removed.next = g.next;
            g.next = removed;
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        Reverse_Linked_List_206 s = new Reverse_Linked_List_206();
        ListNode node = ListNode.createListNode(new int[]{1, 2, 3, 4, 5});
//        ListNode result = s.reverseList(node);
        ListNode result = s.reverseBetween(node, 1, 1);
        System.out.println(result);
    }
}
