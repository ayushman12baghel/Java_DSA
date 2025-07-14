import java.util.*;

//Approach 1
class Solution {
    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode tempHead = head;

        while (tempHead != null) {
            sb.append(tempHead.val);
            tempHead = tempHead.next;
        }

        return Integer.parseInt(sb.toString(), 2);
    }
}

// Approach 2
class Solution {
    public int getDecimalValue(ListNode head) {
        int num = 0;

        while (head != null) {
            num = (num << 1) | head.val;
            head = head.next;
        }

        return num;
    }
}