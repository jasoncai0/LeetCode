package DecodeWays;

/**
 * Created by zhensheng on 2016/3/9.
 */
public class Solution {
    /*
    public int numDecodings(String s) {
        char [] ch = s.toCharArray();
        return numDecodings(ch, 0);
    }

    public int numDecodings(char [] ch , int begin){
        if (begin >=ch.length ) return 1 ;
        int ret = 0 ;
        if(decode(ch[begin])){
            ret += numDecodings(ch , begin +1 ) ;
        }
        if(begin+ 1 < ch.length && decode(ch[begin] ,ch[begin+1 ])){
            ret += numDecodings(ch, begin+2 ) ;

        }
        return ret ;
    }*/
    public boolean decode(char a ){
        int numa = a-'0';
        if(numa >  0 && numa < 10 ){
            return true;
        }
        return false ;
    }
    public boolean decode(char a , char b ){
        int numa = a-'0';
        int numb = b -'0';
        int total = numa * 10 + numb;
        if(total >=10 && total <=26) return true;
        return  false ;
    }


    public int numDecodings(String s ){
        char ch[]= s.toCharArray();
        if(s.length()== 0 ) return 0;
        int res[] =new int [s.length()];
        for (int i = s.length()-1 ; i >= 0  ; i--) {
            if(decode(ch[i])){
                if(i==s.length()-1 ){
                    res[i] = 1 ;
                }
                else res[i]+= res[i+1];

            }
            if(i< s.length()-1 && decode(ch[i],ch[i+1])){
                if(i<=s.length()-3 )
                    res[i] += res[i+2];
                else res[i] +=1  ;
            }
        }
        return res[0];

    }
    public static void main(String []args){
        Solution s = new Solution();
        System.out.println(s.numDecodings("127"));
    }

}
