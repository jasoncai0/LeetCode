package netease;

/**
 * Created by zhensheng on 2016/9/12.
 */
public class Main {
    public static void main(String[] args) {
        double n = 9 , k =2 ;
        double y , sum = 0 ;
        while(true){
            y = Math.round(n/k);
            sum+=y *y ;
            if(y< 0.5 )  break;
            k*=2 ;
        }
        System.out.println(sum);
    }
}
