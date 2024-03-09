public class Delete_nth_from_last {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
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

    public void deleteNthfromEnd(int n) {
        // calculate size
        int siz = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            siz++;
        }

        if (n == siz) {
            head = head.next; // removeFirst
            return;
        }

        // siz-n
        int i = 1;
        int indToFind = siz - n;
        Node prev = head;
        while (i < indToFind) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;

    }

    public static void main(String[] args) {
        Delete_nth_from_last ll = new Delete_nth_from_last();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.deleteNthfromEnd(2);
        ll.print();

    }
}
