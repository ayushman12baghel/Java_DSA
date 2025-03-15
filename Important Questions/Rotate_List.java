public class Rotate_List {

    static class ListNode {
        ListNode next;
        int value;

        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        ListNode temp = head;
        int length = 1;

        while (temp.next != null) {
            temp = temp.next;
            length++;
        }
        k %= length;
        if (k == 0) {
            return head;
        }

        temp.next = head;
        temp = head;

        for (int i = 0; i < length - k - 1; i++) {
            temp = temp.next;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int k = 2;

        ListNode newHead = rotateRight(head, k);

        while (newHead != null) {
            System.out.println(newHead.value);
            newHead = newHead.next;
        }
    }
}
