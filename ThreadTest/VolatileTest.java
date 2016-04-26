package ThreadTest;

import java.nio.channels.Selector;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhensheng on 2016/3/21.
 */
public class VolatileTest {
    public static int count = 0;
    public static int count2 = 0;
    public static AtomicInteger count3 = new AtomicInteger(0);
    public static volatile int vCount =0 ;
    public static volatile int vCount2 =0 ;
    public static Lock l = new ReentrantLock();
    public static void inc(){

        try{
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        count ++;
        vCount++;
        inc2();
        Object o = null;

    }

    public static void inc4(){
        try{
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        /*
        for(;;){

            if(count3.compareAndSet( count3.get(), count3.get()+1  )) {
                return;
            }
        }*/
        count3.incrementAndGet();

    }
    public static void inc3(){
        try{
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        l.lock();
        try {
            count2++;
        }finally {
            l.unlock();
        }
    }
    public static synchronized void inc2(){
        vCount2++;
    }

    public static void main(String args[]) throws InterruptedException {
        for(int i = 0 ; i < 1000 ; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    VolatileTest.inc();
                    System.out.println(String.valueOf(VolatileTest.count)+" "+ VolatileTest.vCount+ " " + VolatileTest.vCount2+ " "+ VolatileTest.count2);
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    VolatileTest.inc3();
                    System.out.println("count2 by lock : " + VolatileTest.count2);
                }
            }).start();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    VolatileTest.inc4();
                    System.out.println("count3 by Atomic : " + VolatileTest.count3);
                }
            }).start();

        }

        Selector s;
        Scanner scanner = new Scanner(System.in);
        String str= scanner.nextLine();
        Thread.sleep(1000);
        System.out.println("Output: "+VolatileTest.count+" " + VolatileTest.vCount+ " "+ VolatileTest.vCount2+" "+ VolatileTest.count2+" "+VolatileTest.count3) ;
    }
}
