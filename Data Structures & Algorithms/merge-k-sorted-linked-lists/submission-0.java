/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode resultHead = null;
        ListNode resultTail = null;

        // Find the list with min value
        // Shift the list with min value to head
        // Add to the result
        // Repeat as long as there is any non-empty list

        int minListIndex = -1;
        do {
            minListIndex = -1;
            for (int i=0; i<lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                if (minListIndex < 0 || lists[i].val < lists[minListIndex].val) {
                  minListIndex = i; 
                }
            }
            if (minListIndex >= 0) {
                if (resultHead == null) {
                    resultHead = lists[minListIndex];
                    resultTail = lists[minListIndex];
                } else {
                    resultTail.next = lists[minListIndex];
                    resultTail = lists[minListIndex];
                }
                lists[minListIndex] = lists[minListIndex].next;
            }
        } while (minListIndex >= 0);
        return resultHead;
    }
}
