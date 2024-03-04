import java.util.*;

public class StringBuilder1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("");
        for (char ch = 'a'; ch <= 'z'; ch++) {
            sb.append(ch);
        }
        System.out.println(sb);
        String str="hello my name is ayushman baghel";
        System.out.println(str.toUpperCase());
    }
}
