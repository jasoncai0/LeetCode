package Duotai;

/**
 * Created by zhensheng on 2016/3/23.
 */
public class Solution {
    static interface human{}
    static class man implements human{}
    static class woman implements human{}
    public void sayhello(human guy){
        System.out.println("hello guy");
    }
    public void sayhello(woman woman){
        System.out.println("hello lagy");
    }
    public void sayhello(man guy){
        System.out.println("hello man");
    }

    public static void main(String args[]){
        human man = new man();
        human woman = new woman();
        Solution s = new Solution();
        s.sayhello((man)man);
        s.sayhello(woman);
    }

}
