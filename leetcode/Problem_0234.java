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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        int n = 1;
        ListNode node = head.next;
        ListNode mid = head;
        while (node != null) {
            n++;
            if (n % 2 == 1) {
                mid = mid.next;
            }
            node = node.next;
        }
        mid = mid.next;
        ListNode subsequent = mid.next;
        while (subsequent != null) {
            ListNode temp = subsequent.next;
            subsequent.next = mid;
            mid = subsequent;
            subsequent = temp;
        }

        ListNode tail = mid;
        for (int i = 0; i < n / 2; i++) {
            if (head.val != tail.val) {
                return false;
            }
            else {
                tail = tail.next;
                head = head.next;
            }
        }
        return true;
    }
}