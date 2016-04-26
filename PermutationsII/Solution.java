package PermutationsII;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.sort;

/**
 * Created by zhensheng on 2015/12/30.
 */

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {

        Arrays.sort(nums);
        List<Integer > candidates= new ArrayList<>();
        List<List<Integer>> ret= new ArrayList<>();
        int i = 0;
        for(int num : nums){
            candidates.add(num);

        }
        dfs(ret , candidates , new ArrayList<Integer>() );
        return ret;
    }
    public static void dfs(List<List<Integer>> ret , List<Integer> candidates , List<Integer> cur ){
        if(candidates.isEmpty()){
            ret.add(new ArrayList<Integer>(cur));
        }
        else {
            //int pre = -1  ;
            for(int i = 0 ;i< candidates.size(); i ++ ){
                if(i>=1 && candidates.get(i) == candidates.get(i-1) ) continue;

                cur.add(candidates.get(i));
                candidates.remove(i);
                dfs(ret, candidates, cur) ;
                Integer top = cur.get(cur.size()-1);
                cur.remove(cur.size()-1);
                candidates.add(i,top);
            }
        }
    }

    public static void main(String [] args){

        Solution s =new Solution();
        int a[] = {1,1,3};
        System.out.println(s.permuteUnique(a));

    }
}
