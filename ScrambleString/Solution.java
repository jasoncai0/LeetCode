package ScrambleString;

/**
 * Created by zhensheng on 2016/4/16.
 */
public class Solution {
    public boolean isScramble(String s1, String s2) {
         //return isScramble(s1, 0 ,s1.length()-1 , s2, 0 , s2.length()-1 ) ;

        return false;
    }


    /*
    public boolean isScramble(String s1  , int begin1 , int end1 , String s2, int begin2 , int end2){
        if(end1 - begin1  != end2 - begin2){
            return false ;
        }
        if(end1 == begin1 ){
            return s1.charAt(begin1) == s2.charAt(begin2);
        }

        int mid1 = (begin1 + end1 )/2 ;
        int mid2 = (begin2+end2)/2;
        if( (end1-begin1)%2 ==1){
            return (isScramble(s1, begin1, mid1 ,s2 ,begin2,mid2)&&isScramble(s1,mid1+1 , end1 , s2 , mid2+1 , end2) )||
                    (isScramble(s1 ,begin1 , mid1 ,s2 , mid2 +1  ,end2 ) && isScramble(s1,mid1+1 , end1 ,s2, begin2 , mid2 ));
        }
        else{
            return (isScramble(s1, begin1, mid1 ,s2 ,begin2,mid2)&&isScramble(s1,mid1+1 , end1 , s2 , mid2+1 , end2))||
                    (isScramble(s1,begin1,mid1-1 , s2 , mid2+1   ,end2 )  && isScramble(s1,mid1 ,end1 , s2 , begin2 , mid2));
        }

    }*/
    public static void main(String args[]){
        Solution s = new Solution();
        System.out.println(s.isScramble("rgtae" ,"great"));
    }
}
