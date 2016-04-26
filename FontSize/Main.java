package FontSize;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by zhensheng on 2016/4/6.
 */
public class Main {


    public static int findSize( int n , int p , int w, int h , int []a ) {
        int hi = Math.min(w, h);
        int lo = 1;
        int sum = 0;
        int size = 0;

        int ret =  1 ;
        while (lo <= hi) {

            size = (lo + hi) / 2;
            sum = 0;
            for (int j = 0; j < n; j++) {
                sum =  (sum + (int )Math.ceil(a[j] / (int)(w / size)));
            }
            int curp = (int) Math.ceil(sum /(int)(h/size) );
            if(curp <= p ){
                ret = Math.max(ret, size );
                lo = size+1 ;
            }
            else hi = size -1;
        }
        return ret;
    }
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int tasks = in.nextInt();
            for (int i = 0; i <tasks ; i++) {
                int n = in.nextInt();
                int p = in.nextInt();
                int w = in.nextInt();
                int h = in.nextInt();
                int a[] = new int[n];
                for (int j = 0; j < n ; j++) {
                    a[j] =in.nextInt();
                }
                System.out.println(findSize(n,p,w,h,a));
            }
        }
        ArrayList a;
    }
}
