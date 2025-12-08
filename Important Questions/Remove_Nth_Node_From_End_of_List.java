import java.util.*;

//Approach Two Pass O(n)
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            count++;
        }
        int k = count - n;
        if (k == 0) {
            return head.next;
        }
        int i = 1;
        temp = head;
        while (temp != null && i < k) {
            i++;
            temp = temp.next;
        }

        ListNode next = temp.next.next;
        temp.next = next;

        return head;
    }
}

// Approach 2 One Pass O(n)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode right = dummy;
        ListNode left = dummy;

        for (int i = 0; i <= n; i++) {
            right = right.next;
        }

        while (right != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;

        return dummy.next;
    }
}