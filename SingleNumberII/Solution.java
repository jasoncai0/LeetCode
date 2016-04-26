package SingleNumberII;

/**
 * Created by zhensheng on 2016/2/25.
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int count[] = new int [32];
        for (int i = 0; i < 32; i++) {
            for(int num :nums){
                count[i]+= num>>i &1 ;
            }
        }
        int ret =0 ;
        for (int i = 0; i < 32; i++) {
            int temp = (count[i] %3 ==0 )? 0 : 1 ;
            ret += temp<<i ;

        }
        return  ret;
    }
    public static void main(String[]args){
        Solution s = new Solution();
        int a[] = { 1,1,1,2,2,2,3,3,3};
        System.out.println(s.singleNumber(a));
    }
}
