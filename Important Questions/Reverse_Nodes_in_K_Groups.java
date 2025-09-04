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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode temp = head;
        int count = 0;

        while (temp != null && count < k) {
            temp = temp.next;
            count++;
        }

        if (count == k) {// I will reverse the groups of nodes
            ListNode current = head;
            ListNode prev = null;
            ListNode next = null;
            int i = 0;

            while (current != null && i < k) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                i++;
            }

            head.next = reverseKGroup(current, k);

            return prev;
        }

        // else I have not found k nodes, So according to the question I have to return
        // the remaining Nodes;

        return head;
    }
}
