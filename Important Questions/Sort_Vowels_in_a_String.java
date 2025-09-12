import java.util.*;

// Approach 1 Using Sorting O(nlogn)
class Solution {
    public String sortVowels(String s) {
        List<Character> arr = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                arr.add(c);
            }
        }

        Collections.sort(arr);
        if (arr.size() == 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int j = 0;

        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                sb.append(arr.get(j));
                j++;
            } else {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
                || c == 'U') {
            return true;
        }

        return false;
    }
}

// Approach 2 Using Counting Sort O(n)
class Solution {
    public String sortVowels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        char arr[] = s.toCharArray();
        String vowels = "AEIOUaeiou";
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];

            if (isVowel(c)) {
                while (map.getOrDefault(vowels.charAt(j), 0) == 0) {
                    j++;
                }

                arr[i] = vowels.charAt(j);
                map.put(vowels.charAt(j), map.get(vowels.charAt(j)) - 1);
            }
        }

        return new String(arr);
    }

    public boolean isVowel(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
                || c == 'U') {
            return true;
        }

        return false;
    }
}