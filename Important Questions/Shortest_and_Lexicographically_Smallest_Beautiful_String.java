//Approach O(n)
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n=s.length();

        int minLength=n+1;
        int i=0;
        int j=0;
        int count=0;
        String result="";

        while(j<n){
            char c=s.charAt(j);

            if(c=='1'){
                count++;
            }

            while(count>=k){
                String curr=s.substring(i,j+1);
                if(minLength>j-i+1){
                    minLength=j-i+1;
                    result=curr;
                }else if(minLength==j-i+1){
                    if(curr.compareTo(result)<0){
                        result=curr;
                    }
                }

                if(s.charAt(i)=='1'){
                    count--;
                }

                i++;
            }

            j++;
        }

        return result;
    }
}
