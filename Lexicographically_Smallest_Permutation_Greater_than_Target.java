//Approach O(n*26(
class Solution {
    String result="";
    public String lexGreaterPermutation(String s, String target) {
        int n=s.length();

        int freq[]=new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }

        solve(freq,0,new StringBuilder(),false,target);

        return result;
    }

    public boolean solve(int freq[],int index,StringBuilder temp,boolean isGreater,String target){
        if(index>=target.length()){
            if(isGreater){
                result=temp.toString();
                return true;
            }

            return false;
        }

        for(char c='a';c<='z';c++){
            if(freq[c-'a']==0){
                continue;
            }

            if(!isGreater && c<target.charAt(index)){
                continue;
            }

            freq[c-'a']--;
            temp.append(c);

            boolean greater=isGreater || c>target.charAt(index);
            if(solve(freq,index+1,temp,greater,target)){
                return true;
            }
            freq[c-'a']++;
            temp.deleteCharAt(temp.length()-1);

        }

        return false;
    }

  //Approach 2 Tabulation O(n)
  class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n=s.length();

        int freq[]=new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }

        char ans[]=new char[n];
        int i=0;

        while(i<n && freq[target.charAt(i)-'a']>0){
            freq[target.charAt(i)-'a']--;
            ans[i]=target.charAt(i);
            i++;
        }

        int start=(i==n?n-1:i);

        for(int index=start;index>=0;index--){
            int t=target.charAt(index)-'a';

            if(index<i){
                freq[t]++;
            }

            for(int c=t+1;c<26;c++){
                if(freq[c]>0){
                    freq[c]--;
                    ans[index]=(char)(c+'a');

                    int k=index+1;

                    for(int x=0;x<26;x++){
                        while(freq[x]>0){
                            ans[k++]=(char)(x+'a');
                            freq[x]--;
                        }
                    }

                    return new String(ans);
                }
            }
        }

        return "";
    }
}
}
