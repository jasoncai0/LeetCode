package BasicCalculatorII;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by zhensheng on 2016/3/28.
 */
public class Solution {




//方法1 可行 其实不用调整顺序的 对于复数直接- 不就醒了么　好蠢～！！
    /**
     * TLE
     * @param s
     * @return
     */
    /*
    public int calculate(String s) {
        String str= s.trim();
        char[] ch = str.toCharArray();
        Stack<Integer> nums = new Stack<>();
        int begin = 0 ;
        Stack<Character> operators = new Stack<>();
        for (int i = 0; i <ch.length ; i++) {
            while( i<ch.length && isDigit(ch[i]) ) i++ ;
            if(i !=begin ) nums.push(Integer.parseInt(str.substring(begin,i)));
            if(!operators.isEmpty() ){

                if(operators.peek() == '*'){
                    int sec = nums.pop();
                    nums.push(nums.pop()* sec);
                }
                if(operators.peek() == '/'){
                    int sec =nums.pop();
                    nums.push(nums.pop() /sec);
                }

            }
            begin = i+1;
            if(i< ch.length && ch[i] == ' ') continue;
            if(i<ch.length) operators.push(ch[i]);


        }
        Queue<Integer> sum = new LinkedList<>(nums);
        Queue<Character> op = new LinkedList<>(operators);
        int ret = sum.poll();
        while(!sum.isEmpty()){
            if( !op.isEmpty()&&op.peek() == '+'){
                ret +=sum.poll();
                op.poll();
            }
            if(!op.isEmpty()&& op.peek() =='-'){
                ret -= sum.poll();
                op.poll();
            }


        }
        return  ret;
    }
    */

    public int calculate(String s) {
        String str= s.replace(" ","");
        char[] ch = str.toCharArray();
        Stack<Integer> nums = new Stack<>();
        int begin = 0 ;
        Stack<Character> operators = new Stack<>();
        for (int i = 0; i <ch.length ; i++) {
            while( i<ch.length && isDigit(ch[i]) ) i++ ;
            if(i !=begin ) nums.push(Integer.parseInt(str.substring(begin,i)));
            begin = i+1;
            if(i< ch.length&& ch[i]== ' ')continue;
            if(!operators.isEmpty() ){

                if(operators.peek() == '*'){
                    int sec = nums.pop();
                    nums.push(nums.pop()* sec);
                    operators.pop();
                }
                else if(operators.peek() == '/'){
                    int sec =nums.pop();
                    nums.push(nums.pop() /sec);
                    operators.pop();
                }

            }
            if((i<ch.length &&(ch[i] == '+' || ch[i] ==  '-' ) ) || i >= ch.length  ) {
                if(!(operators.isEmpty())&& operators.peek() == '+'){
                    int sec = nums.pop();
                    nums.push(nums.pop()+ sec);
                    operators.pop();
                }
                else if(!operators.isEmpty()&& operators.peek() == '-') {
                    int sec = nums.pop();
                    nums.push(nums.pop() -sec);
                    operators.pop();
                }


            }

            if(i< ch.length && ch[i] !=' ')operators.push(ch[i]);

        }

        int ret = nums.pop();
        return  ret;
    }
    public boolean isDigit(char c){
        int temp = c- '0';
        if(temp >=0 && temp <=9) return true;
        return false;

    }
    public static void main(String []args){
        Solution s= new Solution();
        System.out.println(s.calculate("3+5 / 2 "));

    }
}
