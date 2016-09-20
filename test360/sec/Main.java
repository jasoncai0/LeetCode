package test360.sec;

import java.util.Scanner;

/**
 * Created by zhensheng on 2016/9/20.
 */
public class Main {
    public static int get01s(int n ){

        int cur = 1 ;
        if(n == 0 ) return 0 ;
        if( n<=9 ) return 1 ;

        int k = (int ) Math.log10(n)  +1  ; //位数
        int pow = (int) Math.pow(10, k-1 );
        //System.out.println("k " + k);

        int hi = n / pow ;
        //System.out.println("hi"+hi);
        int left = n - hi* pow;
        if(hi >=2 ) return (int ) Math.pow(2,k )-1;
        else {
            return (int) Math.pow(2,k-1) + get01s(left);
        }

        /*
        int base  =1   ;
        int sum = 0;
        while(n > 0 ){
            if( n %10  >=1 ) sum += base;
            base *=2 ;
            n= n/10 ;

        }
        return sum ;*/

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            System.out.println(get01s(n));
        }
    }
}
