import java.util.*;

class Solution {
    public int minSplitMerge(int[] nums1, int[] nums2) {
        int n = nums1.length;

        List<Integer> start = new ArrayList<>();
        List<Integer> target = new ArrayList<>();

        for (int num : nums1) {
            start.add(num);
        }
        for (int num : nums2) {
            target.add(num);
        }

        if (start.equals(target)) {
            return 0;
        }

        Queue<List<Integer>> queue = new LinkedList<>();
        Queue<Integer> dist = new LinkedList<>();
        Set<List<Integer>> set = new HashSet<>();

        queue.offer(start);
        dist.offer(0);
        set.add(start);

        while (!queue.isEmpty()) {
            List<Integer> current = queue.poll();
            int distance = dist.poll();

            for (int L = 0; L < n; L++) {
                for (int R = L; R < n; R++) {
                    List<Integer> block = new ArrayList<>(current.subList(L, R + 1));
                    List<Integer> remain = new ArrayList<>();

                    for (int i = 0; i < L; i++) {
                        remain.add(current.get(i));
                    }

                    for (int i = R + 1; i < n; i++) {
                        remain.add(current.get(i));
                    }

                    for (int pos = 0; pos <= remain.size(); pos++) {
                        List<Integer> next = new ArrayList<>(remain);
                        next.addAll(pos, block);

                        if (next.equals(target)) {
                            return distance + 1;
                        }

                        if (!set.contains(next)) {
                            set.add(next);
                            queue.offer(next);
                            dist.add(distance + 1);
                        }
                    }
                }
            }
        }

        return -1;
    }
}