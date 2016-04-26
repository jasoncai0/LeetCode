package CheckSame;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by zhensheng on 2016/3/30.
 */
public class Same {
    public boolean checkSam(String stringA, String stringB) {
        // write code here
        String[] as = stringA.split("\\s+");
        String[] bs = stringB.split("\\s+");
        HashMap<String ,Integer> hm = new HashMap<>();
        for(String a : as){
            if (hm.containsKey(a)){
                hm.put(a,hm.get(a)+1);
            }
            else {
                hm.put(a,1);
            }
        }
        for(String b :bs){
            if(hm.containsKey(b)){
                if(hm.get(b) ==1 ){
                    hm.remove(b);
                }else {
                    hm.put(b,hm.get(b)-1);
                }
            }
            else return false ;
        }
        if(hm.isEmpty()) return true;
        else return false ;
    }
    public static void main(String args[]){
        Same s = new Same();
        HashSet<Integer> set = new HashSet<>();
        set.add(2);
        set.add(19);
        set.add(4);set.add(3);
        set.forEach(System.out::println);
        System.out.println(s.checkSam("Here you are","Are you here"));
    }
}
