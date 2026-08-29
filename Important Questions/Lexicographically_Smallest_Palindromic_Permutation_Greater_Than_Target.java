//Approach 1 O(n)
class Solution {
    int halfLength=0;
    char midChar='$';
    String result="";
    public String lexPalindromicPermutation(String s, String target) {
        int n=s.length();

        int freq[]=new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }

        int oddCount=0;
        for(int i=0;i<26;i++){
            if(freq[i]%2!=0){
                oddCount++;
                midChar=(char)(i+'a');
            }
        }

        if(oddCount>1){
            return "";
        }

        int half[]=new int[26];
        halfLength=n/2;

        for(int i=0;i<26;i++){
            half[i]=freq[i]/2;
        }

        solve(half,0,new StringBuilder(),target,false);

        return result;
    }

    public boolean solve(int half[],int index,StringBuilder temp,String target,boolean isGreater){
        if(index>=halfLength){
            String left=temp.toString();
            String right=new StringBuilder(left).reverse().toString();
            String candidate=left+(midChar=='$'?"":midChar)+right;

            if(candidate.compareTo(target)>0){
                result=candidate;
                return true;
            }

            return false;
        }

        for(char c='a';c<='z';c++){
            if(half[c-'a']==0){
                continue;
            }

            if(!isGreater && c<target.charAt(index)){
                continue;
            }

            temp.append(c);
            half[c-'a']--;
            boolean newGreater=isGreater || c>target.charAt(index);

            if(solve(half,index+1,temp,target,newGreater)){
                return true;
            }

            temp.deleteCharAt(temp.length()-1);
            half[c-'a']++;
        }

        return false;
    }
}

//Approach 2 Iterative O(n*26)
class Solution {
    public String lexPalindromicPermutation(String s, String target) {
        int n=s.length();

        int freq[]=new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }

        char midChar='$';
        int halfLength=n/2;
        int oddCount=0;
        int half[]=new int[26];

        for(int i=0;i<26;i++){
            if(freq[i]%2!=0){
                oddCount++;
                midChar=(char)(i+'a');
            }

            half[i]=freq[i]/2;
        }

        if(oddCount>1){
            return "";
        }

        int i=0;
        char leftHalf[]=new char[halfLength];

        while(i<halfLength && half[target.charAt(i)-'a']>0){
            leftHalf[i]=target.charAt(i);
            half[target.charAt(i)-'a']--;
            i++;
        }

        if(i==halfLength){
            String left=new String(leftHalf);
            String right=new StringBuilder(left).reverse().toString();
            String candidate=left+(midChar=='$'?"":midChar)+right;

            if(candidate.compareTo(target)>0){
                return candidate;
            }
        }

        int start=(i==halfLength?halfLength-1:i);

        for(int index=start;index>=0;index--){
            int t=target.charAt(index)-'a';

            if(index<i){
                half[t]++;
            }

            for(int c=t+1;c<26;c++){
                if(half[c]>0){
                    half[c]--;
                    leftHalf[index]=(char)(c+'a');

                    int k=index+1;

                    for(int x=0;x<26;x++){
                        while(half[x]>0){
                            leftHalf[k++]=(char)(x+'a');
                            half[x]--;
                        }
                    }

                    String left=new String(leftHalf);
                    String right=new StringBuilder(left).reverse().toString();
                    
                    return left+(midChar=='$'?"":midChar)+right;
                }
            }
        }

        return "";
    }
}
