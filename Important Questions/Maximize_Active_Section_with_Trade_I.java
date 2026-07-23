class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        int n=s.length();
        int active=0;

        for(int i=0;i<n;i++){
            if(s.charAt(i)=='1'){
                active++;
            }
        }

        List<Integer> zeros=new ArrayList<>();
        int i=0;

        while(i<n){
            int count=0;

            while(i<n && s.charAt(i)=='0'){
                i++;
                count++;
            }

            if(count!=0){
                zeros.add(count);
            }

            i++;
        }

        int maxZeros=0;
        for(i=0;i<zeros.size()-1;i++){
            maxZeros=Math.max(maxZeros,zeros.get(i)+zeros.get(i+1));
        }

        return maxZeros+active;
    }
}
