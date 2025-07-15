import java.util.*;
import java.util.LinkedList;

public class Word_Ladder {

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);
        int level = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                String current = queue.poll();

                for (int j = 0; j < current.length(); j++) {
                    char word[] = current.toCharArray();

                    for (char c = 'a'; c <= 'z'; c++) {
                        if (word[j] == c) {
                            continue;
                        }

                        word[j] = c;
                        String newWord = new String(word);

                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }

                        if (set.contains(newWord) && !visited.contains(newWord)) {
                            visited.add(newWord);
                            queue.offer(newWord);
                        }
                    }
                }
            }

            level++;
        }

        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("hot");
        wordList.add("cog");

        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}
