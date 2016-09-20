package didi.dixiamigong;


import java.util.*;

/**
 * Created by zhensheng on 2016/9/18.
 */
public class Main {

    static int m ;
    static int n ;

    static class Pair{
        int x;
        int y ;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }


    }
    static class Path{
        List<Pair> pairs ;
        int p;

        public Path(List<Pair> pairs, int p) {
            this.pairs = new LinkedList<>(pairs);
            this.p = p;
        }

        public Path() {
            pairs = new ArrayList<>() ;
            p= 0 ;
        }
    }
    public static void print(Path path){
        List<Pair> ret = path.pairs;
        boolean first = true;
        for (Pair p : ret){
            if(first){
                System.out.print("["+p.x+","+p.y+"]");
                first =false;
            }
            else
                System.out.print(",["+p.x+","+p.y+"]");

        }
    }
    public static void   dfs(int [][]dg  , boolean[][] visited , int x, int y , int p ,ArrayList<Pair> ret , ArrayList<Path> res ){
        if(x<0 || x>=n || y < 0|| y>= m) return;

        //List<Pair> ret = path.pairs;
        int size = ret.size();
        ret.add(new Pair(x,y));
        try{
            if(visited[x][y]) return ;
            visited[x][y] =true;
            if(dg[x][y]== 0) {
                return ;
            }
            if(p< 0 ) return ;



            if(p== 0 ){
                if(x==0 && y ==m-1) {
                    //path.p= p;
                    res.add(new Path(ret,p));
                    return;
                }
                else return ;
            }
            if(x== 0 && y== m-1 ) {

                res.add(new Path(ret, p ));
                return ;
            }



            dfs(dg,visited, x+1, y ,p-1 , ret, res );

            dfs(dg,visited,x,y-1 , p-3 , ret,res );

            dfs(dg,visited,x,y+1 , p , ret,res ) ;

            dfs(dg,visited,x-1,y , p-1 ,ret,res ) ;
        }finally {
            ret.remove(size);
            if(x<0 || x>=n || y < 0|| y>= m);
            else{
                visited[x][y]= false;
            }
        }

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {//注意while处理多个case
            n = in.nextInt();
            m = in.nextInt();
            int P = in.nextInt();
            int dg [][] = new int[n][m] ;
            ArrayList<Path> res  = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <m ; j++) {
                    dg[i][j] = in.nextInt();
                }
            }
            boolean [][]visited = new boolean[n][m];

            dfs(dg,visited,0,0,P,new ArrayList<>() ,res);

            int index= 0 ;
            int max = 0 ;
            for (int i = 0; i < res.size(); i++) {
                // print(res.get(i));
                if(res.get(i).p >max ){
                    max = res.get(i).p;
                    index = i ;
                }
            }
            print(res.get(index));
        }
    }
}

