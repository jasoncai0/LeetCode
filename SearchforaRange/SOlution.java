package SearchforaRange;

/**
 * Created by zhensheng on 2016/4/2.
 */
public class SOlution {
    public int[] searchRange(int[] nums, int target) {
        int lo = 0 ;
        int hi = nums.length-1;
        int mid=0 ;
        while(lo<= hi ){
            mid = (lo+ hi)/2 ;
            if(nums[mid] > target) hi = mid -1;
            else if(nums[mid]< target) lo = mid +1;
            else break;
        }
        int ret[] = new int [2];
        if(nums[mid] != target) {
            ret[0] =-1;
            ret[1 ] = -1 ;
            return ret;
        }
        int i = mid ;
        while( i >  0 && nums[i-1] == target){
            i--;
        }
        ret[0] = i;
        int j = mid ;
        while(j < nums.length-1 && nums[j+1 ] ==target){
            j++;
        }
        ret[1]=  j ;
        return ret;
    }
    public static void main(String []args ){
        SOlution s= new SOlution();
        int a []={5, 7, 7, 8, 8, 10};
        int b[] = s.searchRange(a, 8);
        for(int c :b){
            System.out.println(c);
        }
    }
}
