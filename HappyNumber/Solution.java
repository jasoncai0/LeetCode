package HappyNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhensheng on 2016/1/25.
 */
public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> res = new HashSet<>();
        while(n!= 1 && !res.contains(n)){
            res.add(n);
            int m = n ;
            n = 0 ;
            while(m!=0 ){
                n+= (m%10)*(m%10);
                m/=10 ;
            }

        }
        if(n ==1 ) return true;
        else return false ;

    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.isHappy(12));
    }
}
