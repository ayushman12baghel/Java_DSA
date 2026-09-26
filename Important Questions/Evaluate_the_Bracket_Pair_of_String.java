//Approach Using HashMap O(n+m)
class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String,String> map=new HashMap<>();

        for(List<String> list:knowledge){
            map.put(list.get(0),list.get(1));
        }

        int i=0;
        StringBuilder ans=new StringBuilder();
        while(i<s.length()){
            if(s.charAt(i)=='('){
                StringBuilder sb=new StringBuilder();
                i++;
                while(s.charAt(i)!=')'){
                    sb.append(s.charAt(i));
                    i++;
                }

                String temp=map.getOrDefault(sb.toString(),"");
                if(temp.length()>0){
                    ans.append(temp);
                }else{
                    ans.append("?");
                }
            }else{
                ans.append(s.charAt(i));
            }

            i++;
        }

        return ans.toString();
    }
}
