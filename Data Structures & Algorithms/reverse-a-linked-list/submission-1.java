class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode newHead = findTail(head);
        head.next = null;
        return newHead;
    }

    public ListNode findTail(ListNode node) {
        if (node.next == null) {
            return node;
        }
        ListNode tail = findTail(node.next);
        node.next.next = node;
        return tail;
    }
}