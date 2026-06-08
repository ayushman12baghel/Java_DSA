import java.util.*;

//Approach 1 By reversing O(n)
class Solution {
    Node compute(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        head = reverse(head);

        Node current = head;
        Node maxNode = head;

        while (current != null && current.next != null) {
            if (current.next.data < maxNode.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
                maxNode = current;
            }
        }

        head = reverse(head);

        return head;
    }

    Node reverse(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}

// Approach 2 Using Recursion O(n)
class Solution {
    Node compute(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node next = compute(head.next);

        if (next.data > head.data) {
            return next;
        } else {
            head.next = next;
            return head;
        }
    }
}