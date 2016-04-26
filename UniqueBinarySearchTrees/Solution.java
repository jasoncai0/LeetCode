package UniqueBinarySearchTrees;

/**
 * Created by zhensheng on 2016/2/27.
 */
public class Solution {
    public int numTrees(int n) {
        if(n== 0 ) return 1 ;
        if(n==1 ) return 1;
        int res[] = new int[n+1];
        res[0] =1 ;
        res[1] =0 ;
        //int ret= 0;
        for (int i = 1; i <=n ; i++) {

            for (int j = 1; j <=i ; j++) {
                res[i] += res[j-1] *res[i-j];
            }

        }
        return res[n];
    }
    public static void main(String[]args){
        Solution s = new Solution();
        System.out.println(s.numTrees(3));
    }
}
