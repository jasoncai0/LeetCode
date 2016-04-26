package Alibaba;

/**
 * Created by zhensheng on 2016/4/20.
 */
public class Main {
    public static void choose(int total , int f_mail  , int[] thresholds , int [] reduces ,int []type ){
        //int []ret = new int [2];
        int f_reduce = 0 ;
        int index = 0 ;
        for(int i  = 0 ; i< thresholds.length ; i++ ){
            if(total> thresholds[i]){
                if(reduces[i] > f_reduce){
                    f_reduce = reduces[i];
                    index = i;
                }
            }
        }

        if( f_mail <= f_reduce){
            type[0] = 0 ;
            type[1] = 0 ;
        }
        else{
            type[0] =1 ;
            type[1] = index ;
        }
    }
    public static void main(String []args){

    }

}
