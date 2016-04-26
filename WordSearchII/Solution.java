package WordSearchII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhensheng on 2016/4/10.
 */
class TrieNode{
    boolean isEnd ;
    TrieNode[] child;
    String word;
    public TrieNode(){
        //isEnd= true;
        child = new TrieNode[26];
    }
}
class Trie {
    public TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    public void insert(String word){
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
        cur.word= word;

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



}
public class Solution {
    public void search(int i , int j, char[][] board, StringBuilder sb , TrieNode cur,List<String> ret){
        int index = board[i][j] -'a';
        int dx [] = {0,1,0,-1};
        int dy []= {1,0,-1,0};
        if(cur.child[index] == null ) return;
        cur= cur.child[index];
        //sb.append(board[i][j]);
        //System.out.println(sb.toString());
        /*
        if(cur.child[index].isEnd){
            cur.child[index].isEnd= false;
            ret.add(new String(sb.toString()));
        }*/

        if(cur.word != null){
            ret.add(cur.word);
            cur.word= null;
        }
        board[i][j] = 0 ;
        for (int k = 0; k <4  ; k++) {
            int nexti = i +dx[k];
            int nextj = j +dy[k];
            if(nexti<0 || nexti >= board.length || nextj < 0 || nextj>= board[0].length )
                continue;
            if(board[nexti][nextj] == 0 ) {
                continue;
            }
            search(nexti,nextj,board,sb,cur , ret);
        }
        board[i][j] = (char) (index+'a');

    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        List<String >ret = new ArrayList<>();
        for(String wd : words){
            trie.insert(wd);
        }
        for (int i = 0; i <  board.length; i++) {
            for (int j = 0; j < board[0].length ; j++) {
                search(i, j , board , new StringBuilder(), trie.root,ret);
            }

        }
        return ret;
    }
    public static void main(String args[]){
        Solution s = new Solution();
        char board[][] = {{'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}};
        String words[] = {"oath","pea","eat","rain"};
        List<String> ret =s.findWords(board, words);
        for(String wd : ret){
            System.out.println(wd);
        }
    }
}
