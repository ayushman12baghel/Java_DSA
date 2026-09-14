//Approach O(1)
class Solution {
    public boolean isRectangleOverlap(int[] rect1, int[] rect2) {
        int x11=rect1[0];
        int y11=rect1[1];
        int x21=rect1[2];
        int y21=rect1[3];

        int x12=rect2[0];
        int y12=rect2[1];
        int x22=rect2[2];
        int y22=rect2[3];

        boolean overlapX=(x11<x22 && x21>x12);
        boolean overlapY=(y11<y22 && y21>y12);

        return overlapX && overlapY;
    }
}
