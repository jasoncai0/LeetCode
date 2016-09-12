package youdao.gouzaoduilie;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by zhensheng on 2016/9/1.
 */
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int T = in.nextInt();
            for (int i = 0; i < T ; i++) {
                int n = in.nextInt();
                Queue<Integer> q = new LinkedList<>();
                for (int j = 0; j < n; j++) {
                    q.offer(j+1);
                }
                while(!q.isEmpty()){
                    int x= q.peek();
                    q.poll();
                    q.offer(x);
                    x= q.peek();
                    System.out.print(x+ "\t");
                    q.poll();
                }
            }

        }
    }
}
