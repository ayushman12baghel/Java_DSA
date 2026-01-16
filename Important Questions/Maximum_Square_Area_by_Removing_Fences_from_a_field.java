import java.util.*;

//O(h*h+v*v)
class Solution {
    int mod = 1000000007;

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        List<Integer> hList = new ArrayList<>();
        List<Integer> vList = new ArrayList<>();

        for (int num : hFences) {
            hList.add(num);
        }

        for (int num : vFences) {
            vList.add(num);
        }

        hList.add(1);
        hList.add(m);
        vList.add(1);
        vList.add(n);
        Set<Integer> width = new HashSet<>();

        for (int i = 0; i < hList.size(); i++) {
            for (int j = i + 1; j < hList.size(); j++) {
                width.add(Math.abs(hList.get(i) - hList.get(j)));
            }
        }

        int maxSide = 0;

        for (int i = 0; i < vList.size(); i++) {
            for (int j = i + 1; j < vList.size(); j++) {
                int height = Math.abs(vList.get(i) - vList.get(j));

                if (width.contains(height)) {
                    maxSide = Math.max(maxSide, height);
                }
            }
        }

        if (maxSide == 0) {
            return -1;
        }

        long ans = 1L * maxSide * maxSide;

        return (int) (ans % mod);
    }
}