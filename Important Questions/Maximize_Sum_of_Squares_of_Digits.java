// Approach Greedy O(num)
class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(num==1 && sum>9){
            return "";
        }

        StringBuilder ans=new StringBuilder();
        int current=9;

        while(num>0 && sum>=0){
            if(current<=sum){
                ans.append((char)(current+'0'));
                sum-=current;
                num--;
            }else{
                current--;
            }

        }

        if(num==0 && sum>0){
            return "";
        }

        return ans.toString();
    }
}
