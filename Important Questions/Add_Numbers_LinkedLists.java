import java.util.*;

//O(n)
/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    public Node addTwoLists(Node head1, Node head2) {
        // code here
        Node reverse1 = reverse(head1);
        Node reverse2 = reverse(head2);

        int carry = 0;
        Node result = new Node(-1);
        Node temp = result;

        while (reverse1 != null || reverse2 != null || carry != 0) {
            int sum1 = (reverse1 == null ? 0 : reverse1.data);
            int sum2 = (reverse2 == null ? 0 : reverse2.data);

            int sum = sum1 + sum2 + carry;
            int value = (sum) % 10;
            carry = sum / 10;

            temp.next = new Node(value);
            temp = temp.next;

            if (reverse1 != null) {
                reverse1 = reverse1.next;
            }

            if (reverse2 != null) {
                reverse2 = reverse2.next;
            }
        }

        result = reverse(result.next);

        while (result != null && result.data == 0) {
            result = result.next;
        }

        return result;
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