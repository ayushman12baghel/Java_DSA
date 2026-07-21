//Approach Using Trie O(L+S)
class TrieNode{
    TrieNode children[];
    boolean endOfWord;

    public TrieNode(){
        this.children=new TrieNode[26];
        endOfWord=false;
    }
}

class Trie{
    TrieNode root;

    public Trie(){
        this.root=new TrieNode();
    }

    public void insert(String word){
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

    public boolean find(String word) {
        TrieNode current=root;

        for(char c:word.toCharArray()){
            int index=c-'a';

            if(current.children[index]==null){
                return false;
            }

            current=current.children[index];
        }

        return current.endOfWord;
    }

    public String getShortestRoot(String word){
        TrieNode current=root;
        StringBuilder sb=new StringBuilder();

        for(char c:word.toCharArray()){
            int index=c-'a';

            if(current.children[index]==null){
                break;
            }

            current=current.children[index];
            sb.append(c);
            if(current.endOfWord){
                return sb.toString();
            }
        }

        return word;
    }
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        String words[]=sentence.split(" ");

        Trie root=new Trie();

        for(String word:dictionary){
            root.insert(word);
        }

        StringBuilder ans=new StringBuilder();
        for(String word:words){
            ans.append(root.getShortestRoot(word)).append(" ");
        }
        ans.deleteCharAt(ans.length()-1);

        return ans.toString();
    }
}
