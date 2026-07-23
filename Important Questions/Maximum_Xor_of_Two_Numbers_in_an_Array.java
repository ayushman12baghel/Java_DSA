//Approach Using Trie O(nlogn)
class TrieNode{
    TrieNode children[];

    public TrieNode(){
        this.children=new TrieNode[2];
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        TrieNode root=new TrieNode();

        for(int num:nums){
            TrieNode current=root;

            for(int i=31;i>=0;i--){
                int bit=(num>>i)&1;

                if(current.children[bit]==null){
                    current.children[bit]=new TrieNode();
                }

                current=current.children[bit];
            }
        }

        int maxXor=0;

        for(int num:nums){
            TrieNode current=root;
            int currentXor=0;

            for(int i=31;i>=0;i--){
                int bit=(num>>i)&1;
                int opposite=1-bit;

                if(current.children[opposite]!=null){
                    currentXor+=(1<<i);
                    current=current.children[opposite];
                }else{
                    current=current.children[bit];
                }
            }

            maxXor=Math.max(maxXor,currentXor);
        }

        return maxXor;
    }
}
