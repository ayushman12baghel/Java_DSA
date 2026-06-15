import java.util.*;

//Approach 1 O(n) 2-Pass
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        int size = 0;
        ListNode temp = head;

        while (temp != null) {
            temp = temp.next;
            size++;
        }

        if (size == 1) {
            return null;
        } else if (size == 2) {
            head.next = null;
            return head;
        }

        int mid = size / 2;
        temp = head;
        int current = 0;

        while (temp != null) {
            current++;
            if (current == mid) {
                ListNode next = temp.next;
                temp.next = next.next;
                next.next = null;
            }

            temp = temp.next;
        }

        return head;
    }
}

// Approach 2 O(n) 1-Pass
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head.next.next;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }
}