//Approach Simulation O(n)
class Solution {
    public String digitSum(String s, int k) {
        StringBuilder sb=new StringBuilder(s);

        while(sb.length()>k){
            StringBuilder temp=new StringBuilder();

            for(int i=0;i<sb.length();i+=k){
                int sum=0;
                for(int j=i;j<i+k && j<sb.length();j++){
                    sum+=(int)(sb.charAt(j)-'0');
                }

                temp.append(sum);
            }

            sb=temp;
        }

        return sb.toString();
    }
}
