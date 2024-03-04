public class count_occurence {
    public static void count(int matrix[][],int key){
        int count1=0;
        for(int i=0;i<=matrix.length-1;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(key==matrix[i][j]){
                    count1++;
                }
            }
        }
        System.out.println("the number of count is:"+count1);
    }
    public static void main(String[] args) {
        int matrix[][]={{4,7,8},{8,8,7}};
        int key=7;
        count(matrix,key);
    }
}
