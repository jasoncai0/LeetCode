package netease.lingyichuan;
import java.util.*;
/**
 * Created by zhensheng on 2016/9/18.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                int k = in.nextInt();
                String str =in.next();
                char[] chs = str.toCharArray();
                int lo = 0 ;
                int hi = k-1 ;

                int max = k ;

                int cur = k ;
                int last = 0 ;
                for (int j = 0; j <= chs.length - k  ; j++) {
                    while(j<chs.length && chs[j] == '0' ){
                        //lo++;
                        hi++;
                        j++;
                        cur++;
                        System.out.println(hi +" " + j + " " + cur);
                    }
                    hi++;
                    j++;
                    while(hi<chs.length && chs[hi] == '0'){
                        cur++;
                        j++;
                        hi++;
                        last ++ ;
                        System.out.println(hi +" " + j + " " + cur);
                    }

                    if(cur> max) max =cur;
                    cur =  last+1 ;
                    last = 0 ;
                    
                }
                System.out.println(max);
            }
        }
    }
}
