package com.test;

/**
 * Created by zhensheng on 2016/3/1.
 */
public class ThreadTest extends Thread{
    public static int m_data=0;
    public static int m_times=1000;
    public int m_ID;
    public boolean m_done;

    ThreadTest(int id){
        m_ID=id;
    }

    public void run(){
        m_done=false;
        int d=((m_ID % 2==0) ? 1:-1);
        System.out.println("运行线程:"+m_ID+"(增量为:"+d+")");
        for(int i=0;i<m_times;i++){
            for(int j=0;j<m_times;j++){
                m_data+=1;
            }
        }
        m_done=true;
        System.out.println("线程结束:"+m_ID);
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadTest t1=new ThreadTest(1);
        ThreadTest t2=new ThreadTest(2);
        t1.m_done=false;
        t2.m_done=false;
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("结果: m_data="+m_data+"");
    }
}
