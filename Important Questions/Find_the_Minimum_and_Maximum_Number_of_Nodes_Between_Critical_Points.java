class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }
        
        int firstCritical = -1;
        int lastCritical = -1;
        int minDistance = Integer.MAX_VALUE;
        
        ListNode prev = head;
        ListNode curr = head.next;
        int index = 1; 
        
        while (curr.next != null) {
            ListNode next = curr.next;
            
            if ((curr.val > prev.val && curr.val > next.val) || 
                (curr.val < prev.val && curr.val < next.val)) {
                
                if (firstCritical == -1) {
                    firstCritical = index;
                } else {
                    minDistance = Math.min(minDistance, index - lastCritical);
                }

                lastCritical = index;
            }
            
            prev = curr;
            curr = next;
            index++;
        }

        if (minDistance == Integer.MAX_VALUE) {
            return new int[]{-1, -1};
        }

        return new int[]{minDistance, lastCritical - firstCritical};
    }
}
