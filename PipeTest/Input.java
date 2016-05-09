package PipeTest;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Created by zhensheng on 2016/5/9.
 */
public class Input {

    public static void main(String[] args)  {
        Sender  s = new Sender();
        Receiver r =new Receiver();
        PipedInputStream in = r.getPipedInputStream();
        PipedOutputStream out = s.getPipedOutputStream();

        try {
            in.connect(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(s).start();
        new Thread(r).start();

    }




}
class Sender implements Runnable{

    PipedOutputStream out = null ;
    public PipedOutputStream getPipedOutputStream(){
        out = new PipedOutputStream();
        return out;
    }

    @Override
    public void run() {
        try{
            out.write("hello pipe".getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


class Receiver implements Runnable{

    PipedInputStream in = null;
    public PipedInputStream getPipedInputStream(){
        in= new PipedInputStream();
        return in;
    }
    @Override
    public void run() {
        byte[] bytes= new byte[1024];
        try{

            in.read(bytes);
            System.out.println(new String(bytes));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}