import java.util.*;
public class check_anagrams {
    public static void main(String[] args) {
        String str="earth";
        String str1="heart";

        str.toLowerCase();
        str1.toLowerCase();
        
        if(str.length()==str1.length()){
            char chararray[]=str.toCharArray();
            char chararray1[]=str1.toCharArray();

            Arrays.sort(chararray);
            Arrays.sort(chararray1);

            boolean result=Arrays.equals(chararray, chararray1);

            if(result){
                System.out.println("The strings are anagrams");
            }
            else{
                System.out.println("The strings are not anagram");
            }
        }

    }
}
