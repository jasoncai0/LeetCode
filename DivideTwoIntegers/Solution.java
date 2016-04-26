package DivideTwoIntegers;

/**
 * Created by zhensheng on 2015/11/21.
 */
public class Solution {
    public int divide(int dividend, int divisor) {

        long res  = 0 ;
        int flag = 1 ;
        if ((dividend > 0&& divisor<  0) || (dividend< 0 && divisor>0 ) ) flag = -1 ;
        long a = Math.abs(dividend);
        long b = Math.abs(divisor);
        long count=1  ;
        long temp =b ;
        while(temp <a ){
            temp = temp<<1 ;
            count = count <<1;
        }
        temp =temp >>1 ;
        count = count >>1 ;
        long left =a ;
        while (left>=b){
            //很奇怪为什么一开始先算好最大到哪反而超时，反而用，每次都要重新算多大反而不超时
            /*
            while(temp > left ){
                temp =temp>>1 ;
                count = count >>1;
            }
            if(left >= temp ){
                res+= count ;
                left -= temp;
            }
            temp = temp>>1;
            count = count >>1 ;
            */
            count =1 ;
            temp = b;
            while ((temp<<1) <= left ){
                temp <<= 1 ;
                count <<= 1 ;
            }
            res+= count ;
            left -= temp;
        }
        if(flag==-1 ) return (int)res*flag ;
        if( res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else return (int)res;

    }
    public static  void main(String[] args){
        Solution s = new Solution();
        int [] a=  {1,2,3,-1 ,5,4,8 };
        System.out.println(s.divide(10,-2));
    }
}
