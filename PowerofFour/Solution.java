package PowerofFour;

/**
 * Created by zhensheng on 2016/4/18.
 */
public class Solution {
    public boolean isPowerOfFour(int num) {
        if(((num) &(num-1))  != 0  ) return false ;
        while(num >=1 ){
            if(num == 2 ) return false ;
            if(num == 1 ) return true;
            num= num>>>2;
        }
        return false;

    }
}
