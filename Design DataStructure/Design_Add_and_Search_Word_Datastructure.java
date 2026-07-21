// Approach Using Trie Search = O(26^k.L) k=='.' and L=length of the word 
class TrieNode{
    TrieNode children[];
    boolean endOfWord;

    public TrieNode(){
        this.children=new TrieNode[26];
        this.endOfWord=false;
    }
}

class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root=new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current=root;

        for(char c:word.toCharArray()){
            int index=c-'a';

            if(current.children[index]==null){
                current.children[index]=new TrieNode();
            }

            current=current.children[index];
        }

        current.endOfWord=true;
    }
    
    public boolean search(String word) {
        return solve(word,0,root);
    }

    public boolean solve(String word,int index,TrieNode current){
        if(index>=word.length()){
            return current.endOfWord;
        }

        char c=word.charAt(index);

        if(c=='.'){
            for(int i=0;i<26;i++){
                if(current.children[i]!=null){
                    if(solve(word,index+1,current.children[i])){
                        return true;
                    }
                }
            }

            return false;
        }else{
            int charIndex=c-'a';

            if(current.children[charIndex]!=null){
                return solve(word,index+1,current.children[charIndex]);
            }

            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
