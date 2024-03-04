import java.util.*;
public class Palindromic_Substring_optimised {
    public static int palindromeCount(String s,int left, int right){
        int count=0;
        while(left>=0 && right<s.length() && s.charAt(left--)==s.charAt(right++)){
            count++;
        }
        return count;
    }
    public static int checkPalindrome(String s){
        int ans=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            int odd=palindromeCount(s,i-1,i+1);
            int even=palindromeCount(s, i, i+1);
            ans+=odd+even+1;
        }
        return ans;
    }
    public static void main(String args []){
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        System.out.println(checkPalindrome(s));
    }
}
