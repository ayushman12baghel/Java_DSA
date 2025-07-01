public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode entry = head;

                while (entry != slow) {
                    slow = slow.next;
                    entry = entry.next;
                }

                return entry;
            }
        }

        return null;
    }
}
