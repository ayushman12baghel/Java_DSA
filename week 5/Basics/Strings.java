import java.util.*;
public class Strings {
    public static void printLetters(String str){
        for(int i=0;i<str.length();i++){
            System.out.print(str.charAt(i)+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        char arr[]={'a','b','c','d'};
        String str="abcd";

        Scanner sc=new Scanner(System.in);
        String name=sc.nextLine();
        String fullString=str+name;
        System.out.println(fullString.charAt(0));
        System.out.println(name.length());
        String nam="Ayushman Baghel";
        printLetters(nam);
    }
}
