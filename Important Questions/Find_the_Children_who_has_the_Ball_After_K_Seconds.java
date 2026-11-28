//Approach Simulation O(k)
class Solution {
    public int numberOfChild(int n, int k) {
        int factor=1;
        int current=0;

        while(k-->0){
            if(current==n-1){
                factor=-1;
                current=n-2;
            }else if(current==0 && factor==-1){
                factor=1;
                current=1;
            }else{
                current+=factor;
            }
        }

        return current;
    }
}

//Approach 2 Optimal O(1)
class Solution {
    public int numberOfChild(int n, int k) {
        int rounds=k/(n-1);
        int remainder=k%(n-1);

        if(rounds%2==0){
            return remainder;
        }else{
            return (n-1-remainder);
        }
    }
}
