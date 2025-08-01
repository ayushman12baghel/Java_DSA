import java.util.HashMap;

public class Maximise_the_Confusion_of_Exam {

    // Using Two Sliding Windows
    public static int maxConsecutiveAnswers(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int maxLength = 0;
        map.put('T', 0);
        map.put('F', 0);

        // for T
        while (j < n) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            while (map.get('T') > k) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
            }

            maxLength = Math.max(maxLength, j - i + 1);

            j++;
        }

        // for 'F'
        map = new HashMap<>();
        i = 0;
        j = 0;
        map.put('T', 0);
        map.put('F', 0);
        while (j < n) {
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);

            while (map.get('F') > k) {
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
                i++;
            }

            maxLength = Math.max(maxLength, j - i + 1);

            j++;
        }

        return maxLength;
    }

    // Approach 2 Using Single Pass SlidingWindow
    public static int maxConsecutiveAnswers2(String str, int k) {
        int n = str.length();
        int i = 0;
        int j = 0;
        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('T', 0);
        map.put('F', 0);

        while (j < n) {
            map.put(str.charAt(j), map.get(str.charAt(j)) + 1);

            while (Math.min(map.get('T'), map.get('F')) > k) {
                map.put(str.charAt(i), map.get(str.charAt(i)) - 1);
                i++;
            }

            maxLength = Math.max(maxLength, j - i + 1);

            j++;
        }

        return maxLength;
    }

    public static void main(String[] args) {
        String ansKey = "TTFTTFTT";
        int k = 1;

        System.out.println(maxConsecutiveAnswers(ansKey, k));
        System.out.println(maxConsecutiveAnswers2(ansKey, k));
    }
}
