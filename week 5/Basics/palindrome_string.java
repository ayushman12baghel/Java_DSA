import java.util.*;
public class palindrome_string {
    public static boolean checkPalindrome(String a){
        // String rev="";
        // for(int i=a.length()-1;i>=0;i--){
        //     rev+=a.charAt(i);
        // }
        // if(rev.equals(a)){
        //     System.out.println("The word is palindrome");
        // }
        // else{
        //     System.out.println("The word is not palindrome");
        // }

        //mam code
        for(int i=0;i<a.length()/2;i++){
            if(a.charAt(i)!=a.charAt(a.length()-1-i)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the word: ");
        String a=sc.nextLine();
        System.out.println(checkPalindrome(a));
    }
}
