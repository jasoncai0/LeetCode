package Forbidden;
import java.util.Scanner;
/**
 * Created by zhensheng on 2016/4/6.
 */
public class Main {

    public static boolean match(long ip , long rule, long  mask){
        System.out.println("IP "+ ip + " Rule " + rule +" mask "+mask);
        return (ip&mask)== (rule& mask);

    }
    public static long str2long(String ipstr){
        long ip = 0;
        String nums[] = ipstr.split("\\.");
        for(String num : nums){
            System.out.println(num);
        }
        for(String num :nums){
            ip = ip<<8;
            ip += Integer.parseInt(num);

        }
        System.out.println("IP :" +ip);
        return ip;
    }
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int m = in.nextInt();
            String allows;
            String rules;
            int masks;
            long mask[] =new long [n];

            boolean allow [] = new boolean[n] ;
            long rule[] = new long[n];
            for (int i = 0; i <n ; i++) {
                allows = in.next();
                rules = in.next();
                if(allows.equals("allow")) allow[i]  = true;
                else allow[i] = false ;
                String [] splitbyDash = rules.split("/");
                if(splitbyDash.length==1 ) masks= 32 ;
                else masks = (int) Integer.parseInt(splitbyDash[1]);
                //long lmask = 0 ;
                for (int j = 0; j < masks ; j++) {
                    mask[i] = (mask[i]<< 1) + 1 ;
                }
                mask[i] = mask[i]<<(32-masks);

                rule[i]= str2long(splitbyDash[0]);
                System.out.println(splitbyDash[0]);

            }
            String ipstr;
            long[] ip = new long[m];
            for (int i = 0; i <m ; i++) {
                ipstr = in.next();

                ip[i]= str2long(ipstr);
            }
            for (int i = 0; i < m ; i++) {
                boolean flag = true ;
                for (int j = 0; j < n ; j++) {
                    //boolean match = match(ip[i],rule[j],mask[j]);
                    boolean match= ((ip[i]& mask[j]) == (rule[j] &mask[j]));
                    if(match){
                        if (allow[j] ) {
                            flag = true;
                            break;
                        }
                        else {
                            flag = false ;
                            break;
                        }
                    }

                }
                if(flag)  System.out.println("YES");
                else System.out.println("NO");
            }
        }
    }
}
