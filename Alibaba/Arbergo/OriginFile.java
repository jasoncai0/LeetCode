package Alibaba.Arbergo;

/**
 * Created by zhensheng on 2016/9/9.
 */
public class OriginFile {
    /**
     * 文件数据
     */
    //Data data;
    /**
     * 计数器，计数器计数大小反应文件的热门程度。
     * 计数器，当文件每被下载一次，计数器计数，当文件的计数次数大于最小堆中文件热度最小的计数器值时，此文件被认为是热门文件，此时将文件迁移到SSD中方便用户的下载，
     * 同时将文件存放到堆中，将原本热度最小的文件移除堆
     * 这里我们需要对文件的热门程度进行维护，我们可以维护一个最小堆popularityHeap<OriginFile></>，该对按couter值从小到大构建， 该堆的大小决定于SSD的大小，
     * popularityHeap中的文件被存放在SSD中，移除堆的文件被存放在磁盘中
     */
    int couter;


}
