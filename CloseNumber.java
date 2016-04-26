/**
 * Created by zhensheng on 2016/4/1.
 */
public class CloseNumber {
    /*
    public int[] getCloseNumber(int x) {
        // write code here

        int  n = x ;
        int base =1;
        int ret [] = new int [2];
        if(x== 1){
            ret[0] =2 ;
            ret[1] =4;
            return ret;
        }
        while(x>0){
            if((x & 1 )== 1 ) {
                ret[1] = n + base ;
            }else {
                ret[0]=n -base;
            }
            base = base<<1 ;
            x=x>>1;
            if(ret[0]!= 0 && ret[1]!=0) break;
        }
        return ret;
    }*/
    /*
    76351

    对应输出应该为:

            [76284,76383]*/
    public int[] getCloseNumber(int x) {
        // write code here
        int  n = x ;
        int base =1;
        int ret [] = new int [2];
        if(x== 1){
            ret[0] =2 ;
            ret[1] =4;
            return ret;
        }

        while(x>0){
            int temp =x >>1;
            if((x & 1 )== 1) {
                if((temp&1) !=1)
                ret[1] = n + base ;
            } else {
                if((temp&1)!=0)
                ret[0]=n -base;
            }
            base = base<<1 ;
            x=temp;
            if(ret[0]!= 0 && ret[1]!=0) break;
        }
        return ret;
    }
    public static void main(String args[]){
        CloseNumber s= new CloseNumber();

        int a []=s.getCloseNumber(76351);
        for(int b:a )System.out.println(b);
    }
}
