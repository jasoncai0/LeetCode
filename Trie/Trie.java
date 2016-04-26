package Trie;

/**
 * Created by zhensheng on 2016/4/8.
 */
class TrieNode{
    boolean isEnd ;
    TrieNode[] child;
    public TrieNode(){
        //isEnd= true;
        child = new TrieNode[26];
    }
}
public class Trie {
    private TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public void inser(String word){
        TrieNode cur = root;
        for(char ch : word.toCharArray()){
            int index = ch-'a';
            if(cur.child[index] == null ){
                cur.child[index] = new TrieNode();
                //cur.child[index].isEnd = false ;
            }
            cur= cur.child[index];
        }
        cur.isEnd= true;

    }
    public boolean search(String word){
        TrieNode cur = root;
        for(char ch :word.toCharArray()){
            int index = ch-'a';
            if(cur.child[index] == null ){
                return false ;
            }
            cur=cur.child[index];
        }
        if(cur.isEnd == true ) return true;
        else return false;
    }
    public boolean startsWith(String word){
        TrieNode cur = root;
        for(char ch :word.toCharArray()){
            int index = ch-'a';
            if(cur.child[index] == null ){
                return false ;
            }
            cur=cur.child[index];
        }
        return true;
    }

}
