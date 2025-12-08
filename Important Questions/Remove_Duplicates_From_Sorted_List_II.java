import java.util.*;

//O(n)
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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1000);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode current = dummy;

        while (current != null) {
            ListNode next = current.next;
            if (next != null && current.val == next.val) {
                while (next != null && current.val == next.val) {
                    next = next.next;
                }
                current = next;
                prev.next = next;
            } else {
                prev = current;
                current = next;
            }
        }

        return dummy.next;
    }
}