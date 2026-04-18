class Solution {
    public int mirrorDistance(int n) {
        int reverse=reverse(n);
        
        return Math.abs((int)n-reverse);
    }
    
    public int reverse(int n){
        int reverse=0;
        
        while(n>0){
            int ld=n%10;
            reverse=(reverse*10+ld);
            
            n/=10;
        }
        
        return reverse;
    }
}
