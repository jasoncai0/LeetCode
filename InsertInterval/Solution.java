package InsertInterval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhensheng on 2016/1/13.
 */
public class Solution {
    public class Interval {
            int start;
            int end;
             Interval() { start = 0; end = 0; }
             Interval(int s, int e) { start = s; end = e; }
     }
    class IntervalComparator implements Comparator<Interval> {

        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start- o2.start;
        }
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> ret= new ArrayList<>();
        Collections.sort(intervals, new IntervalComparator());
        int len = intervals.size();
        int start = newInterval.start;
        int end = newInterval.end;
        boolean flag =true ;
        for(Interval intv  : intervals){
            if(flag ){
                if(start > intv.end) {

                    ret.add(intv);
                }
                else {
                    if(end <intv.start) {
                        ret.add(new Interval(start, end ));
                        ret.add(intv);
                        flag =false;
                    }
                    else {
                        start = Math.min(intv.start, start);
                        end = Math.max(intv.end, end);
                    }
                }
            }
            else ret.add(intv);
        }
        if(flag) ret.add(new Interval(start,end));
        return ret;
    }
    public static void main(String[] args){
        Solution s = new Solution();

    }
}
