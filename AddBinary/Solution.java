package AddBinary;

/**
 * Created by zhensheng on 2016/1/5.
 */
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int flag = 0 ;
        char[] cha = a.toCharArray();
        char[] chb= b.toCharArray();
        int lena = a.length();
        int lenb = b.length();
        int len = Math.min(lena , lenb) ;
        for(int i =0  ; i < len ;  i++ ) {

            int temp = flag+ cha[lena-1-i]- '0' + chb[lenb-1-i]- '0';
            sb.insert(0,(char)(temp%2 +'0'));

            flag = temp/2 ;
        }
        if(lena < lenb){
            for(int i = lena; i< lenb ;i ++ ){
                int temp = flag + chb[lenb-1 -i ] -'0' ;
                sb.insert(0,(char)(temp%2 +'0'));
                flag = temp/2 ;
            }
        }
        else {
            for(int i = lenb ; i< lena ; i++ ){
                int temp= flag + cha[lena-1-i ] -'0';
                sb.insert(0,(char)(temp%2 +'0'));
                flag = temp/2 ;
            }
        }
        if(flag != 0 ) sb.insert(0,'1');
        return sb.toString();
    }
    public static void main(String[]args){
        Solution s =new Solution();
        int a[] = {2};
        System.out.println(s.addBinary("111","11"));
    }
}
