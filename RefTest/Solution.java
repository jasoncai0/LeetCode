package RefTest;

/**
 * Created by zhensheng on 2016/3/3.
 */
public class Solution implements  Cloneable {
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    private int a = 0 ;
    public Solution clone(){
        Solution s = null ;
        try{
            s = (Solution) super.clone();

        }
        catch (CloneNotSupportedException e ){
            e.printStackTrace();
        }
        return s;
    }

    public static void main(String  [] args){
        Solution s = new Solution();
        Solution s2= s.clone();
        s.setA(1);
        s2.setA(3);
        System.out.println(s.getA());
        System.out.println(s2.getA());
    }

}
