package RestoreIPAddresses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by zhensheng on 2016/4/29.
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        Set<String> ret= new HashSet<>();

        restore(s,0 ,0,  new StringBuilder() , ret);
        return new ArrayList<String>(ret);
    }
    public  void restore(String s , int index ,int level  ,StringBuilder cur , Set<String> ret ){
        if(level == 4 ){
            if(index == s.length() ) {
                ret.add(cur.toString());
                return;
            }
            else return ;
        }
        else if(level > 4 ) return ;
        for(int i = 0  ; i< 3 ; i++){
            if(index+i +1 > s.length() ) break;
            if(s.charAt(index) == '0' && i!=0 ) break;
            int temp = Integer.parseInt(s.substring(index, index+i +1 ));

            if(temp>=0 && temp<=255){
                if(level == 0 ){
                    int start = cur.length();
                    cur.append(temp);
                    int end = cur.length();
                    restore(s,index+i+1, level+1 , cur, ret);
                    cur.delete(start, end );
                }
                else {
                    int start = cur.length();
                    cur.append('.');
                    cur.append(temp);
                    int end = cur.length();
                    restore(s,index+i+1, level+1 , cur, ret);
                    cur.delete(start ,end);
                }
            }

        }

    }
}
