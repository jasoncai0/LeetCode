package baidu;

/**
 * Created by zhensheng on 2016/4/21.
 */
public class ShortestJob {
    public  float waitingTimeSJF(int[] requestTimes, int[] durations)
    {
        // INSERT YOUR CODE HERE
        int len = requestTimes.length;
        boolean finished[] = new boolean[len];
        //int [] starts = new int[len];
        int [] ends = new int[len];
        int index = 0 ;
        int sum= 0 ;
        int next = 0 ;
        int temp = Integer.MAX_VALUE;
        int temp2 = Integer.MAX_VALUE;
        for (int i = 0; i <len ; i++) {
            if(requestTimes[i]< temp){
                temp= requestTimes[i];
                next = i ;
                temp2 = durations[i];

            }
            if(requestTimes[i] == temp){
                if(durations[i] < temp2){
                    temp2= durations[i];
                    next= i ;
                }
            }
        }
        ends[index] = durations[next] + requestTimes[next];
        sum+= requestTimes[next];
        index++;
        //System.out.println(next);
        finished[next] = true;
        while(index < len){
            int min = Integer.MAX_VALUE;
            int nextjob = len;
            for(int i =  0 ; i <len ;i++){
                if(requestTimes[i] <= ends[index-1]){
                    if(finished[i] == false){
                        if(durations[i]< min) {
                            min =durations[i];
                            nextjob = i ;
                        }
                    }
                }
            }
            ends[index] = ends[index-1] + durations[nextjob];
            sum = sum+ (ends[index-1 ] -  requestTimes[nextjob]);

            //System.out.println(nextjob);

            finished[nextjob] = true;
            index++;
        }
        //System.out.println(sum);
        return (float)sum / 4;

    }
    public static void main(String[]args){
        ShortestJob s = new ShortestJob();
        int a[] = {0,1,3,9};
        int b[] = {2,1,7,5};
        System.out.println(s.waitingTimeSJF(a,b));
    }
}
