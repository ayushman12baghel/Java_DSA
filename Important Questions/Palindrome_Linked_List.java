import java.util.*;

// Approach 1 Using stack O(n) time and O(n) space
class Solution {
    public boolean isPalindrome(Node head) {
        if (head == null) {
            return true;
        }

        Stack<Integer> stack = new Stack<>();
        Node current = head;

        while (current != null) {
            stack.push(current.data);
            current = current.next;
        }

        while (head != null) {
            if (head.data != stack.pop()) {
                return false;
            }

            head = head.next;
        }

        return true;
    }

}

// Approach 2 O(n) time Using Slow and fast to get Middle
class Solution {
    public boolean isPalindrome(Node head) {
        if (head == null) {
            return true;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node half = reverse(slow);
        Node start = head;

        while (half != null && start != null) {
            if (start.data != half.data) {
                return false;
            }

            half = half.next;
            start = start.next;
        }

        return true;
    }

    public Node reverse(Node head) {
        if (head == null) {
            return null;
        }

        Node current = head;
        Node prev = null;
        Node next;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}