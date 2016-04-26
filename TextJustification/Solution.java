package TextJustification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhensheng on 2016/1/17.
 */
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int [] len = new int[words.length];
        for(int i = 0 ; i< words.length; i++ ){
            len[i] = words[i].length();
        }
        List<String> ret = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int start = 0;
        int count = 0 ;
        for(int i =0 ; i< words.length ;i++ ){
            count += len[i] ;
            if(count + i - start <= maxWidth) {

            }
            else{
                count  -= len[i];
                int num = i-start ;
                int c,r ;
                //a/b=c ...r
                if(num> 1 ){
                    c = (maxWidth- count)/(num-1);
                    r = (maxWidth-count )% (num-1) ;
                }
                else {
                    c = (maxWidth - count) / (num );
                    r = (maxWidth - count) % (num );
                }
                int temp = 0 ;
                for(int j  =  start ; j < start + r   ; j++   ){
                    sb.append(words[j]);
                    temp+= len[j];
                    if(temp< maxWidth){
                        for(int k = 0 ; k < c+1 ; k++) {
                            sb.append(' ');
                        }
                        temp+= (c+1);
                    }
                }
                for(int j = start + r ; j < i ; j++ ){
                    sb.append(words[j]);
                    temp+= len[j];
                    if(temp< maxWidth){
                        for(int k = 0 ; k < c ; k++) {
                            sb.append(' ');
                        }
                        temp+= c;
                    }

                }
                ret.add(sb.toString());
                sb= new StringBuilder();
                count = len[i];
                start = i ;
            }
        }
        int num = words.length-start ;
        int c,r ;
        //a/b=c ...r
        int temp = 0 ;
        for(int i = start ; i< words.length; i++){
            sb.append(words[i]);
            temp+= len[i];
            if(temp<maxWidth){
            sb.append(' ');
            temp+= 1 ;}
        }
        while(temp< maxWidth){
            sb.append(' ');
            temp++;
        }
        ret.add(sb.toString());

        return ret;

    }
    public static void main(String[] args){

        Solution s =new Solution();
        String []a = {""};
        //int ret= s.InversePairs(array);
        System.out.println(s.fullJustify(a,0));

    }
}
