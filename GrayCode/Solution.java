package GrayCode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhensheng on 2016/1/10.
 */
public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        if(n < 0 ) return ret ;
        if(n == 0  ){
            ret.add(0);
            return ret ;
        }
        List<Integer> pre = grayCode(n-1 ) ;
        ret = new ArrayList<>(pre);
        int num = 1 << (n-1);

        for(int i = pre.size()-1 ; i >=0 ; i-- ){
            ret.add(num+ pre.get(i));
        }

        return ret;
    }
    public static void main(String[] args){
        Solution s= new Solution();
        StringBuffer sb = new StringBuffer();
        sb.insert(0,12);
        System.out.println(sb.toString());
        String[] ls = {"ate","eat","att"};

        System.out.println(s.grayCode(2));
    }
}
