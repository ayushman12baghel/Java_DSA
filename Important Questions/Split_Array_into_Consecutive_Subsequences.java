// Approach Using HashMap O(n)
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        Map<Integer,Integer> append=new HashMap<>();

        for(int num:nums){
            if(map.get(num)==0){
                continue;
            }

            if(append.getOrDefault(num-1,0)>0){
                map.put(num,map.get(num)-1);
                append.put(num-1,append.get(num-1)-1);
                append.put(num,append.getOrDefault(num,0)+1);
            }else if(map.getOrDefault(num+1,0)>0 && map.getOrDefault(num+2,0)>0){
                map.put(num+1,map.get(num+1)-1);
                map.put(num+2,map.get(num+2)-1);
                map.put(num,map.get(num)-1);
                append.put(num+2,append.getOrDefault(num+2,0)+1);
            }else{
                return false;
            }
        }

        return true;
    }
}

//Approach 2 O(nlogn) Using PriorityQueue
class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer,PriorityQueue<Integer>> map=new HashMap<>();

        for(int num:nums){
            if(map.containsKey(num-1) && !map.get(num-1).isEmpty()){
                int shortestLength=map.get(num-1).poll();
                map.putIfAbsent(num,new PriorityQueue<>());
                map.get(num).offer(shortestLength+1);
            }else{
                map.putIfAbsent(num,new PriorityQueue<>());
                map.get(num).offer(1);
            }
        }

        for(PriorityQueue<Integer> pq:map.values()){
            while(!pq.isEmpty()){
                if(pq.poll()<3){
                    return false;
                }
            }
        }

        return true;
    }
}
