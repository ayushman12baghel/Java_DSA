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
    public ListNode mergeNodes(ListNode head) {
        ListNode pointer1 = head.next;
        ListNode pointer2 = pointer1;

        while (pointer2 != null) {
            int sum = 0;
            while (pointer2 != null && pointer2.val != 0) {
                sum += pointer2.val;
                pointer2 = pointer2.next;
            }

            pointer1.val = sum;
            pointer2 = pointer2.next;
            pointer1.next = pointer2;
            pointer1 = pointer1.next;
        }

        return head.next;
    }
}

// Approach 2 Recursion
class Solution {
    public ListNode mergeNodes(ListNode head) {
        head = head.next;

        if (head == null) {
            return head;
        }

        ListNode temp = head;
        int sum = 0;
        while (temp != null && temp.val != 0) {
            sum += temp.val;
            temp = temp.next;
        }

        head.val = sum;
        head.next = mergeNodes(temp);

        return head;
    }
}