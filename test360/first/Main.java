package test360.first;

import java.util.Scanner;

/**
 * Created by zhensheng on 2016/9/20.
 */
public class Main {

    public static  boolean check(char[][] dg , int size ){
        for (int i = 0; i <= size /2  ; i++) {
            for (int j = 0; j <size  ; j++) {
                if(dg[i][j] != dg[size-1 - i][size -1 -j ]) return false ;
            }

        }
        return true;
    }
    public static void main(String[] args) {

        int size =3 ;
        Scanner in = new Scanner(System.in);
        char dg[][] = new char[size][size];
        while(in.hasNext()){
            boolean flag = true;
            for(int i =0 ; i< size ; i++){
                String str= in.next();
                if(str.length() <3  ) {
                    flag = false;
                    break;
                }
                for (int j = 0; j <size ; j++) {
                    dg[i][j] = str.charAt(j);


                }

            }
            if(check(dg, size ) && flag ) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
