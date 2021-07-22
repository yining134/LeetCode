import utils.ListNode;

public class IntersectionOfTwoLinkedLists {
    public int getListLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    public ListNode getIntersectionNode (ListNode headA, ListNode headB) {
        int lengthA = getListLength(headA);
        int lengthB = getListLength(headB);
        if (lengthA > lengthB) return getIntersectionNode(headA, headB, lengthA - lengthB);
        else return getIntersectionNode(headB, headA, lengthB - lengthA);
    }

    public ListNode getIntersectionNode (ListNode headA, ListNode headB, int diff) {
        while (diff-- > 0) {
            headA = headA.next;
        }
        if (headA == headB) return headA;
        while (headA.next != null) {
            if (headA.next == headB.next) return headA.next;
            else {
                headA = headA.next;
                headB = headB.next;
            }
        }
        return null;
    }

}
