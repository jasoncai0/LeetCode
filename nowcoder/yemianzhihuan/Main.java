package nowcoder.yemianzhihuan;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by zhensheng on 2016/7/16.
 */
public class Main {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()){
            int n = in.nextInt();
            int count = 0 ;
            List<Integer> pages = new ArrayList<>(n);
            boolean isFull = false ;
            int curSize= 0 ;
            boolean isExisted = false ;

            int m = in.nextInt();
            for (int i = 0; i < m; i++) {

                int num = in.nextInt();
                if(isFull){
                    isExisted = false ;
                    for(int page :pages){
                        if(num == page )isExisted = true;
                    }
                    if(!isExisted){
                        pages.remove(0);
                        pages.add(num);
                        count++;
                    }
                }
                else {
                    isExisted = false ;
                    for(int page :pages){
                        if(num == page )isExisted = true;
                    }
                    if(!isExisted){
                        pages.add(num);
                        curSize++ ;
                        count++;
                        if(curSize == n ){
                            isFull = true;
                        }
                    }
                }


            }
            System.out.println(count);
        }
    }

}
