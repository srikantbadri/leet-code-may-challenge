class TrieNode{
    public TrieNode [] nodeArr;
    public boolean isEndOfWord;
    TrieNode(){
        nodeArr=new TrieNode[26];
        isEndOfWord=false;
    }
}
class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root=new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        int len=word.length();
        TrieNode temp = root;
        for(int i=0;i<len;i++){
            if(temp.nodeArr[word.charAt(i)-'a'] == null)
            temp = temp.nodeArr[word.charAt(i)-'a']=new TrieNode();
            else
                temp=temp.nodeArr[word.charAt(i)-'a'];
        }
        temp.isEndOfWord=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        int len=word.length();
        TrieNode temp = root;
        for(int i=0;i<len;i++){
            if(temp!=null && temp.nodeArr[word.charAt(i)-'a']!=null)
                temp = temp.nodeArr[word.charAt(i)-'a'];
            else
                return false;
        }
        if(temp!=null && temp.isEndOfWord)return true;
        return false;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        int len=prefix.length();
        TrieNode temp = root;
        for(int i=0;i<len;i++){
            if(temp!=null && temp.nodeArr[prefix.charAt(i)-'a']!=null)
                temp = temp.nodeArr[prefix.charAt(i)-'a'];
            else
                return false;
                
        }
        if(temp!=null)return true;
        return false;        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
