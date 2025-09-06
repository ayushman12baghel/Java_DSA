import java.util.*;

/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/

class Solution {
    public int lengthOfLoop(Node head) {
        if(head==null){
            return 0;
        }
        
        Node slow=head;
        Node fast=head;
        int length=0;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            
            if(slow==fast){
                Node current=slow.next;
                length=1;
                
                while(current!=slow){
                    current=current.next;
                    length++;
                }
                
                return length;
            }
        }
        
        return 0;
    }
}