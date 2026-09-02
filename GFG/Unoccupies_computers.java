//Approach 1 Using HashSet O(n)
class Solution {
    public int solve(int n, String s) {
        // code here
        Set<Character> set=new HashSet<>();
        boolean seen[]=new boolean[26];
        int count=0;
        
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(set.contains(c)){
                set.remove(c);
            }else if(set.size()<n && !seen[c-'A']){
                seen[c-'A']=true;
                set.add(c);
            }else if(!seen[c-'A']){
                seen[c-'A']=true;
                count++;
            }
        }
        
        return count;
    }
}

//Approach 2 
class Solution {
    public int solve(int n, String s) {
        // code here
        int state[]=new int[26];
        int current=0;
        int count=0;
        
        for(char c:s.toCharArray()){
            if(state[c-'A']==0){
                if(current<n){
                    current++;
                    state[c-'A']=1;
                }else{
                    state[c-'A']=2;
                    count++;
                }
            }else if(state[c-'A']==1){
                current--;
            }
        }
        
        return count;
    }
}
