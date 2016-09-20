package didi.dixiamigong.didi.mowei;

import java.util.Scanner;

/**
 * Created by zhensheng on 2016/9/18.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int base =5 ;
            int count = 0;
            while(n>=base){
                count += n/base ;
                base *= 5;
            }
            System.out.println(count);
        }
    }


}
