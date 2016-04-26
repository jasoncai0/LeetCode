package LongestValidParentheses;

import java.util.Stack;

/**
 * Created by zhensheng on 2015/12/10.
 */
public class Solution {
    /*
    TLE Time Limit Exceeded
     */
    /*
    public int longestValidParentheses(String s) {

        int max = 0 ;
        for(int i= 0 ;i< s.length() ; ++i ){
            int st = 0 ;
            int count = 0 ;
            for(int j =  i ; j <s.length(); ++j){
                char c = s.charAt(j);
                if(c== '('){
                    st++;
                }
                else if(c==')'){
                    if(st >0 ) {
                        st--;
                        count ++;
                    }
                    else {
                        break;
                    }
                }

            }
            if(count >max){
                max = count ;
            }
        }
        return max ;
    }*/
    /*
    public int longestValidParentheses(String s) {

        int max = 0 ;
        for(int i= 0 ;i< s.length() ; ++i ){
            int st = 0 ;
            int temp = 0;
            int count = 0 ;
            int j = i ;
            for( ; j <s.length(); ++j){
                char c = s.charAt(j);
                if(c== '('){
                    st++;
                }
                else if(c==')'){
                    if(st >0 ) {
                        st--;
                        if(st== 0 ){
                            count += temp  +1 ;
                            temp = 0;
                        }
                        else{
                            temp++;
                        }

                    }
                    else {
                        break;
                    }
                }

            }

            i= j;
            if(count >max){
                max = count ;
            }
            if(temp > max ){
                max= temp;
            }
        }
        return 2*max ;
    }*/
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<Integer>();
        for(int i= 0 ; i< s.length() ; i++ ){
            char c = s.charAt(i);
            if(c=='('){
                st.push(i);
            }
            else {
                if(!st.empty()){
                    if(s.charAt(st.peek()) =='(' )  {
                        st.pop();
                    }
                    else st.push(i);
                }
                else st.push(i);
            }
        }
        int max= 0 ;

        if(st.empty()) max = s.length();
        else {
            int a = s.length();
            int b = 0;
            while(!st.empty()){
                b = st.peek();
                if(max <a-b -1 ) max= a-b-1 ;
                a= b;
                st.pop();
            }
            if(max<a ) max = a ;
        }
        return max ;
    }

    public static void main(String[] args){

        Solution s =new Solution();

        //int ret= s.InversePairs(array);
        System.out.println(s.longestValidParentheses(")"));
    }
}
