package BasicCalculator;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by zhensheng on 2016/3/27.
 */
public class SOlution {
    public int calculate(String s) {
        String str= s.trim();
        char[] ch = str.toCharArray();
        Stack<Integer> nums = new Stack<>();
        //Stack<Character> operators = new Stack<>();
        int begin = 0 ;
        //原则是碰到数字进行操作， 碰到符号进行标记， 碰到括号进行栈操作
        int sign =1 , res = 0 ;
        for (int i = 0; i <ch.length ; i++) {
            while( i<ch.length && isDigit(ch[i]) ) i++ ;
            if(i != begin ) res += sign * Integer.parseInt(str.substring(begin,i));
            if(i < ch.length ){
                if(ch[i] == '('){
                    nums.push(res);
                    nums.push(sign);
                    res = 0 ;
                    sign=1 ;
                }
                if(ch[i] == '+'){
                    sign =1 ;
                }
                if(ch[i]=='-'){
                    sign =-1;
                }
                if(ch[i] ==')'){
                    res = res * nums.pop() + nums.pop();
                }
            }
            begin = i+1 ;
        }

        return res;
    }
    public boolean isDigit(char c){
        int temp = c- '0';
        if(temp >=0 && temp <=9) return true;
        return false;

    }
    public static void main(String args[]){
        SOlution s = new SOlution();

        System.out.println(s.calculate("(1+1+(23+2))"));
    }
}
