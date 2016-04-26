package CountandSay;

/**
 * Created by zhensheng on 2015/12/29.
 */
public class Solution {
    public String countAndSay(int n) {


        int pre = n%10 ;
        int cur= 0 ;
        int count = 1;
        StringBuilder sb = new StringBuilder();
        n= n/10 ;
        while(n != 0){
            cur = n %10 ;
            n = n /10 ;
            if (cur == pre){
                count ++ ;
            }
            else {

                sb.insert(0,pre).insert(0,count);
                count =1 ;
                pre = cur ;
            }


        }
        sb.insert(0,pre).insert(0,count);


        return sb.toString();
    }
    public static void main(String[]args){
        Solution s =new Solution();
        int a[] = {2};
        System.out.println(s.countAndSay(111221));
    }
}
