import java.util.*;

// Approach Using Sorting and Simulation O(n*m)
//Step 1 -> I will make a array which will tell who is online and who is not and will contain the timestamp when they will become online if user is offline
// At Each step I will call a function in which I will pass the mentions and it will return me the list of mentions in it if the message names "Message and Offline"
// I will also take a boolean array which will tell how many people are online as this will help in "Here" Message 

class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int ans[] = new int[numberOfUsers];

        boolean online[] = new boolean[numberOfUsers];
        Arrays.fill(online, true);
        int onlineTime[] = new int[numberOfUsers];
        Collections.sort(events, (a, b) -> {
            int t1 = Integer.parseInt(a.get(1));
            int t2 = Integer.parseInt(b.get(1));

            if (t1 != t2) {
                return t1 - t2;
            }

            String type1 = a.get(0);
            String type2 = b.get(0);

            if (type1.equals(type2))
                return 0;
            return type1.equals("OFFLINE") ? -1 : 1;
        });

        for (int i = 0; i < events.size(); i++) {
            List<String> current = events.get(i);
            int time = Integer.parseInt(current.get(1));

            updateOnline(time, online, onlineTime);

            if (current.get(0).equals("MESSAGE")) {
                handleMessage(current, ans, online);
            } else if (current.get(0).equals("OFFLINE")) {
                handleOffline(current, online, onlineTime, time);
            }
        }

        return ans;
    }

    public void updateOnline(int time, boolean online[], int onlineTime[]) {
        for (int i = 0; i < online.length; i++) {
            if (!online[i] && onlineTime[i] <= time) {
                online[i] = true;
            }
        }
    }

    public void handleMessage(List<String> current, int ans[], boolean online[]) {
        String words[] = current.get(2).split(" ");

        for (String word : words) {
            if (word.equals("HERE")) {
                for (int i = 0; i < online.length; i++) {
                    if (online[i]) {
                        ans[i]++;
                    }
                }
            } else if (word.equals("ALL")) {
                for (int i = 0; i < online.length; i++) {
                    ans[i]++;
                }
            } else if (word.startsWith("id")) {
                int id = Integer.parseInt(word.substring(2));
                ans[id]++;
            }
        }
    }

    public void handleOffline(List<String> current, boolean online[], int onlineTime[], int time) {
        int id = Integer.parseInt(current.get(2));
        onlineTime[id] = time + 60;
        online[id] = false;
    }
}