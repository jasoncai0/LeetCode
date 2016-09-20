package acmcoder.jiguchuanhua;

import java.util.Scanner;

/**
 * Created by zhensheng on 2016/9/15.
 */
public class Main {


    public static int getNum(int n, int m ){
        /*
        if(m == 0 ) return 1 ;
        int ret =0 ;
        if(m%2 == 0 ){

            int k= m/2 ;
            ret= 1 ;
            for(int i= 0 ; i< k ;i ++) {
                ret *= (m - i);
                ret /= (i + k);
            }
            ret += getNum(n,n-m )*2 ;
            return ret;

        }

        else {
            if(m< n ) return 0;
            else return getNum(n,n-m) *2 ;
        }
        */
        //System.out.println("Main.getNum");
        int sum = 0 ;
        int count = 1 ;
        for(int i = 0  ; i<= m ; i ++ ){
            int left =  m - i ;
            if(Math.abs(i- left) % n ==0 ) sum+= count;
            count *=(m-i );
            count /=(i+1);

        }
        return sum;


    }
    public static int  getNum2(int n, int m){
        //System.out.println("Main.getNum2");
        int dp[][] = new int[35][35];
        dp[0][1] =1 ;
        dp[1][n] = 1;
        dp[1][2]= 1;
        for (int i = 1; i <= m ; i++) {
            for (int j = 1; j <= n  ; j++) {
                if(j ==1 ){
                    dp[i][j]= dp[i-1][n] + dp[i-1][2];
                }else if(j == n){
                    dp[i][j]= dp[i-1][1] +dp[i-1][n-1];

                }else{
                    dp[i][j] = dp[i-1][j-1] +dp[i-1][j+1];
                }

            }
        }
        return dp[m][1];

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        for (int i = 2; i <30 ; i++) {
            for (int j = 2; j <30 ; j++) {
                int ret= getNum(i,j);
                int ret2 = getNum2(i,j );
                if (ret !=ret2 ) System.out.println("false");
                //else System.out.println("true");
                //System.out.print(ret+  " ");
                //System.out.println(ret2);
            }
        }
    }
}
