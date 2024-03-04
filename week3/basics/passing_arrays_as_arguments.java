import java.util.*;
public class passing_arrays_as_arguments {
    public static void update(int marks[]){
        for(int i=0;i<marks.length;i++){
            marks[i]=(marks[i]+2);
        }
    }
    public static void main(String[] args) {
        int marks[]={99,85,75,48,12,85,15,32,10};
        update(marks);

        for(int i=0;i<marks.length;i++){
            System.out.print(marks[i]+" ");
        }
    }
}
