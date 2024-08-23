/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode head = headA;
        while (head != null) {
            head = head.next;
            lenA++;
        }
        head = headB;
        while (head != null) {
            head = head.next;
            lenB++;
        }
        int d;
        if (lenB < lenA) {
            d = lenA - lenB;
            ListNode temp = new ListNode();
            temp = headA;
            headA = headB;
            headB = temp;
        }
        else {
            d = lenB - lenA;
        }
        while (d > 0) {
            headB = headB.next;
            d--;
        }
        while (headA != null && headB != null && headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}