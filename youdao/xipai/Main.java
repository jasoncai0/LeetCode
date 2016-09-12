package youdao.xipai;

import java.util.Scanner;

/**
 * Created by zhensheng on 2016/8/31.
 */
public class Main {

    static int n;
    public static void shuffle(int [] cards, int k ){
        int temp [] = new int[2*n];
        for (int i = 0; i <k ; i++) {

            for(int j = 0 ; j< 2*n ; j++ ){
                temp[j] = cards[j];
            }
            for (int j =0 ; j <n   ; j++) {
                cards[2*j] = temp[j] ;
                cards[2*j+1 ] = temp[j+n];
            }

        }
        for (int j = 0; j <2* n-1 ; j++) {
            System.out.print(cards[j]+" ");
        }
        System.out.println(cards[2*n -1 ] );

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int T = in.nextInt();
            for (int i = 0; i < T ; i++) {
                n= in.nextInt();
                int k = in.nextInt();
                int cards [] = new int [2*n] ;
                for (int j = 0; j < 2* n ; j++) {
                    cards[j]= in.nextInt();
                }

                shuffle(cards,k);



            }
        }
    }
}
