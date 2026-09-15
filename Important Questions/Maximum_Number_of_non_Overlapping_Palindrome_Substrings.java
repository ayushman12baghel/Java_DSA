//Approach 1 Memoisation O(n^3) and space O(n^2)
class Solution {
    public int maxPalindromes(String s, int k) {
        if(k==1){
            return s.length();
        }
        int dp[][]=new int[s.length()][s.length()];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }

        return solve(s,k,0,k-1,dp);
    }

    public int solve(String s,int k,int i,int j,int dp[][]){
        if(i>=s.length() || j>=s.length()){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        if(isPalindrome(s,i,j)){
            int take=1+solve(s,k,j+1,j+k,dp);
            int skipj=solve(s,k,i,j+1,dp);
            int skipi=solve(s,k,i+1,j+1,dp);

            return dp[i][j]=Math.max(take,Math.max(skipi,skipj));
        }

        int skipi=solve(s,k,i+1,j+1,dp);
        int skipj=solve(s,k,i,j+1,dp);

        return dp[i][j]=Math.max(skipi,skipj);
    }

    public boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}

//Apprroach 2 Tabulated
class Solution {
    public int maxPalindromes(String s, int k) {
        int n=s.length();
        if(k==1){
            return n;
        }
        
        int dp[][]=new int[n+1][n+1];

        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int skipi=dp[i+1][j+1];
                int skipj=dp[i][j+1];

                int ans=Math.max(skipi,skipj);

                if(isPalindrome(s,i,j)){
                    int nextI=j+1;
                    int nextJ=Math.min(n,j+k);

                    ans=Math.max(ans,dp[nextI][nextJ]+1);
                }

                dp[i][j]=ans;
            }
        }

        return dp[0][k-1];
    }

    public boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }

            i++;
            j--;
        }

        return true;
    }
}

// Approach 3 O(n^2) and O(n^2) space
class Solution {
    public int maxPalindromes(String s, int k) {
        int n=s.length();
        if(k==1){
            return n;
        }

        boolean isPalindrome[][]=new boolean[n+1][n+1];

        for(int L=1;L<=n;L++){
            for(int i=0;i+L-1<n;i++){
                int j=i+L-1;

                if(i==j){
                    isPalindrome[i][j]=true;
                }else if(i+1==j){
                    isPalindrome[i][j]=(s.charAt(i)==s.charAt(j));
                }else{
                    isPalindrome[i][j]=s.charAt(i)==s.charAt(j) && isPalindrome[i+1][j-1];
                }
            }
        }
        
        int dp[][]=new int[n+1][n+1];

        for(int i=n-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int skipi=dp[i+1][j+1];
                int skipj=dp[i][j+1];

                int ans=Math.max(skipi,skipj);

                if(isPalindrome[i][j]){
                    int nextI=j+1;
                    int nextJ=Math.min(n,j+k);

                    ans=Math.max(ans,dp[nextI][nextJ]+1);
                }

                dp[i][j]=ans;
            }
        }

        return dp[0][k-1];
    }
}

//Approach 4 More optimised 
class Solution {
    public int maxPalindromes(String s, int k) {
        int n=s.length();
        if(k==1){
            return n;
        }

        boolean isPalindrome[][]=new boolean[n+1][n+1];

        for(int L=1;L<=n;L++){
            for(int i=0;i+L-1<n;i++){
                int j=i+L-1;

                if(i==j){
                    isPalindrome[i][j]=true;
                }else if(i+1==j){
                    isPalindrome[i][j]=(s.charAt(i)==s.charAt(j));
                }else{
                    isPalindrome[i][j]=s.charAt(i)==s.charAt(j) && isPalindrome[i+1][j-1];
                }
            }
        }
        
        int dp[]=new int[n+1];

        for(int i=n-1;i>=0;i--){
            dp[i]=dp[i+1];
            for(int j=i+k-1;j<n;j++){
                if(isPalindrome[i][j]){
                    dp[i]=Math.max(dp[i],1+dp[j+1]);
                }
            }
        }

        return dp[0];
    }
}
