package StringIntern;

/**
 * Created by zhensheng on 2016/3/13.
 */
public class Solution {
    public static void main(String [] args){
        String a = "ja";
        String b = "ja";
        String c= "j"+"a";
        String d = new String("ja");

        System.out.println(a==b);
        System.out.println(a==c);
        System.out.println(a==d);
        System.out.println( "**********" );


        String s0= "kvill";

        String s1=new String("kvill");

        String s2="kvill";

        System.out.println( s0==s1 );
        System.out.println( s2==s1 );

        System.out.println( "**********" );

        s1.intern();

       // s2=s2.intern(); //把常量池中“kvill”的引用赋给s2

        System.out.println( s0==s1);

        System.out.println( s0==s2.intern() );

        System.out.println( s0==s2 );
        System.out.println( "**********" );
        String str1 = new StringBuilder("xxxxxx").append("va").toString();
        System.out.println(str1.intern()==str1);
        String str2 = new String("lala的第三方士大夫l");
        System.out.println(str2.intern()==str2);


    }
}
