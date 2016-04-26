package ThreadTest;


import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhensheng on 2016/3/5.
 */

class Meal{
    private final int orderNum;
    public Meal(int orderNum ){
        this.orderNum= orderNum;

    }
    public String toString(){
        return "Meal" +  orderNum;
    }
}
class Waiter implements Runnable{
    private  Restaurant restaurant;
    public Waiter(Restaurant r){
        this.restaurant =r ;

    }
    public void run() {
        try{
            while(!Thread.interrupted()){
                synchronized (this){
                while(restaurant.meal == null ) {
                    wait();
                }}
                System.out.println("开始送"+ restaurant.meal);
                synchronized (restaurant.chef){
                    restaurant.meal = null ;
                    restaurant.chef.notifyAll();
                }
            }
        }
        catch (InterruptedException e ){
            System.out.println(e);
        }
    }
}

class Chef implements Runnable{
    private Restaurant restaurant;
    private  int count = 0 ;
    public Chef(Restaurant r ){
        this.restaurant = r;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                synchronized (this){
                while(restaurant.meal!=null){
                    wait();
                }}
                if(++count == 10 ) {
                    System.out.println("meile");
                    restaurant.exec.shutdownNow();
                }
                System.out.println("开始做");

                synchronized (restaurant.waiter){
                    restaurant.meal = new Meal(count );
                    restaurant.waiter.notifyAll();
                }
                TimeUnit.MILLISECONDS.sleep(100);
            }
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
    }

}

public class Restaurant {
    Meal meal ;
    Waiter waiter = new Waiter(this);
    Chef chef= new Chef(this);
    public ExecutorService exec = Executors.newCachedThreadPool();
    public Restaurant() throws InterruptedException {
        exec.execute(chef);
        exec.execute(waiter);


    }

    public static void main(String[] args) throws InterruptedException {
        Restaurant r= new Restaurant();

    }




}
