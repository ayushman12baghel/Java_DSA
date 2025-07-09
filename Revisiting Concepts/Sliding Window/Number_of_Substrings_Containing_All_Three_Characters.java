public class Number_of_Substrings_Containing_All_Three_Characters {

    // Sliding Window
    public static int numberOfSubstrings(String s) {
        int n = s.length();
        int freq[] = new int[3];
        int i = 0;
        int j = 0;
        int ans = 0;

        while (j < n) {
            freq[s.charAt(j) - 'a']++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                freq[s.charAt(i) - 'a']--;
                ans += (n - j);
                i++;
            }

            j++;
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "abcabc";
    }
}
