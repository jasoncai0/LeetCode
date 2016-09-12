package Alibaba.Arbergo;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by zhensheng on 2016/9/9.
 */

public interface IArbergo {
    /**
     * @param filePath 表示文件的路径，其中filePath是可变长参数，可以传入1-n个文件路径，
     *                 在这里文件路径可以为ClassPath文件路径也可以是SystemFile路径，根据接口实现方案决定
     * @return 文件返回文件的列表，列表中存放分片的文件内容，其中ArbergoFile为分片后的文件存储类型，该文件类型具有相对固定的长度大小。
     * @throws ArbergoFileNotFoundException 当文件不存在时，抛出该异常
     */
    //List<OriginFile> downLoad(String ... filePath) throws ArbergoFileNotFoundException;

    /**
     *
     * @param filePath  该参数表示文件路径名，这里文件路径名暂不支持可变长参数，也即不能同时下载多个文件并支持部分下载
     * @param beginIndex 表示下载文件的开始行数，0为最开始的一行
     * @param endIndex 表示下载文件的结束行数，不包括endIndex，当endIndex>= 文件行数时，下载到文件结束
     * @return 返回文件分片的列表
     * @throws ArbergoFileNotFoundException 当文件不存在时抛出该异常
     * @throws FileBeginIndexOutOfBoundsException 当文件开始行数超过文件长度时，抛出该异常
     */
    //List<OriginFile> downLoad(String  filePath, int beginIndex, int endIndex) throws ArbergoFileNotFoundException ,FileBeginIndexOutOfBoundsException;

    /**
     * TODO:
     * 设计思路为，当文件被频繁的被用户下载时，我们应该选择将文件迁移到SSD中，能够方便用户更快的进行下载，这个时候我们应该对文件的
     */
    static final PriorityQueue<OriginFile> popularityHeap = new PriorityQueue<>() ;

    /**
     * 将文件迁移到SSD中
     * @param filePath
     * @return
     * @throws ArbergoFileNotFoundException
     * @throws MoveFailException 移动文件失败异常
     */
   // boolean moveToSSD(String filePath) throws ArbergoFileNotFoundException, MoveFailException;

    /**
     * 将文件迁移到hardware中
     * @param filePath
     * @return
     * @throws ArbergoFileNotFoundException
     * @throws MoveFailException
     */
   // boolean moveToHardWare(String filePath) throws ArbergoFileNotFoundException, MoveFailException;


}
