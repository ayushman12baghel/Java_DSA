import java.util.*;

/*
class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
*/
class Solution {
    public Node reverse(Node head) {
        // code here
        if (head == null) {
            return head;
        }

        Node current = head;
        Node prev = null;

        while (current != null) {
            Node temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            prev = current;
            current = current.prev;
        }

        return prev;
    }
}