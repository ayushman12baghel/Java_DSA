//Approach Segment Tree O(n+klogn)
class Node{
    int size;
    char prefChar;
    char suffChar;
    int prefLen;
    int suffLen;
    int maxLen;

    public Node(){

    }

    public void setLeaf(char c){
        size=1;
        prefChar=c;
        suffChar=c;
        prefLen=1;
        suffLen=1;
        maxLen=1;
    }
}

class SegmentTree{
    char arr[];
    int n;
    Node tree[];

    public SegmentTree(String s){
        n=s.length();
        arr=s.toCharArray();
        tree=new Node[4*n];

        for(int i=0;i<tree.length;i++){
            tree[i]=new Node();
        }

        build(0,0,n-1);
    }

    public void build(int index,int start,int end){
        if(start==end){
            tree[index].setLeaf(arr[start]);
            return;
        }

        int mid=start+(end-start)/2;
        int leftChild=2*index+1;
        int rightChild=2*index+2;
        build(leftChild,start,mid);
        build(rightChild,mid+1,end);

        merge(tree[index],tree[leftChild],tree[rightChild]);
    }

    public void merge(Node parent,Node left,Node right){
        parent.size=left.size+right.size;
        parent.prefChar=left.prefChar;
        parent.suffChar=right.suffChar;
        
        parent.prefLen=left.prefLen;

        if(parent.prefLen==left.size && right.prefChar==left.suffChar){
            parent.prefLen+=right.prefLen;
        }

        parent.suffLen=right.suffLen;
        if(parent.suffLen==right.size && right.prefChar==left.suffChar){
            parent.suffLen+=left.suffLen;
        }

        parent.maxLen=Math.max(left.maxLen,right.maxLen);

        if(left.suffChar==right.prefChar){
            parent.maxLen=Math.max(parent.maxLen,left.suffLen+right.prefLen);
        }
    }

    public void update(int node,int start,int end,int index,char val){
        if(start==end){
            arr[index]=val;
            tree[node].setLeaf(val);
            return;
        }

        int mid=start+(end-start)/2;
        int leftChild=2*node+1;
        int rightChild=2*node+2;

        if(index<=mid){
            update(leftChild,start,mid,index,val);
        }else{
            update(rightChild,mid+1,end,index,val);
        }

        merge(tree[node],tree[leftChild],tree[rightChild]);
    }

    public int getMaxLen(){
        return tree[0].maxLen;
    }
}

class Solution {
    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int k=queryIndices.length;
        
        int result[]=new int[k];
        SegmentTree tree=new SegmentTree(s);

        for(int i=0;i<k;i++){
            tree.update(0,0,s.length()-1,queryIndices[i],queryCharacters.charAt(i));
            result[i]=tree.getMaxLen();
        }

        return result;
    }
}
