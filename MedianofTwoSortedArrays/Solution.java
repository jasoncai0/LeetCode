package MedianofTwoSortedArrays;

/**
 * Created by zhensheng on 2016/3/29.
 */
public class Solution {

    /**
     *
     * @param nums1
     * @param nums2
     * @return
     */
    /*通过二分法查找i 的位置，对k-i位置为j k= （len1+len2+1 ）/2
    i=0; bj-1
    j=0; ai-1特殊情况~！！边界的判断不能忘记 ~~！！
    ...Ai-1 | Ai...
    ...bj-1 | Bj...
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 >  len2 ) return  findMedianSortedArrays(nums2, nums1) ;
        int half = (len1 + len2 +1 ) /2 ;//+1 针对奇数的情况，多出的一个数， 放在左半部分
        int lo = 0;
        int hi = len1 ;// 必须是len1 erbuneng -1
        int i =  0 ;
        int j = 0 ;
        while(lo <= hi){
            i  =(lo+hi)/2;
            j = half - i ;
            if(i> 0&& j <len2&& nums1[i-1] > nums2[j]) hi = i-1 ;
            else if( i< len1 && j > 0&& nums2[j-1]> nums1 [i]) lo = i+1 ;
            else {
                int left  ;
                int right ;
                if(i == 0 ){
                    if(j==0 ) return (nums1[0]+ nums2[0])/2.0;
                    else left = nums2[j-1];
                }
                else if ( j == 0 ){
                    left = nums1[i-1];
                }
                else left = Math.max(nums1[i-1]  , nums2[j-1]);
                if((len1+ len2 )%2 == 1 ) return left;
                if(i == len1 ){
                    if( j ==len2 ) return (nums1[i-1] + nums2[j-1])/2.0;
                    else right = nums2[j];
                }
                else if( j == len2 ) {
                    right = nums1[i];
                }
                else right = Math.min(nums1[i], nums2[j]);
                return (left+ right )/2.0;

            }
        }
        return 0;

    }
    public static void main(String args[]){
        Solution s = new Solution();
        int a[] = {1,2,3,4};
        int b[] ={1};
        System.out.println(s.findMedianSortedArrays(a,b));
    }
}
