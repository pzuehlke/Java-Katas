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
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) {
            return null;
        }

        int counter = 1;
        ListNode front = head;
        while (counter <= n + 1 && front != null) {
            front = front.next;
            counter++;
        }
        if (counter <= n + 1) {
            head = head.next;
            return head;
        }
        ListNode previous = head;
        ListNode toRemove = head.next;
        while (front != null) {
            front = front.next;
            previous = previous.next;
            toRemove = toRemove.next;
        }
        previous.next = toRemove.next;
        toRemove = toRemove.next;
    }
}