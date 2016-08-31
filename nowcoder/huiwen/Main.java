package nowcoder.huiwen;

import java.util.Scanner;

/**
 * Created by zhensheng on 2016/7/16.
 */
public class Main {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            String str =  in.nextLine();
            int len = str.length();
            int dp[][] = new int[len+1][len+1];
            for (int i =0; i <len ; i++) {

                for (int j = 0; j <len ; j++) {
                    if(str.charAt(i) == str.charAt(len-j-1 ) ){
                        dp[i+1][j+1] = dp[i][j]+1 ;
                    }
                    else {
                        dp[i+1][j+1] = Math.max(Math.max(dp[i][j],dp[i+1][j] ),dp[i][j+1]);
                    }
                }


            }
            System.out.println(len- dp[len][len]);
        }
    }
}
