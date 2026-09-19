//Approach O(1)

class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int xi;
        int yi;

        xi=(x1>xCenter?x1:(x2<xCenter?x2:xCenter));
        yi=(y1>yCenter?y1:(y2<yCenter?y2:yCenter));

        return Math.sqrt((xi-xCenter)*(xi-xCenter)+(yi-yCenter)*(yi-yCenter))<=radius;
    }   
}
