package PipeTest;


import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * Created by zhensheng on 2016/5/9.
 */
public class ProcessIn implements Runnable{
    private String mFileName;
    private FileChannel mFileChannel;
    private MappedByteBuffer mMappedByteBuffer;

    public ProcessIn(String fn)
    {
        try
        {
            mFileName=fn;

            // 获得一个可读写的随机存取文件对象
            RandomAccessFile RAFile=new RandomAccessFile(mFileName,"rw");

            // 获得相应的文件通道
            mFileChannel=RAFile.getChannel();

            // 取得文件的实际大小，以便映像到共享内存
            int size=(int)mFileChannel.size();

            // 获得共享内存缓冲区，该共享内存可读
            mMappedByteBuffer=mFileChannel.map(FileChannel.MapMode.READ_WRITE,0,size).load();
        }
        catch(IOException ex)
        {
            System.out.println(ex);
        }
    }

    public void run()
    {
        int i=0;
        while(true)
        {
            try
            {
                FileLock lock=null;
                lock=mFileChannel.tryLock();
                if(lock==null)
                {
                    System.err.println("Producer: lock failed");
                    continue;
                }
                mMappedByteBuffer.putInt(0,++i);
                mMappedByteBuffer.putInt(4,++i);
                mMappedByteBuffer.putInt(8,++i);
                System.out.println("Producer: "+(i-3)+":"+(i-2)+":"+(i-1));
                //System.out.println("Producer: "+i);
                Thread.sleep(200);
                lock.release();
                Thread.sleep(500);
            }
            catch(IOException ex)
            {
                System.out.print(ex);
            }
            catch(InterruptedException ex)
            {
                System.out.print(ex);
            }
        }

    }

    public static void main(String args[])
    {
        ProcessIn producer=new ProcessIn("pipe.txt");
        new Thread(producer).start();
    }
}
