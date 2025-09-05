import java.util.*;

/*
class Node {
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}*/

class Solution {
    public Node segregate(Node head) {
        if (head == null) {
            return head;
        }

        int n = 0;
        int zeroCount = 0;
        int oneCount = 0;
        int twoCount = 0;
        Node temp = head;
        while (temp != null) {
            n++;
            if (temp.data == 0) {
                zeroCount++;
            } else if (temp.data == 1) {
                oneCount++;
            } else {
                twoCount++;
            }

            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            if (zeroCount > 0) {
                temp.data = 0;
                zeroCount--;
            } else if (oneCount > 0) {
                temp.data = 1;
                oneCount--;
            } else {
                temp.data = 2;
                twoCount--;
            }

            temp = temp.next;
        }

        return head;
    }
}