import java.util.*;

//O(n*wordLength)
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = words.length;
        int length = s.length();
        int wordLength = words[0].length();

        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        for (int start = 0; start < wordLength; start++) {
            int left = start;
            int count = 0;
            HashMap<String, Integer> currMap = new HashMap<>();

            for (int right = start; right + wordLength <= length; right += wordLength) {
                String word = s.substring(right, right + wordLength);

                if (map.containsKey(word)) {
                    currMap.put(word, currMap.getOrDefault(word, 0) + 1);
                    count++;

                    while (currMap.get(word) > map.get(word)) {
                        String temp = s.substring(left, left + wordLength);
                        currMap.put(temp, currMap.get(temp) - 1);
                        count--;
                        left += wordLength;
                    }

                    if (count == n) {
                        ans.add(left);
                        String temp = s.substring(left, left + wordLength);
                        currMap.put(temp, currMap.get(temp) - 1);
                        count--;
                        left += wordLength;
                    }
                } else {
                    count = 0;
                    currMap.clear();
                    left = right + wordLength;
                }
            }
        }

        return ans;
    }
}