import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        ListNode current = prev.next;// first node to reverse
        ListNode next = null;
        ListNode prevSub = null; // will contain right.next
        for (int i = left; i <= right; i++) {
            next = current.next;
            current.next = prevSub;
            prevSub = current;
            current = next;
        }

        prev.next.next = current;
        prev.next = prevSub;

        return dummy.next;
    }
}