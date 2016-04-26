package MergeIntervals;

import java.util.*;

/**
 * Created by zhensheng on 2016/1/12.
 */
public class Solution {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    class IntervalComparator implements Comparator<Interval>{

        @Override
        public int compare(Interval i1 , Interval i2 ){
            return i1.start - i2.start;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        int len = intervals.size();
        List<Interval> ret = new ArrayList<>();
        Collections.sort(intervals, new IntervalComparator());
        if (len == 0 ) return ret;

        int start = intervals.get(0).start;
        int end = intervals.get(0).start;

        for(Interval intv : intervals){
            if(intv.start >end ){
                ret.add(new Interval(start,end));
                start = intv.start;
                end = intv.end;
            }
            else {
                end=Math.max(end, intv.end);
            }
        }
        ret.add(new Interval(start,end));
        return ret;
    }
    public void mergeIntervals(List<Interval> intervals, Interval inter){

    }
}
