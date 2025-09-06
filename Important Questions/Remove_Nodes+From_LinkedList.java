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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;

        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        ListNode current = stack.pop();
        int maxValue = current.val;
        ListNode result = new ListNode(maxValue);

        while (!stack.isEmpty()) {
            current = stack.pop();

            if (current.val < maxValue) {
                continue;
            } else {
                ListNode newNode = new ListNode(current.val);
                newNode.next = result;
                result = newNode;
                maxValue = result.val;
            }
        }

        return result;
    }
}

// Approach 2 By Reversing
class Solution {
    public ListNode removeNodes(ListNode head) {
        // Step 1: Reverse the list
        head = reverse(head);

        // Step 2: Traverse while keeping only nodes >= maxSoFar
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int maxSoFar = Integer.MIN_VALUE;

        while (head != null) {
            if (head.val >= maxSoFar) {
                maxSoFar = head.val;
                tail.next = head;
                tail = head;
            }
            head = head.next;
        }
        tail.next = null;

        return reverse(dummy.next);
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
