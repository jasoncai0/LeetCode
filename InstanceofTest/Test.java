package InstanceofTest;

import org.omg.CORBA.OBJECT_NOT_EXIST;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhensheng on 2016/5/10.
 */
class A{
    int val ;

    public A(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "A{" +
                "val=" + val +
                '}';
    }
}
class B extends A{


    public B(int val) {
        super(val);
        //this.val2 = val2;
    }

    @Override
    public String toString() {
        return "B{" +
                "val=" + super.val +
                '}';
    }
}

class Color {
    public Color(int colorval){
        this.colorval= colorval;
    }
    int colorval;
}

class Point{
    int x;
    int y ;


    public Point(){
        this.x= 0;
        this.y = 0 ;
    }

    public Point(int x, int y ){
        this.x= x ;
        this.y = y;

    }

    public Point(Point p ){
        this.x= p.x;
        this.y = p.y;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
class ColorPoint extends Point{
    Color color;

    public ColorPoint(int x,int y, Color color){
        super(x,y);
        this.color = color;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) {
            //System.out.println("this class "+ getClass());
            //System.out.println("o class "+ o.getClass());
            //System.out.println("class "+ ( getClass() == o.getClass()));
            return false;
        }

        if (!super.equals(o)) return false;

        ColorPoint that = (ColorPoint) o;
        return color == null ?  that.color == null : color.equals(that.color);
        //return !(color != null ? !color.equals(that.color) : that.color != null);

        /*
        if(!(o instanceof  ColorPoint)){
            return false ;
        }
        return super.equals(o)&& ((ColorPoint) o).color == color;
        */

    }


    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (color != null ? color.hashCode() : 0);
        return result;
    }
}
public class Test {

    public static <E extends A> void  unsafe(List<E > list ,E o){
        list.add(o);
    }

    /*
    public static void  unsafe(List<Object > list ,Object o){
        list.add(o);
    }*/
    public static void main(String []args){
        ConcurrentHashMap chm;

        A a = new A(1);
        B b= new B(1);
        List<Object> re = new ArrayList<>();
        re.add("dddd");


        for(Object r : re ){
            System.out.println(r);
        }
        List<? super A> rx = new ArrayList<>();
        rx.add(new B(2));
        rx.add(new A(2));


        for(Object r : rx ){
            System.out.println(r);
        }
        //A xx= rx.get(0); //error!
        //System.out.println(xx);

        System.out.println((a instanceof Object));
        System.out.println((a instanceof A));
        System.out.println((a instanceof B));
        System.out.println((b instanceof A));
        System.out.println((b instanceof B));
        System.out.println("________________________________________________");
        Point p = new Point(1,2);
        Color c = new Color(3);
        ColorPoint cp2 =new ColorPoint(1,2,new Color(4));
        ColorPoint cp = new ColorPoint(1,2,c);
        System.out.println(cp.equals(p));
        System.out.println(p.equals(cp));
        System.out.println(cp2.equals(cp));
        System.out.println(cp.equals(cp2));

        Point p1 = new Point(1,2);
        Point p2 = new Point(p1);
        p2.x= 3;
        System.out.println(p1.x);

        List<A> ret= new LinkedList<>();
        unsafe(ret , b);
        ret.add(b);
        for(A i :ret){
            System.out.println(i);
        }
        List<Object> set = new ArrayList<>();
        set.add("ddd");
        set.add(1);
        Set<?> set2 = new HashSet<>();



    }

}
