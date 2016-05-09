package PipeTest;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * Created by zhensheng on 2016/5/9.
 */
public class Input2 {
    public static void main(String args[]){
        try {
            Pipe  pipe = Pipe.open();
            Pipe.SinkChannel sinkChannel = pipe.sink();
            String data ="hello channel";
            ByteBuffer bf = ByteBuffer.allocate(1024);
            bf.clear();
            bf.put(data.getBytes());
            bf.flip();
            while(bf.hasRemaining()){
                sinkChannel.write(bf);
            }


            Pipe.SourceChannel sourceChannel= pipe.source();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            int bytesRead = sourceChannel.read(buf);
            System.out.println(bytesRead);





        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
