public class Find_Length_of_Cycle_LinkedList {

    static class Node {
        Node next;
        int data;

        public Node(int data) {
            this.data = data;
        }
    }

    public static int countNodesinLoop(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return countLength(slow);
            }
        }

        return 0;
    }

    public static int countLength(Node head) {
        Node current = head.next;
        int length = 1;

        while (current != head) {
            length++;
            current = current.next;
        }

        return length;
    }

    public static void main(String args[]) {
        Node root = new Node(1);
        root.next = new Node(2);
        root.next.next = new Node(3);
        root.next.next.next = new Node(4);
        root.next.next.next.next = new Node(5);
        root.next.next.next.next.next = root.next;

        System.out.println(countNodesinLoop(root));
    }
}
