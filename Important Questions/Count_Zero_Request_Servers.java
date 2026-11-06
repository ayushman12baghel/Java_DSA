class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = logs.length;

        Arrays.sort(logs, (a, b) -> a[1] - b[1]);
        
        int q = queries.length;
        int[][] timeIndex = new int[q][2];
        for (int i = 0; i < q; i++) {
            timeIndex[i][0] = queries[i];
            timeIndex[i][1] = i;
        }

        Arrays.sort(timeIndex, (a, b) -> a[0] - b[0]);
        
        Map<Integer, Integer> mp = new HashMap<>();
        int[] result = new int[q];
        
        int i = 0, j = 0;
        for (int[] pair : timeIndex) {
            int curtime = pair[0];
            int ind = pair[1];
            
            int start = curtime - x;
            int end = curtime;

            while (j < m && logs[j][1] <= end) {
                int serverId = logs[j][0];
                mp.put(serverId, mp.getOrDefault(serverId, 0) + 1);
                j++;
            }

            while (i < m && logs[i][1] < start) {
                int serverId = logs[i][0];
                mp.put(serverId, mp.get(serverId) - 1);
                if (mp.get(serverId) == 0) {
                    mp.remove(serverId);
                }
                i++;
            }

            result[ind] = n - mp.size();
        }
        
        return result;
    }
}
