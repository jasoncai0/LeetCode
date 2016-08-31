package LUCKYSYRING;

import java.util.*;

/**
 * Created by zhensheng on 2016/7/25.
 */
public class Main {
    /*
    public static void dfs(HashSet<String> ret, StringBuilder cur , int index, String str,int size,  int a , int b , Set<Character> chars){
        if(index>=str.length() ){
            if(size == b ){
                ret.add(cur.toString());
            }
            return ;
        }
        char ch = str.charAt(index) ;
        dfs(ret, cur,index+1 ,str, size , a, b ,chars );

        StringBuilder sb= new StringBuilder(cur);
        sb.append(ch);
        //cur.append(ch);
        if(chars.contains(ch)){
            if(size == b ){
                ret.add(sb.toString());
                //dfs(ret, cur,index+1 ,str, size , a, b ,chars );
            }
            else{
                //dfs(ret, cur,index+1 ,str, size , a, b ,chars );
            }
        }
        else {
            chars.add(ch);
            size ++ ;
            if(size == b ){
                //b= a+b ;
                //a = size ;
                ret.add(sb.toString());
                //dfs(ret, cur,index+1 ,str, size , a, b ,chars );
            }else if(size >b ){
                int temp = a+b ;
                a = b ;
                b = temp ;
                if(size == b ){
                    ret.add(sb.toString());
                }
                //dfs(ret, cur,index+1 ,str, size , a, b ,chars );
            }
        }
        dfs(ret, sb,index+1 ,str, size , a, b ,chars );
    }*/

    public static void dfs(Set<String> ret, StringBuilder cur,int index, String str, int[] fib, Set<Character> chs){
        if(index>= str.length()) {
            if(fib[chs.size()] ==1){
                ret.add(cur.toString());
            }
            return ;
        }
        char ch = str.charAt(index);
        StringBuilder sb = new StringBuilder(cur).append(ch);
        dfs(ret,cur,index+1 , str,fib , chs);
        cur.append(ch);
        if(chs.contains(ch)){
            dfs(ret,sb,index+1, str, fib,chs);
        }else{
            //chs.add(ch);
            Set<Character> chars = new HashSet<>(chs);
            chars.add(ch);
            dfs(ret, sb, index + 1, str, fib, chars);
        }

    }
    public static void main(String []args){
        Scanner in = new Scanner(System.in);
        int fib[] = new int[27];
        int a = 1 ;
        int b = 1 ;
        while(b <=26){
            fib[b]=1 ;
            int c= a+b ;
            a=b;
            b =c ;
        }


        while(in.hasNext()){
            String str = in.next();
            HashSet<String> ret = new HashSet<>();


            //dfs(ret, new StringBuilder() ,0,str,fib,new HashSet<>());
            for(int i =  0 ; i < str.length() ; i++ ){
                Set<Character> chs = new HashSet<>();
                for (int j = i; j <str.length() ; j++) {
                    char ch = str.charAt(j);
                    chs.add(ch);
                    if(fib[chs.size()] ==1 ) {
                        ret.add(str.substring(i,j+1));
                    }
                }
            }
            List<String> arr = new ArrayList<>(ret);
            Collections.sort(arr, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return 0;
                }
            });
            for(String s: arr){
                System.out.println(s);
            }
        }
    }
}
