package DataStreamasDisjointIntervals;

/**
 * Created by zhensheng on 2016/6/2.
 */



import javax.transaction.TransactionRequiredException;
import java.util.*;


// Definition for an interval.
class Interval {
  int start;
  int end;
  Interval() { start = 0; end = 0; }
  Interval(int s, int e) { start = s; end = e; }
}



class IntervalComparator implements Comparator<Interval>{

    @Override
    public int compare(Interval o1, Interval o2) {
        return o1.start- o2.start;
    }
}
public class SummaryRanges {

    /** Initialize your data structure here. */
    List<Interval> intervals;
    public SummaryRanges() {
        intervals = new ArrayList<>();

    }

    public void addNum(int val) {
        int lo = 0 ;
        int hi = intervals.size()-1;
        int mid ;
        while(lo <= hi ){
            mid = (lo+ hi )/2 ;
            if(val < intervals.get(mid).start) {
                if(val == intervals.get(mid).start -1 ){
                    if(mid -1 < 0 ) {
                        intervals.get(mid).start = val ;
                        return ;
                    }else if(intervals.get(mid-1).end < val-1) {
                        intervals.get(mid).start = val ;
                        return ;
                    }else {
                        int intvstart = intervals.get(mid-1) .start;
                        int intvend = intervals.get(mid).end;
                        intervals.remove(mid);
                        intervals.remove(mid-1);
                        intervals.add(mid-1 , new Interval(intvstart, intvend));
                        return ;
                    }
                }
                else {
                    hi= mid-1;
                }

            }else if(val > intervals.get(mid).end){
                if(val == intervals.get(mid).end + 1 ){
                    if(mid+1>= intervals.size()){
                        intervals.get(mid).end = val;
                        return ;

                    }
                    else if(intervals.get(mid+1).start > val+1 ){
                        intervals.get(mid).end = val;
                        return ;
                    }
                    else {
                        int intvstart = intervals.get(mid).start;
                        int intvend= intervals.get(mid+1).end;
                        intervals.remove(mid+1);
                        intervals.remove(mid);
                        intervals.add(mid, new Interval(intvstart,intvend));
                        return ;
                    }
                }
                else {
                    lo = mid+1;
                }

            }
            else {
                return ;
            }
        }
        intervals.add(lo,new Interval(val,val));
    }

    public List<Interval> getIntervals() {
        return intervals;
    }
}

/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * List<Interval> param_2 = obj.getIntervals();
 */