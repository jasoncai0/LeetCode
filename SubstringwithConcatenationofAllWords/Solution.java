package SubstringwithConcatenationofAllWords;

import java.util.*;

/**
 * Created by zhensheng on 2015/12/9.
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<Integer>();
        if(words.length== 0 || words[0].isEmpty() || words[0].length()==0 ) return res;
        HashMap<String ,Integer > hm = new HashMap<String ,Integer>();
        for(String word : words){
            if(!hm.containsKey(word)){
                hm.put(word, 1 );
            }
            else{
                hm.put(word,hm.get(word)+1 );
            }
        }
        Integer size = words[0].length();
        Integer len = words.length;
        for(int i = 0 ;i + size* len <s.length() ; i++ ){
            if(hm.containsKey(s.substring(i, i+size ) )){
                HashMap<String , Integer > hm2 = new HashMap<String ,Integer>();
                for(int  j = 0 ; j< len ; j++){
                    String subs = s.substring(i+j *size , i+(j+1)*size );
                    if(hm.containsKey(subs)){
                        hm2.put(subs , hm2.containsKey(subs) ? hm2.get(subs)+1 : 1 );
                        if(hm2.get(subs)> hm.get(subs)) break;
                    }
                    else break;

                }
                if(hm2.equals(hm)) res.add(i);
            }
        }
        return res;

    }

}
