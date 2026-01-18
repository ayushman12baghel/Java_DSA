import java.util.*;

//Approach 1 O(n*n*m*26) T.L.E
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();

        for (String word : wordList) {
            set.add(word);
        }

        List<String> first = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        first.add(beginWord);
        visited.add(beginWord);
        Queue<List<String>> queue = new LinkedList<>();
        queue.offer(first);

        List<List<String>> ans = new ArrayList<>();

        if (!set.contains(endWord)) {
            return ans;
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            Set<String> usedOnLevel = new HashSet<>();
            boolean found = false;

            for (int i = 0; i < size; i++) {
                List<String> current = queue.poll();

                String lastWord = current.get(current.size() - 1);
                if (lastWord.equals(endWord)) {
                    ans.add(current);
                    found = true;
                }

                for (int j = 0; j < lastWord.length(); j++) {
                    char charArray[] = lastWord.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == charArray[j]) {
                            continue;
                        }

                        charArray[j] = c;
                        String newWord = new String(charArray);

                        if (set.contains(newWord) && !visited.contains(newWord)) {
                            List<String> newPath = new ArrayList<>(current);
                            newPath.add(newWord);
                            queue.offer(newPath);
                            usedOnLevel.add(newWord);
                        }
                    }
                }
            }

            if (found) {
                break;
            }

            visited.addAll(usedOnLevel);
        }

        return ans;
    }
}

// Approach 2 O(n*m*m*26) Best Approach
class Solution {
    Map<String, Integer> map = new HashMap<>();
    List<List<String>> ans = new ArrayList<>();
    String beginWord;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        this.beginWord = beginWord;

        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }

        if (!set.contains(endWord)) {
            return ans;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        map.put(beginWord, 1);
        set.remove(beginWord);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                int steps = map.get(current);

                if (current.equals(endWord)) {
                    break;
                }

                char charArray[] = current.toCharArray();

                for (int j = 0; j < charArray.length; j++) {
                    char original = charArray[j];

                    for (char c = 'a'; c <= 'z'; c++) {
                        charArray[j] = c;

                        String newString = new String(charArray);

                        if (set.contains(newString)) {
                            queue.offer(newString);
                            map.put(newString, steps + 1);
                            set.remove(newString);
                        }
                    }

                    charArray[j] = original;
                }
            }
        }

        if (map.containsKey(endWord)) {
            List<String> temp = new ArrayList<>();
            temp.add(endWord);
            dfs(endWord, temp);
        }

        return ans;
    }

    public void dfs(String word, List<String> list) {
        if (word.equals(beginWord)) {
            List<String> temp = new ArrayList<>(list);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }

        int steps = map.get(word);
        int targetSteps = steps - 1;

        char charArray[] = word.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            char original = charArray[i];

            for (char c = 'a'; c <= 'z'; c++) {
                charArray[i] = c;

                String newString = new String(charArray);

                if (map.containsKey(newString) && map.get(newString) == targetSteps) {
                    list.add(newString);
                    dfs(newString, list);
                    list.remove(list.size() - 1);
                }
            }

            charArray[i] = original;
        }
    }
}