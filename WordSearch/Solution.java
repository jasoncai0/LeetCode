package WordSearch;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhensheng on 2016/1/25.
 */
public class Solution {
    /**
     * 不知名错误， 不知道错在哪里啊啊啊啊啊 啊啊啊啊 ！！！
     * @param board
     * @param word
     * @return
     */
    /*
    public boolean exist(char[][] board, String word) {
        int m  = board.length;
        if(m== 0 ) return false ;
        int n = board[0].length;
        boolean visited[][] = new boolean[m][n];
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n  ; j++) {
                if(board[i][j] ==word.charAt(0))
                    if( exist(board,i,j ,m,n , 0 , word,visited))
                        return true;

            }

        }
        return false;

    }
    public boolean exist(char[][]board , int row , int col , int m, int n ,int index ,String word ,boolean [][]visited) {
        if (index >= word.length()) return true;
        if (row >= 0 && row < m && col >= 0 && col < n&& word.charAt(index) == board[row][col]){
            visited[row][col] =true;
            boolean up =  row> 0 && col< n &&!visited[row-1][col]&& exist(board, row - 1, col, m, n, index + 1, word, visited );
            boolean left =  row <m && col > 0 && !visited[row][col-1] && exist(board, row, col - 1, m, n, index + 1, word,visited);
            boolean down = row< m-1 &&col<n&&!visited[row+1][col] && exist(board, row + 1, col, m, n, index + 1, word,visited);
            boolean right = row<m &&col < n-1 && !visited[row][col+1] && exist(board, row, col + 1, m, n, index + 1, word,visited);
            if (up || down || right || left);
                return true;
        }

        return false;
    }*/
    public boolean exist(char[][] board, String word) {

        return false;
    }
    public static void main(String[]args){
        Set<Integer> s = new HashSet<>();
        s.add(1);
        s.add(2);
        s.add(5);
        s.add(3);
        s.add(4);
        s.forEach(System.out::print);
        Solution ss= new Solution ();
        char[][]a ={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(ss.exist(a,"ABCDEFG"));
    }




}
