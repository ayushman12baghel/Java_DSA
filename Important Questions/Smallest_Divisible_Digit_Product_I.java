class Solution {
    public int smallestNumber(int n, int t) {
        if(t>n){
            return t;
        }

        int current=n;
        while(true){
            int currentSum=getProduct(current);
            if(currentSum%t==0){
                return current;
            }
            current++;
        }
    }

    public int getProduct(int n){
        int sum=1;

        while(n>0){
            sum*=n%10;
            n/=10;
        }

        return sum;
    }
}
