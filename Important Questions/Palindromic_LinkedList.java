import java.util.*;

public class Palindromic_LinkedList {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    // Approach 1
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr.val);
            curr = curr.next;
        }
        curr = head;
        while (!stack.isEmpty()) {
            if (curr.val != stack.pop()) {
                return false;
            }
            curr = curr.next;
        }

        return true;
    }

    // Approach 2

    public static boolean isPalindrome2(ListNode head) {
        ListNode mid = findMid(head);
        ListNode prev = null;
        ListNode curr = mid;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode right = prev;
        ListNode left = head;
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
    }

    public static ListNode findMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));

        System.out.println(isPalindrome2(head));
    }
}
