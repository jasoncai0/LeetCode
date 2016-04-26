package IOTest;

import com.sun.xml.internal.stream.util.BufferAllocator;

import java.io.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Created by zhensheng on 2016/3/17.
 */
public class Solution {
    public static String read(String filename ) throws IOException{
        String str ="中国";
        System.out.println(str.substring(0,1));
        PrintWriter PW= new PrintWriter("1.txt","utf-8");
        PW.write(str);

        PW.close();
        BufferedReader b= new BufferedReader(new InputStreamReader(new FileInputStream("1.txt") ,"utf-8"));
        String myStr= b.readLine();
        b.close();
        System.out.println(myStr);


        BufferedReader br = new BufferedReader(new FileReader(filename));
        String s ;

        StringBuilder sb =new StringBuilder();
        while((s =br.readLine()) != null){
            String word[] = s.split("\\s+");
            for(String w : word){
                sb.append(w+"\n");
            }
            //sb.append(s+ "\n");
        }
        br.close();
        return sb.toString();
    }

    interface roll {
        //Ball ball = new Ball("pingpang");
    }
    class Ball implements roll{
        private String name;
        public Ball(String name){
            this.name= name;
        }

    }


    public static  void main(String args[]) throws IOException {
        final int i = 1 ;

        ConcurrentLinkedQueue re;
        AbstractQueuedSynchronizer aqs ;
        AtomicInteger ai =new AtomicInteger(2);ai.incrementAndGet();


        System.out.println(read("test.txt"));//此处 注意我所在的路径是在工程的路径中年！！！

    }
}
