package Sum4;
import java.util.*;
/**
 * Created by zhensheng on 2015/11/17.
 */
public class Solution {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer> > ret =  new ArrayList<List <Integer> >();
        Arrays.sort(nums);

        int len = nums.length;
        for(int i = 0 ; i<= len-2  ;i++ ){
            while(i<len&& i>0 && nums[i] == nums[i-1]) i++;
            if(i == len ) break;
            int sum3 = target- nums[i];

            for(int j = i+1 ; j < len ;j++){
                while(j<len&& j>i+1 && nums[j] == nums[j-1]) j++;
                if (j==len ) break;
                int sum2 = sum3 - nums[j];
                int low = j+1 ;
                int high =len-1 ;
                while(low < high ){
                    int temp = nums[low]+ nums[high];
                    if(temp == sum2 ){
                        List<Integer> l = new ArrayList<Integer>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[low]);
                        l.add(nums[high]);
                        ret.add(l);

                        while (low<len-1 && nums[low] == nums[low+1 ]) low++;
                        while (high >0 &&nums[high] == nums[high-1] ) high --;
                        low ++ ;
                        high --;
                    }
                    else if(temp > sum2){
                        high--;
                    }
                    else {
                        low++;
                    }
                }

            }
        }
        return ret;

    }
    public static void main (String[] args){

        String s0="kvill";

        String s1="kvill";

        String s2="kv" + "ill";

        System.out.println( s0==s1 );

        System.out.println( s0==s2 );



        Solution s=new Solution();
        int []nums ={-3,-2,-1,0,0,1,2,3};
        System.out.println(s.fourSum(nums,0));


    }
}
