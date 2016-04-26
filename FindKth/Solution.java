package FindKth;

/**
 * Created by zhensheng on 2016/3/23.
 */
//di K xiaode shu
public class Solution {
    public static int sort(int a[] , int begin, int end , int k ){
        int i = begin, j = end;
        int temp = a[i];
        while(i< j){
            while(j>i && a[j]>= temp ){
                j--;
            }
            if(j> i) a[i++]= a[j];
            while(j>i && a[i] < temp ){
                i++;
            }
            if(j> i ) a[j--] = a[i];
        }
        a[i] =temp;
        if(i== k-1 ) return a[i];
        else if(i >= k)return sort(a , begin, i-1 , k);
        else return sort(a , i+1 , end , k );


    }
    public static void main(String []args){
        int a[]= {1,2,3,4,5,65,6,7,7845,33};
        System.out.println(sort(a, 0 , a.length-1 ,10) );

    }
}
