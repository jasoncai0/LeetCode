package ReversePairs;

/**
 * Created by zhensheng on 2015/11/5.
 */
public class Solution {
    private int  mergesort(int[]arr , int begin , int end ){
        int mid = (begin+ end) /2 ;
        if(begin >= end ) return 0 ;
        int left = mergesort(arr, begin ,mid );
        int right = mergesort(arr ,mid+1 ,end );
        int []arr2 = new int[end-begin +1 ];
        int indexLeft = mid ;
        int indexRight = end ;
        int indexNow = end -begin  ;
        int count  = 0 ; //计算已经有的逆序对 ，当出现前半段大于后半段数的时候选择，加上它及其他前面数的个数
        while (indexLeft >= begin && indexRight>= mid+1 ){
            if(arr[indexLeft] > arr[indexRight]){
                count = count + (indexRight - mid  );
                arr2[indexNow] = arr[indexLeft];
                indexNow--;
                indexLeft--;
            }
            else {
                arr2[indexNow]= arr[indexRight];
                indexNow--;
                indexRight--;
            }
        }
        while(indexLeft >=begin){
            arr2[indexNow--] = arr[indexLeft--];
        }
        while(indexRight>=mid+1 ){
            arr2[indexNow--] = arr[indexRight--];
        }

        for(int i =begin  ; i<=end ; ++i ){
            arr[i] = arr2[i-begin];
        }
        return left + right + count ;
    }
    public int InversePairs(int [] array) {
        int size = array.length ;
        if(size <=1 ) return 0 ;
        else return mergesort(array,0 ,size-1);
    }
    public static void main(String[] args){
        int[]array = {9,3,2,5,1};
        Solution s =new Solution();
        int ret= s.InversePairs(array);
        System.out.println(ret);
    }

}
