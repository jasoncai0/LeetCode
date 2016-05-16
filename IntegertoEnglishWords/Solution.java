package IntegertoEnglishWords;

import java.util.TreeMap;

/**
 * Created by zhensheng on 2015/12/29.
 */
public class Solution {
    public String numberToWords(int num) {
        //TreeMap
        String []ones = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        String []thousands ={"Thousand","Million","Billion"};
        String hundred = "Hundred";
        String []ten ={"Ten","Eleven","Twelve","Thirteen,","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String []tens={"Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        StringBuilder ret = new StringBuilder();
        int cur = num;
        int index= 0 ;


        while(cur!= 0 ){





            cur = cur/1000;
            if(cur!=0){

            }
            index++;
        }
        return null;
    }
}
