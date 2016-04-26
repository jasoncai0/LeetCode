package Replacement;

/**
 * Created by zhensheng on 2016/3/30.
 */
public class Replacement {
    public String replaceSpace(String iniString, int length) {
    // write code here
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iniString.length(); i++) {
            if(iniString.charAt(i) == ' '){
                sb.append("%20");
            }
            else sb.append(iniString.charAt(i));
        }
        return sb.toString();
    }
}
