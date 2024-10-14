import java.util.*;

public class Linked_List_Cycle {
    static class Node {
        int val;
        Node next;

        public Node(int value) {
            this.val = value;
        }

    }

    public static boolean hasCycle(Node head) {
        Set<Node> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }

    public static boolean hasCycle2(Node head) {
        if (head == null || head.next == null) {
            return false;
        }

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String args[]) {
        Node head = new Node(3);
        head.next = new Node(2);
        head.next.next = new Node(0);
        head.next.next.next = new Node(-4);
        head.next.next.next.next = head.next;

        System.out.println(hasCycle(head));
        System.out.println(hasCycle2(head));
    }
}
