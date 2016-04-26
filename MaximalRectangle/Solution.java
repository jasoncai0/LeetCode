package MaximalRectangle;

/**
 * Created by zhensheng on 2016/2/26.
 */
public class Solution {
    /*
    public int maximalRectangle(char[][] matrix) {
        int len1 = matrix.length;
        if(len1==0 ) return 0;
        int len2 = matrix[0].length;
        if(len2 == 0 ) return 0 ;
        int max[][] = new int [len1][len2] ;
        boolean used[][] = new boolean[len1][len2];
        for (int i = 0; i < len1 ; i++) {
            for (int j = 0; j < len2 ; j++) {
                if(matrix[i][j]== '0') {
                    used[i][j]= false;
                    max[i][j] = Math.max( i>=1 ? max[i-1][j]  : 0 , j>=1 ?max[i][j-1] : 0  );
                }
                if(matrix[i][j] =='1'){

                }
            }
        }
        return max[len1-1][len2-1] ;
    }
    */
    public int maximalRectangle(char[][] matrix) {
        int ret= 0 ;
        int len1 = matrix.length;
        if(len1==0 ) return 0;
        int len2 = matrix[0].length;
        if(len2 == 0 ) return 0 ;
        int line[] = new int[len2] ;
        boolean isProcessed[] = new boolean[len2] ;
        for (int i = 0; i < len1 ; i++) {
            for (int j = 0; j < len2 ; j++) {
                if(matrix[i][j] == '0'){
                    isProcessed[j] =true;
                    line[j] = 0;
                }
                if(matrix[i][j] =='1'){
                    isProcessed[j]=  false ;
                    line[j] ++;
                }
            }
            int temp =0  ;
            for (int j = 0; j < len2 ; j++) {
                if(isProcessed[j] ) continue;
                int up = 1 ;
                int down = 1;
                while( j -up>=0  && line[j-up] >= line[j]){

                    up++;
                }
                while(j+down <len2 && line[j+down] >= line[j]){
                    if(line[j+down] == line[j] ) isProcessed[j+down] =true;
                    down++;
                }
                temp = (up+down-1)* line[j];
                if(ret < temp ) ret= temp ;

            }

        }
        return ret;
    }

}
