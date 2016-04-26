package MultiplyStrings;

/**
 * Created by zhensheng on 2016/1/7.
 */
public class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int []res = new int [len1+len2 ];
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        for(int  j = 0 ; j< len2 ; j ++ ){
            for(int i=  0  ; i< len1 ; i ++ ){
                res[i+j] += (ch1[len1-1- i] - '0') * (ch2[len2-1-j] -'0') ;

            }
        }
        int flag = 0 ;
        StringBuilder sb =new StringBuilder();
        for(int i = 0  ; i < len1+ len2 ; i++ ){
            res[i] += flag ;
            flag =res[i]/10 ;
            res[i] = res[i]%10 ;

        }
        boolean f = true  ;
        for(int i = len1 + len2 -1;i>=0 ; i--){
            if(f ){
                if(res[i]!= 0 )
                {
                    f=false ;
                    sb.append((char)(res[i]+'0'));
                }

            }
            else {
                sb.append((char)(res[i]+'0'));
            }
        }
        if (sb.length()==0) return "0";
        return sb.toString();
    }
    public static void main(String [] args){

        Solution s =new Solution();
        int a[] = {1,2,3};
        System.out.println(s.multiply("0","0"));

    }
}
