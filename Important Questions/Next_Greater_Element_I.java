import java.util.*;

public class Next_Greater_Element_I {

    public static int[] nextGreaterElement(int nums1[], int nums2[]) {
        int res[] = new int[nums1.length];
        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums2) {
            while (!s.isEmpty() && s.peek() < num) {
                map.put(s.pop(), num);
            }
            s.push(num);
        }

        while (!s.isEmpty()) {
            map.put(s.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }

    public static void main(String args[]) {
        int nums1[] = { 4, 1, 2 };
        int nums2[] = { 1, 3, 4, 2 };

        int res[] = nextGreaterElement(nums1, nums2);

        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
