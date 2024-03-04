import java.util.*;
public class Palindromic_Substrings {
    public static boolean checkPalindrome(String s,int left,int right){
        while(left<right){
            if(s.charAt(left++)!=s.charAt(right--)){
                return false;
            }
        }return true;
    }
    public static int countSubstring(String s){
        int ans=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(checkPalindrome(s, i,j)){
                     ans++;
                }
            }
        }return ans;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the String: ");
        String s=sc.nextLine();
        System.out.println(countSubstring(s));
    }
}

