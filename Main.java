import java.util.Scanner;

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
class Trie {
    private TrieNode root;
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
    public int countStartsWith(String word ){
        TrieNode cur = root ;
        int ret=0;
        for(char ch :word.toCharArray()){
            int index = ch-'a';
            if(cur.child[index] == null ){
                return ret  ;
            }
            cur=cur.child[index];
        }
        ret= count(cur);
        return ret;
    }
    public int count(TrieNode cur){
        int sum = 0 ;
        if(cur.isEnd){
            sum++;
        }
        for(int i = 0 ; i <26  ; i++ ){
            if(cur.child[i] != null ){
                sum+= count(cur.child[i]);
            }

        }
        return sum;
    }

}

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            String words ;
            Trie  trie= new Trie();

            for (int i = 0; i <n ; i++) {
                words= in.next();
                trie.insert(words);
            }
            int m = in.nextInt();
            String prefixs[] =new String[m];
            for (int i = 0; i < m; i++) {
                prefixs[i]= in.next();
                System.out.println(trie.countStartsWith(prefixs[i]));
            }
        }

    }


}
