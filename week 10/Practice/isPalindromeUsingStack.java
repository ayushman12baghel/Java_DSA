import java.util.*;

public class isPalindromeUsingStack {
    public static class Node {
        char data;
        Node next;

        public Node(int data) {
            this.data = (char) data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    public void addFirst(int data) {
        // step1=create new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step 2 -> newNode next = head
        newNode.next = head;// link

        // step 3 -> head=newNode
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        tail = newNode;
    }

    public void print() {
        if (head == null) {
            System.out.println("Linked list is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public boolean checkPalindrome() {
        Node temp = head;
        boolean isValid = true;
        Stack<Character> s = new Stack<>();
        while (temp != null) {
            s.push(temp.data);
            temp = temp.next;
        }
        while (head != null) {
            int i = s.pop();
            if (i == head.data) {
                isValid = true;
            } else {
                isValid = false;
                break;
            }
            head = head.next;
        }
        return isValid;
    }

    public static void main(String[] args) {
        isPalindromeUsingStack ll = new isPalindromeUsingStack();
        ll.addFirst('b');
        ll.addFirst('a');
        ll.addLast('c');
        ll.addLast('b');
        ll.addLast('a');
        ll.print();
        System.out.println(ll.checkPalindrome());

    }
}
