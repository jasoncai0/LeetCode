package CombinationSumIV;

import java.util.HashMap;

/**
 * Created by zhensheng on 2016/7/26.
 */
public class Solution {

    public int dfs(int []nums ,HashMap<Integer,Integer> hm, int target){
        if(target < 0 ) return 0 ;
        if(target == 0 ) return 1 ;
        int sum = 0 ;
        for(int num : nums){
            int ntarget = target- num;
            if(ntarget<0 ){
                continue;
            }
            if(hm.containsKey(ntarget)){
                sum = (int) (sum + hm.get(ntarget));
            }else {
                int n = dfs(nums,hm,ntarget);
                hm.put(ntarget,n);
                sum+= n ;
            }

        }
        return  sum ;
    }
    public int combinationSum4(int[] nums, int target) {
        HashMap<Integer, Integer > hm = new HashMap<>();
        return dfs(nums, hm,target);
    }
    public static void main(String args[]){
        Solution s = new Solution();
        int a []= {1,2,3};

        System.out.println(s.combinationSum4(a,4));

    }
}
