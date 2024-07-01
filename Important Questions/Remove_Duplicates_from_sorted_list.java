
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Remove_Duplicates_from_sorted_list {

    public static Node deleteDuplicates(Node head) {
        Node result = head;

        while (head != null && head.next != null) {
            if (head.data == head.next.data) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return result;
    }

    public static Node createLinkedList(int[] values) {
        if (values.length == 0)
            return null;
        Node head = new Node(values[0]);
        Node current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }
        return head;
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        int[] values = { 1, 1, 2, 3, 3 };
        Node head = createLinkedList(values);
        printLinkedList(head);

        Node result = deleteDuplicates(head);
        printLinkedList(result);
    }

}
