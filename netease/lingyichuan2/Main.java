package netease.lingyichuan2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            for(int i=0; i<n; i++){
                int k = sc.nextInt();
                String str = sc.next();
                int index = 0;
                int max = 0;
                int before = 0;
                int len = 0;
                int type = 0;
                while(true){
                    before = 0;
                    len=0;
                    while(str.charAt(index)=='0'){
                        index++;
                        len++;
                        if(index>=str.length()){
                            break;
                        }
                    }
                    int j=0;
                    for(;j<k;j++){
                        if(index>=str.length()){
                            if(j<=k-1){
                                len = len-k;
                            }
                            break;
                        }
                        if(str.charAt(index)=='1'){
                            len++;
                            index++;
                            before++;
                        }else{
                            break;
                        }
                    }

                    if(j==k){
                        if(index>=str.length()){
                            max = Math.max(max, len);
                            break;
                        }
                        if(str.charAt(index)=='0'){
                            type = 0;
                            while(str.charAt(index)=='0'){
                                index++;
                                len++;
                                if(index>=str.length()){
                                    len += before;
                                    break;
                                }
                            }
                        }else{
                            type = 1;
                            while(str.charAt(index)=='1'){
                                index++;

                                if(index>=str.length()){
                                    break;
                                }
                            }
                        }
                    }else{
                        if(type==1){
                            len=len-j+k;
                        }
                    }

                    max = Math.max(max, len);
                    if(index>=str.length()){
                        break;
                    }
                }
                System.out.println(max);
            }
        }

        sc.close();
    }

}