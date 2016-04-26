package util;

import java.util.Vector;

/**
 * Created by zhensheng on 2016/3/24.
 * @author zhensheng
 *
 */
public class Test2 {
    public static void main(String args[]){
        Vector<Integer> v=new Vector(10);
        for (int i=1;i<100; i++ ) {
            Integer o=new Integer(1);
            v.add(o);
           // o= null;
            int ax=0;
            o=o+1;



        }




        for(Integer i : v){
            System.out.println(i);
        }
    }
    @Override
    public Test2 clone() {
        Test2 t = this.clone();
        return t;
    }

}
