package netease.choice;
import java.util.*;
/**
 * Created by zhensheng on 2016/9/18.
 */
public class Main {
    public static int getType(int []nums ,int N, int L){
        Map<Integer,Integer> hm =new HashMap<>();
        for(int i= 0 ; i< L; i++){
            if(!hm.containsKey(nums[i])){
                hm.put(nums[i] , i ) ;
            }else {
                int preIndex = hm.get(nums[i]);
                if(i - preIndex < N ){
                    if(i+1 < L && hm.containsKey(nums[i+1]) && hm.get(nums[i+1]) -nums[i+1]<N){
                        return 0 ;//B
                    }
                }
            }
        }
        return 1;//Ccant
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int S = in.nextInt();
            while(S> 0){
                S--;
                int N =  in.nextInt();
                int L = in.nextInt();
                int nums[] = new int[L];

                for (int i = 0; i < L ; i++) {
                    nums[i] = in.nextInt();

                }
                int type = getType(nums, N,  L);
                if(type == 1 ){
                    System.out.println("CAN'T DECIDE");
                }
                else System.out.println("B");
            }
        }
    }
}
