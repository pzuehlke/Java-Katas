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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        int n = 0;
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            n++;
        }
        ListNode last = node;
        n++;

        k %= n;
        if (k == 0) {
            return head;
        }
        node = head;
        for (int i = 0; i < n - 1 - k; i++) {
            node = node.next;
        }
        ListNode temp = node.next;
        node.next = null;
        last.next = head;
        head = temp;
        return head;
    }
}