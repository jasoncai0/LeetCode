package nowcoder.dancijielong;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by zhensheng on 2016/7/15.
 */
public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int num = in.nextInt();
            Set<Character> heads = new HashSet<>();
            Set<Character> tails = new HashSet<>();

            for(int i = 0 ;  i< num ; i++ ){
                String str = in.next();
                char head = str.charAt(0);
                char tail = str.charAt(str.length()-1 ) ;
                if(heads.contains(tail)){
                    heads.remove(tail);
                }else {
                    tails.add(tail);
                }
                if(tails.contains(head)){
                    tails.remove(head);
                }
                else {
                    heads.add(head);
                }
            }
            if(heads.size() >1  || tails.size()>1 ){
                System.out.println("No");
            }else {
                System.out.println("Yes");
            }
        }
    }
}
