//Approach Using Trie O(W*L + M*N*3^L)
class TrieNode{
    TrieNode children[];
    String word;

    public TrieNode(){
        children=new TrieNode[26];
        word=null;
    }
}

class Solution {
    int n;
    int m;
    public List<String> findWords(char[][] board, String[] words) {
        n=board.length;
        m=board[0].length;
        TrieNode root=new TrieNode();

        for(String word:words){
            TrieNode current=root;

            for(char c:word.toCharArray()){
                int index=c-'a';

                if(current.children[index]==null){
                    current.children[index]=new TrieNode();
                }

                current=current.children[index];
            }

            current.word=word;
        }

        List<String> ans=new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dfs(board,i,j,root,ans);
            }
        }

        return ans;
    }

    public void dfs(char board[][],int row,int col,TrieNode current,List<String> ans){
        if(row>=n || col>=m || row<0 || col<0 || board[row][col]=='#'){
            return;
        }

        char c=board[row][col];
        int index=c-'a';

        if(current.children[index]==null){
            return;
        }

        current=current.children[index];

        if(current.word!=null){
            ans.add(current.word);
            current.word=null;
        }

        board[row][col]='#';

        dfs(board,row+1,col,current,ans);
        dfs(board,row-1,col,current,ans);
        dfs(board,row,col+1,current,ans);
        dfs(board,row,col-1,current,ans);
        
        board[row][col]=c;
    }
}

//With Some improvements 
class TrieNode{
    TrieNode children[];
    String word;

    public TrieNode(){
        children=new TrieNode[26];
        word=null;
    }
}

class Solution {
    int n;
    int m;
    public List<String> findWords(char[][] board, String[] words) {
        n=board.length;
        m=board[0].length;
        TrieNode root=new TrieNode();

        for(String word:words){
            TrieNode current=root;

            for(char c:word.toCharArray()){
                int index=c-'a';

                if(current.children[index]==null){
                    current.children[index]=new TrieNode();
                }

                current=current.children[index];
            }

            current.word=word;
        }

        List<String> ans=new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dfs(board,i,j,root,ans);
            }
        }

        return ans;
    }

    public void dfs(char board[][],int row,int col,TrieNode parent,List<String> ans){
        if(row>=n || col>=m || row<0 || col<0 || board[row][col]=='#'){
            return;
        }

        char c=board[row][col];
        int index=c-'a';
        TrieNode current=parent.children[index];

        if(current==null){
            return;
        }

        if(current.word!=null){
            ans.add(current.word);
            current.word=null;
        }

        board[row][col]='#';

        dfs(board,row+1,col,current,ans);
        dfs(board,row-1,col,current,ans);
        dfs(board,row,col+1,current,ans);
        dfs(board,row,col-1,current,ans);
        
        board[row][col]=c;

        if(current.word==null && isEmpty(current)){
            parent.children[index]=null;
        }
    }

    private boolean isEmpty(TrieNode node) {
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) return false;
        }
        return true;
    }
}
