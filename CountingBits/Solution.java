package CountingBits;

/**
 * Created by zhensheng on 2016/3/28.
 */
public class Solution {
    public int[] countBits(int num) {
        int[] ret = new int [num+1];
        int base =1 ;
        for (int i = 0; i <= num ; i++) {
            if(i/base ==1 ){
                ret[i] = ret[i%base]+ 1;
            }

            if((i+1)/base ==2 ) base *= 2 ;

        }

        return ret;
    }
    public static void main(String args[]){
        Solution s= new Solution();
        int a[] = s.countBits(5) ;
        for(int b : a){
            System.out.print(b);
        }
    }
}
