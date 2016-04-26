package Main;

import java.util.Scanner;

/**
 * Created by zhensheng on 2016/3/23.
 */
/*
public class Main {





    public static void main(String args[]) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Scanner sc = new Scanner(System.in);
        do{
            int n = sc.nextInt();
            int a[]= new int[n];
            boolean flags[] = new boolean[1000];
            for (int i = 0; i < n; i++) {
                a[i]= sc.nextInt();
                flags[a[i]-1] =true;
            }
            for (int i = 0; i <1000 ; i++) {
                if(flags[i]){
                    System.out.println(i+1);
                }
            }


        } while(sc.hasNext());

        sc.close();

    }
}
*/
import java.util.*;
public class Main{
    public static void main(String args[]){
        double d =2.0;
        double f = 2.00000000000000000009;
        System.out.print(String.valueOf(Math.round(f)));
        Scanner sc = new Scanner(System.in);
        do{
            String str = sc.nextLine();
            char target = (char) sc.next().charAt(0);
            int count = 0 ;
            for(int i = 0 ; i< str.length() ; i++ ){
                if(str.charAt(i) == target )count ++ ;
            }
            System.out.println(count);
        }while(sc.hasNext());
        sc.close();
    }
}
