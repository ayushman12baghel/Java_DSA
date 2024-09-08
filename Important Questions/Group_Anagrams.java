import java.util.*;

public class Group_Anagrams {

    public static List<List<String>> groupAnagrams(String strs[]) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String s = generateFrequencyString(str);

            if (map.containsKey(s)) {
                map.get(s).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(s, list);
            }
        }

        return new ArrayList(map.values());
    }

    public static String generateFrequencyString(String str) {
        int freq[] = new int[26];
        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        char c = 'a';
        for (int i : freq) {
            sb.append(c);
            sb.append(i);
            c++;
        }

        return sb.toString();
    }

    // more Optimised
    public static List<List<String>> groupAnagrams2(String strs[]) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        HashMap<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char arr[] = str.toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);

            if (!map.containsKey(s)) {
                map.put(s, new ArrayList<>());
            }

            map.get(s).add(str);
        }

        List<List<String>> list = new ArrayList<>(map.values());

        return list;
    }

    public static void main(String args[]) {
        String strs[] = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> list = groupAnagrams(strs);

        for (List<String> str : list) {
            System.out.print(str + " ");
        }
        System.out.println();

        List<List<String>> list2 = groupAnagrams2(strs);

        for (List<String> str : list2) {
            System.out.print(str + " ");
        }
    }
}
