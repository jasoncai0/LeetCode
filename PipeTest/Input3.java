package PipeTest;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Pipe;

/**
 * Created by zhensheng on 2016/5/9.
 */
public class Input3 {
    public static void main(String args[]){
        try {
            Pipe pipe = Pipe.open();
            Sender3 s = new Sender3(pipe.sink());
            Receiver3 r= new Receiver3(pipe.source());
            new Thread(s).start();
            new Thread(r).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Sender3 implements  Runnable{
    Pipe.SinkChannel channel = null;
    public Sender3(Pipe.SinkChannel cl){
        this.channel=cl;
    }

    @Override
    public void run() {
        String data ="hello channel";
        ByteBuffer bf = ByteBuffer.allocate(1024);
        bf.clear();
        bf.put(data.getBytes());
        bf.flip();
        while(bf.hasRemaining()){
            try {
                this.channel.write(bf);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

class Receiver3 implements Runnable{
    Pipe.SourceChannel channel = null;
    public Receiver3(Pipe.SourceChannel cl){
        this.channel = cl;
    }

    @Override
    public void run() {
        ByteBuffer buf = ByteBuffer.allocate(1024);
        int bytesRead = 0;
        try {
            bytesRead = this.channel.read(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(bytesRead);
    }
}

