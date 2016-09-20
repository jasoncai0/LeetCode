package netease.ling1chuan3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
// TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n =sc.nextInt();
            for(int i=0; i<n; i++){
                int k = sc.nextInt();
                String str = sc.next();
                int index = 0;
                int max = 0;
                int l1 = 0;
                int len = 0;
                int l0 = 0;
                int before = 0;
                int type = 0;
                while(true){
                    before = l1;
                    l1=0;
                    len=0;
                    l0=0;
                    while(str.charAt(index)=='0'){
                        index++;
                        len++;
                        l0++;
                        if(index>=str.length()){
                            break;
                        }
                    }
                    int j=0;
                    int l=0;
                    for(;j<k;j++){
                        if(index>=str.length()){
                            if(j<=k-1){
                                len = len-k;
                                type = 1;
                            }
                            break;
                        }
                        if(str.charAt(index)=='1'){
                            len++;
                            index++;
                            l1++;
                            l++;
                        }else{
                            break;
                        }
                    }

                    if(l==k){
                        if(index>=str.length()){
                            max = Math.max(max, len);
                            break;
                        }
                        if(str.charAt(index)=='0'){
                            while(str.charAt(index)=='0'){
                                index++;
                                len++;
                                if(index>=str.length()){
                                    len += l1;
                                    break;
                                }
                            }
                        }else{
                            while(str.charAt(index)=='1'){
                                index++;

                                if(index>=str.length()){
                                    break;
                                }
                            }
                        }
                    }
                    if(type==0){
                        len=Math.max(len,l0+before);
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
