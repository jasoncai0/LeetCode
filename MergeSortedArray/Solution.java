package MergeSortedArray;

/**
 * Created by zhensheng on 2016/1/26.
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m+n -1;
        m--;
        n--;
        while (n>=0 && m >=0 ){
            if(nums1[m]>nums2[n])
            {
                nums1[i]=nums1[m];
                m--;
                i--;
            }
            else {
                nums1[i]=nums2[n];
                n--;
                i--;
            }
        }
        while(n>=0){
            nums1[i]= nums2[n];
            i--;
            n--;
        }
    }
}
