package LargestDivisibleSubset;

import java.util.*;

/**
 * Created by zhensheng on 2016/6/29.
 */
public class Solution {

    /***
     * WRONG ANSWER case [3,4,16,8 ] - > [4,8,16 ] ,not[4,16]
     * 并不是按顺序的字串 ，这里出错， 而是只要最长的能除的子集合 ,所以需要先排序，这样就是最长的子集合（）而非序列 了
     * @param nums
     * @return
     */

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        Map<Integer , Integer > mapIndex = new HashMap<>();
        if(nums.length == 0 ) return new ArrayList<>();
        int[] dp = new int[nums.length];
        int max =0 ;
        int maxIndex = 0 ;
        for(int i = 0 ; i< nums.length ; i++ ){
            dp[i] = 1;
            for (int j = 0; j < i ; j++) {
                if(nums[i] % nums[j] == 0 ) {
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] +1 ;
                        mapIndex.put(i , j ) ;

                    }
                }
                if(dp[i] >max){
                    max = dp[i] ;
                    maxIndex = i ;
                }
                //max = Math.max(dp[i] , max)
            }
        }
        List<Integer> ret = new ArrayList<>();
        ret.add(0,nums[maxIndex]);
        while(mapIndex.containsKey(maxIndex)){
            ret.add(0,nums[mapIndex.get(maxIndex)]);
            maxIndex= mapIndex.get(maxIndex);
        }
        return ret;

    }


    public static void main(String args[]){
        Solution s = new Solution();
        int a [] = {2,3,5,6};
        List<Integer > ret = s.largestDivisibleSubset(a);
        System.out.println(ret);
    }
}
