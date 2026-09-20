//Approach 1 Simulaton O(n)
class Solution {
    public int reverseDegree(String s) {
        int degree[]=new int[26];
        int current=26;

        for(int i=0;i<26;i++){
            degree[i]=current--;
        }

        int ans=0;
        for(int i=0;i<s.length();i++){
            ans+=((i+1)*degree[s.charAt(i)-'a']);
        }

        return ans;
    }
}

//Approach 2 
class Solution {
    public int reverseDegree(String s) {

        int ans=0;
        for(int i=0;i<s.length();i++){
            ans+=(i+1)*(26-(s.charAt(i)-'a'));
        }

        return ans;
    }
}
