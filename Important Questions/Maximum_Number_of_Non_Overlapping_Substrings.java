class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n=s.length();

        int start[]=new int[26];
        int end[]=new int[26];
        Arrays.fill(start,-1);

        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(start[c-'a']==-1){
                start[c-'a']=i;
            }

            end[c-'a']=i;
        }

        boolean isValid[]=new boolean[26];
        Arrays.fill(isValid,true);

        for(int c=0;c<26;c++){
            if(start[c]==-1){
                continue;
            }

            for(int i=start[c];i<=end[c];i++){
                if(start[s.charAt(i)-'a']<start[c]){
                    isValid[c]=false;
                    break;
                }

                end[c]=Math.max(end[c],end[s.charAt(i)-'a']);
            }
        }

        List<String> ans=new ArrayList<>();

        int lastTakenIndex=n;
        for(int i=n-1;i>=0;i--){
            int index=s.charAt(i)-'a';

            if(!isValid[index]){
                continue;
            }

            if(start[index]==i && end[index]<lastTakenIndex){
                ans.add(s.substring(i,end[index]+1));
                lastTakenIndex=i;
            }
        }

        return ans;
    }
}
