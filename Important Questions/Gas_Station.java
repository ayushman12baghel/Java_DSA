import java.util.*;

class Solution {
    public int startStation(int[] gas, int[] cost) {
        int n=gas.length;
        int startIndex=0;
        int currGas=0;
        
        for(int i=0;i<n;i++){
            currGas=currGas+gas[i]-cost[i];
            
            if(currGas<0){
                currGas=0;
                startIndex=i+1;
            }
        }
        
        currGas=0;
        
        for(int i=0;i<n;i++){
            int index=(i+startIndex)%n;
            currGas=currGas+gas[index]-cost[index];
            
            if(currGas<0){
                return -1;
            }
        }
        
        return startIndex;
    }
}