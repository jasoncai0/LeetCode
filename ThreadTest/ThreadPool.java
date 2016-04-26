package ThreadTest;

import com.test.ThreadTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by zhensheng on 2016/3/2.
 */
public class ThreadPool implements Runnable{
    private static volatile double d= 1f;

    public void run(){
        System.out.println("ddd");
        while(true){
            d=d+(Math.PI+ Math.E ) /d ;
            //System.out.println(d);
            Thread.yield();
        }
    }
    public static void main(String args[]){
        Thread t = new Thread(new ThreadPool());
        //t.setDaemon(true);
        t.start();
        Scanner s= new Scanner(System.in);
        d= s.nextDouble();
        System.out.println(d);
        Stack st;
        Queue q= new LinkedList<>();
    }

}
