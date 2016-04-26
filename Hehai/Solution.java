package Hehai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhensheng on 2015/12/23.
 */
public class Solution {


    public static void main(String[] args){
        List<List<Integer >> coord = new ArrayList<List<Integer>>();
        for(int i = 0 ; i<12 ; i++){
            Integer[] a = {388,9,394,4,399,5,401,12,407,15,416,20,425,26,425,33,432,34,433,41,443,47,451,51,457,55,456,62,456,70,453,77,453,82,447,85,440,93,439,99,443,106,437,107,429,107,426,108,422,108,420,113,414,115,407,116,398,114,394,115,385,120,377,118,367,114,363,113,357,112,353,113,346,115,336,118,330,115,320,112,309,106,300,101,290,102,280,104,272,102,259,100,253,91,251,84,260,77,273,75,286,75,294,68,299,64,305,57,304,54,313,56,325,56,337,51,348,47,353,40,361,35,374,31,377,20,380,15,380,11,380,4};

            List<Integer> li = Arrays.asList(a);
            coord.add(li);
        }
        for(int i = 0 ; i<coord.size() ; i++) {
            for(Integer a : coord.get(i))
                System.out.println(a);
        }

    }
}
