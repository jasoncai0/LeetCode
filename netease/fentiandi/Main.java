package netease.fentiandi;

import java.util.Scanner;

/**
 * Created by zhensheng on 2016/8/2.
 */
public class Main {
    public static int fentiandi(int[][] field) {
        int N = field.length;
        int M = field[0].length;
        int max = 0 ;
        int is[]= new int[5];
        int js[]= new int[5];
        is[4]= N-1;
        js[4]= M-1;
        for ( is[1] = 0; is[1] < N  ; is[1]++) {
            for (is[2] = is[1]+1; is[2] < N ; is[2]++) {
                for(is[3]=is[2]+1; is[1]< N ; is[3]++){
                    for (js[1] = 0; js[1] < M  ;js[1]++) {
                        for ( js[2] = js[1]+1; js[2] < M ;js[2]++) {
                            for(js[3]=js[2]+1; js[3]< M; js[3]++){

                                int min= Integer.MAX_VALUE;
                                for (int i = 0; i <4 ; i++) {
                                    for (int j = 0; j <4 ; j++) {
                                        int sumblock =0 ;
                                        for (int k = is[i]; k <is[i+1] ; k++) {
                                            for (int l =js[j]; l <js[j+1] ; l++) {
                                                sumblock+= field[k][l];
                                            }
                                        }
                                        if(sumblock< min){
                                            min=sumblock;
                                        }
                                    }

                                }
                                if(min> max){
                                    max= min;
                                }

                            }
                        }
                    }
                }
            }
        }
        return max;
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        while(in.hasNext()){
            int N = in.nextInt();
            int M = in.nextInt();
            int[][] field = new int[N][M];
            int sum = 0 ;
            for (int i = 0; i < N ; i++) {
                for (int j = 0; j < M ; j++) {
                    field[i][j] = in.nextInt();
                    sum+= field[i][j];
                }

            }
            int ret= fentiandi(field);
            System.out.println(ret);

        }
    }
}
