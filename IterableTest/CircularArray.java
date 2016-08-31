package IterableTest;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Created by zhensheng on 2016/8/30.
 */
public class CircularArray<T> implements Iterable<T> {
    private T[] items;
    private int head;

    @Override
    public Iterator<T> iterator() {
        return new CircularArrayIterator<>();
    }
    private class CircularArrayIterator<T> implements Iterator<T>{
        private int current = -1 ;

        @Override
        public boolean hasNext() {
            return current> items.length-1 ;
        }

        @Override
        public T next() {
            current++;

            return (T) items[current];
        }

        @Override
        public void remove() {
            try {
                throw new Exception("xxx");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
