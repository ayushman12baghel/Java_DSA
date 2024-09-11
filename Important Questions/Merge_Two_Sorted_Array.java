import java.util.*;

public class Merge_Two_Sorted_Array {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode merge(ListNode list1, ListNode list2) {
        ListNode list = new ListNode();
        ListNode curr = list;

        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                curr.next = list2;
                list2 = list2.next;
            } else {
                curr.next = list1;
                list1 = list1.next;
            }

            curr = curr.next;
        }

        curr.next = (list1 != null) ? list1 : list2;

        return list.next;
    }

    public static void main(String args[]) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list = merge(list1, list2);

        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
    }
}