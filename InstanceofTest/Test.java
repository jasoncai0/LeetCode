package InstanceofTest;

import java.util.HashMap;

/**
 * Created by zhensheng on 2016/5/10.
 */
class A{
    int val ;
}
class B extends A{
    int val2;
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

    public static void main(String []args){
        A a = new A();
        B b= new B();

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




    }

}
