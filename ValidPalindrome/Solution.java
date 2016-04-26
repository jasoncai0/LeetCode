package ValidPalindrome;

/**
 * Created by zhensheng on 2016/3/1.
 */
public class Solution {
    public boolean isPalindrome(String s) {

        char[] ch = s.toCharArray();
        int l =0 ;
        int r = ch.length-1;
        while(r>= l){
            while( l< ch.length &&!isLetter(ch[l]) ) l++;
            while(  r >=0 && !isLetter(ch[r]) )r--;
            if(l>= ch.length || r< 0 ) break;
            if(Character.toLowerCase(ch[l]) !=Character.toLowerCase(ch[r]) )  return false;
            l++;
            r--;
        }
        return true;
    }

    public boolean isLetter(char ch ){
        int a = ch- 'a';
        int b = ch- 'A';
        int c= ch- '0';
        if((a >= 0 && a<26 )|| ((b >=0 && b< 26)) ||(c>=0 && c<10 )){
            return true;
        }
        return false;

    }
    public static void main(String[] args){

        Solution s =new Solution();
        //int ret= s.InversePairs(array);
        System.out.println(s.isPalindrome("0P"));

    }
}
