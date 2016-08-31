package nowcoder.GetNumberOfK;

import java.util.Arrays;
import java.util.Date;

/**
 * Created by zhensheng on 2016/7/11.
 */
public class Solution {
    public int binarySearch(int[]array, int k ){
        int lo = 0 ;
        int hi = array.length-1 ;
        while(lo<= hi ){
            int mid = (lo+ hi) /2 ;
            int midVal = array[mid];
            if(midVal < k  ){
                lo = mid+1;
            }
            else if( midVal > k ){
                hi = mid-1 ;
            }
            else return mid;
        }
        return -1 ;
    }
    public int GetNumberOfK(int [] array , int k) {
        int index = binarySearch(array,k );
        if(index< 0 ) return 0 ;
        int count = 1 ;
        for(int i = index-1 ; i>= 0 ; i --  ){
            if(array[i] == k ) count++;
            else break;
        }
        for(int i = index+1 ; i<array.length ; i ++  ){
            if(array[i] == k ) count++;
            else break;
        }
        return count ;
    }
    public static void main(String args[]){
        Solution s = new Solution();
        int a[] = {1,2,2,2,3,4,5,6,7};
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        System.out.println(System.currentTimeMillis());
        System.out.println(date);

        System.out.print(s.GetNumberOfK(a,2));
    }
}
