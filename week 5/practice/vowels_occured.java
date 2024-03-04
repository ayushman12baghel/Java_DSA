import java.util.*;
public class vowels_occured {
    public static void count_vowel(String str){
        StringBuilder sb=new StringBuilder(str);
        int count=0;
        for (int i=0;i<sb.length();i++){
            char ch=sb.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                count++;
            }
        }
        System.out.println(count);


    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the String: ");
        String str=sc.nextLine();
        count_vowel(str);
    }
}
