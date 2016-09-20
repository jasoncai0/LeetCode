package netease.heibaiqi;

import java.util.*;
/**
 * Created by zhensheng on 2016/9/18.
 */
public class Main {
    static int size = 8 ;

    static int dx[] ={ -1,1,0,0,-1,1,1,-1};
    static int dy[] = { 0,0,-1,1,-1,-1,1,1} ;

    public static void fan(char[][] t, int x, int y  ){


        //int curx = x ;
        char curType = t[x][y] ;
        //System.out.println("curType"+curType);
        for(int i= 0 ; i < 8 ; i++){
            int curx = x+ dx[i];
            int cury = y+dy[i];
            boolean chi = false;
            while(curx>=0&& curx<size && cury>=0 && cury<size ){
                if(t[curx][cury] =='.') break;
                if(t[curx][cury]== curType){
                    chi = true;
                    break;
                }

                curx += dx[i];
                cury+= dy[i];
            }
            if(chi){

                System.out.println("set from  "+ curx +','+ cury +"to " + x+','+ y);
                int tempx = x+dx[i];
                int tempy = y + dy[i];
                System.out.println("set temp "+ tempx +','+ tempy);
                while( tempx>=0 &&tempx < size &&( tempx != curx|| tempy !=cury)  ){
                    System.out.println("set "+ tempx +','+ tempy);
                    t[tempx][tempy] = curType;
                    tempx += dx[i];
                    tempy += dy[i];


                }
                /*
                while( curx!= x ){
                    t[curx][cury]= curType;
                    curx -= dx[i];
                    cury -=dy[i];
                }*/
            }

        }

    }

    public static void put(char[][] t , int x, int y , int type ){
        if(x<0 || x>=size|| y<0 || y>=size  ) return;
        if(t[x][y] !='.') return ;


        if(type == 0 ){
            t[x][y] = '*';
            //右
            fan(t,x,y);
            //下
            //左上
            //左下
            //右上
            //右下
        }else {
            t[x][y] = 'o';
            fan(t,x,y);
        }

    }

    public static void print (char[][] t ){
        for (int i = 0; i <size  ; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print( t[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------");
    }
    public static void getRes(char[][] t, int []res){
        for (int i = 0; i <size  ; i++) {
            for (int j = 0; j < size; j++) {
                if(t[i][j] =='o')res[1]++;
                else if(t[i][j]=='*') res[0]++;

            }

        }

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()){
            int S = in.nextInt();
            while(S>0){
                S--;
                char [][] t = new char[size][size] ;
                for(int i= 0 ; i < size ; i++ ){
                    String str= in.next();
                    char[] chs = str.toCharArray();
                    for (int j = 0; j < size; j++) {
                        t[i][j] = chs[j];
                    }
                }
                int N = in.nextInt();
                for (int i = 0; i < N ; i++) {
                    int x = in.nextInt();
                    int y = in.nextInt();
                    int type= in.nextInt();
                    put(t, x,y , type );
                    print(t);
                }
                //print(t);
                int res[]= new int [2] ;
                res[0]= 0 ;
                res[1]= 0;
                getRes(t,res);
                System.out.println(res[0] + " "+ res[1]);
            }
        }
    }
}
