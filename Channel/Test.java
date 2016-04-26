package Channel;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhensheng on 2016/3/22.
 */
public class Test {
    public static void main(String args[]) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("test.txt", "rw");
        RandomAccessFile fr = new RandomAccessFile("1.txt","rw");
        FileChannel inChannel2 =  fr.getChannel();
        FileChannel inChannel = aFile.getChannel();

        inChannel.transferTo(0, (long)inChannel2.size(), inChannel2);


        ByteBuffer buf = ByteBuffer.allocate(10);


        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {

            System.out.println("Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = inChannel.read(buf);

        }


        ServerSocketChannel ssc = ServerSocketChannel.open();
        Selector sc = Selector.open();
        ssc.register(sc, SelectionKey.OP_ACCEPT);



        aFile.close();
    }
}
