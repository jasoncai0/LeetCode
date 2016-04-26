package CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhensheng on 2015/12/29.
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);//保证递增
        List<List<Integer> > ret= new ArrayList<>();
        dfs(ret, new ArrayList<Integer>(), candidates,target , 0 );
        return ret;
    }
    public void dfs(List<List<Integer>> ret, List<Integer> cur , int []candidates, int target , int start ){
        if(target> 0 ){
        for(int i = start ; i<candidates.length; i++){
            cur.add(candidates[i]);
            dfs(ret, cur, candidates, target-candidates[i], i );
            cur.remove(cur.size()-1 );
        }
        }
        else if(target ==0 ){
            //ret.add(cur);//此处错误 不能添加原cur 的引用， 因为后续修改的时候会一样将这个cur 修改， 所以最后 cur都为空
            ret.add(new ArrayList<Integer>(cur));

        }

    }
    public static void main(String[] args){
        Solution s =new Solution();
        int a[] = {1};
        System.out.println(s.combinationSum(a,1));
    }

}
