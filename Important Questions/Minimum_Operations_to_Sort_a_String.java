//Approach 1 Brute Force O(N!* N^3logN)
// and Space O(N!*N)
class Solution {
    public int minOperations(String s) {
        int n=s.length();

        char arr[]=s.toCharArray();
        Arrays.sort(arr);
        String target=new String(arr);

        if(s.equals(target)){
            return 0;
        }

        Map<String,Integer> map=new HashMap<>();
        Queue<String> queue=new LinkedList<>();
        queue.offer(s);
        map.put(s,0);

        while(!queue.isEmpty()){
            String current=queue.poll();
            int d=map.get(current);

            for(int i=0;i<n;i++){
                for(int j=i+1;j<n;j++){
                    if(i==0 && j==n-1){
                        continue;
                    }

                    char sub[]=current.substring(i,j+1).toCharArray();
                    Arrays.sort(sub);
                    String next=current.substring(0,i)+new String(sub)+current.substring(j+1);

                    if(!map.containsKey(next)){
                        if(next.equals(target)){
                            return d+1;
                        }

                        queue.offer(next);
                        map.put(next,d+1);
                    }
                }
            }
        }

        return -1;
    }
}

//Approach 2 O(nlogn) Greedy
class Solution {
    public int minOperations(String s) {
        int n=s.length();

        char arr[]=s.toCharArray();
        Arrays.sort(arr);
        String target=new String(arr);

        if(s.equals(target)){
            return 0;
        }

        if(n==2){
            return -1;
        }

        if(s.charAt(0)==target.charAt(0) || s.charAt(n-1)==target.charAt(n-1)){
            return 1;
        }else if(target.charAt(n-1)==s.charAt(0) && target.charAt(0)==s.charAt(n-1) && 
                   target.charAt(0) != target.charAt(1) && 
                   target.charAt(n - 1) != target.charAt(n - 2)){
            return 3;
        }

        return 2;
    }
}
