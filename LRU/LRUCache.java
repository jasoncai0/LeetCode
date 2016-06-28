package LRU;

import java.util.*;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhensheng on 2016/1/4.
 */
public class LRUCache {
    public static class Node {
        int key;
        int value ;
        Node next;
        Node pre ;
        public Node(){}

        public Node(int k , int v ){
            this.key= k ;
            this.value= v;
            this.next = null;
            this.pre = null;
        }

    }
    private void addNode(Node node){}
    private void removeNode(Node node){}
    private void moveTOHead(Node node){

    }
    ExecutorService exec= Executors.newCachedThreadPool();

    //Arrays.sort();
    private Node popTail(){
        return null;
    }
    private Node head;
    private Node tail;
    private int count ;
    private int capacity;

    Map<Integer, Node> map;
    public LRUCache(int capacity) {

        map = new HashMap<>();
        head =new Node();
        tail = new Node();
        head.next= tail;
        tail.pre= head ;
        head.pre= null;
        tail.next=null;

    }

    public int get(int key) {
        if(map.containsKey(key )){
            Node n = map.get(key);
            if(n.pre != null ){

            }
            return key;
        }
        else return -1 ;
    }

    public void set(int key, int value) {

    }
    public static void main(String[]args ){
        int a[] = {1,2,3,4,5};

        System.out.println(Arrays.asList(a));
    }
}
