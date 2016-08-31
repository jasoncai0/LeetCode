package MaximumProductofWordLengths;

/**
 * Created by zhensheng on 2016/8/27.
 */
public class Solution {
    public int maxProduct(String[] words) {
        int value[] = new int[words.length];
        for (int i = 0; i <words.length ; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                value[i] |=1<<( words[i].charAt(j)-'a');
            }
        }
        int max= 0 ;
        for (int i = 0; i < words.length ; i++) {
            for (int j = i+1 ; j < words.length; j++) {
                if((value[i] & value[j]) == 0 &&  words[i].length() * words[j].length() > max){
                    max= words[i].length()* words[j].length();
                }
            }
        }
        return max;

    }

    public static void main(String[] args) {
        Solution s= new Solution();
        String words[] ={"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(s.maxProduct(words));
    }
}
