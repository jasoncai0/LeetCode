package wangyi.hechangtuan;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by zhensheng on 2016/9/1.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int n = in.nextInt();
            int []nums=  new int[n];
            for (int i = 0; i < n ; i++) {
                nums[i]= in.nextInt();
            }
            int k = in.nextInt();
            int d = in.nextInt();

            int end= n-1 ;
            Arrays.sort(nums);
            int size =1 ;
            int ret =nums[n-1] ;
            for (int i = n-2; i >=0 ; i--) {
                if(nums[i+1] - nums[i] <= d){
                    size ++;
                    ret*=nums[i];
                    if(size == k){
                        System.out.println(ret);
                        break ;
                    }
                }else {
                    end = i;
                    ret = nums[i];
                    size =1 ;
                }

            }
        }


    }
}
