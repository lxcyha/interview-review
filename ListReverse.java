class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class ListReverse {

    private static ListNode listReverse(ListNode listNode) {
        ListNode left = listNode;
        ListNode mid = listNode.next;
        // cursor..
        ListNode right = mid.next;
        left.next = null;
        // [1,2,3,4,5,6,7]
        // [left,mid,right,4,5,6,7 ]
        // mid->next = left;
        //
        while (right != null) {
            mid.next = left;
            left = mid;
            mid = right;
            right = right.next;
        }

        mid.next = left;

        return mid;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(11);
        ListNode node2 = new ListNode(22);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(12);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(12);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode tail = listReverse(head);
        while (tail != null) {
            System.out.println(tail.val);
            tail = tail.next;
        }
    }

}