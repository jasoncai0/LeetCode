package ShuffleanArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhensheng on 2016/8/25.
 */
public class Solution {
    List<Integer> origin;
    public Solution(int[] nums) {
        origin = new ArrayList<>();
        for(int num :nums){
            origin.add(num);
        }

    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        if(origin == null ) return null;
        int[] o = new int[origin.size()];
        for (int i = 0; i <origin.size() ; i++) {
            o[i]= origin.get(i);
        }
        return o;

    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(origin == null ) return null;

        int[] s= new int[origin.size()];
        int len = origin.size();
        for (int i = 0; i <len ; i++) {
            int index= (int) (Math.random() * origin.size());
            s[i] = origin.get(index);
            origin.remove(index);
        }
        return s;
    }

    public static void main(String[] args) {
        int nums[]= {1,2,3,4,5};
        Solution obj = new Solution(nums);
        System.out.println(Arrays.toString(obj.reset()));
        System.out.println(Arrays.toString(obj.shuffle()));

    }
}
