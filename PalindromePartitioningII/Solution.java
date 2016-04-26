package PalindromePartitioningII;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhensheng on 2016/2/25.
 */
public class Solution {
    //直接从0 开始从index= 0 开始贪心有问题 ，从长度开始贪心？
    // 每次都选取当前情况下最长的回文， --》 怎么选？  for 长度 length  -》  1 ， for 0 -》 len-1
    //
    //DP
    public int minCut(String s) {
        char []ch = s.toCharArray();
        int size = ch.length;
        int cut[] = new int [size ];
        boolean isPalin [][] =new boolean [size][size];
        for (int i = 0; i <size ; i++) {
            int min= i ;
            for (int j = 0; j <= i ; j++) {
                if((j+1 > i-1 ||isPalin[j+1][i-1]) && (ch[j]==ch[i])){
                    isPalin[j][i] =true;
                    if(j == 0 ){
                        min = 0 ;
                    }
                    else {
                        min = Math.min(min, cut[j-1]+1 );
                    }
                }
            }
            cut[i] = min;
        }
        return cut[size-1];
    }

    public static  void main(String[]args){
        Solution s= new Solution();
        System.out.println(s.minCut("abcddcb"));
    }
}
