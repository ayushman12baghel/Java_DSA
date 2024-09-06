import java.util.*;

public class Delete_Nodes_from_LL_present_in_Array {
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

    public static ListNode modifiedList(ListNode head, int nums[]) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        while (head != null) {
            if (!set.contains(head.val)) {
                temp.next = head;
                temp = temp.next;
            }
            head = head.next;
        }

        temp.next = null;

        return dummy.next;
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(3,
                                                new ListNode(5))))));
        int nums[] = { 1, 2, 3 };

        ListNode curr = modifiedList(head, nums);

        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
    }
}
