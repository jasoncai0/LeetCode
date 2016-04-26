/**
 * Created by zhensheng on 2016/4/1.
 */
public class BinDecimal {
    public String printBin(double num) {
        // write code here
        StringBuilder sb = new StringBuilder();
        sb.append("0.");
        for (int i = 0; i < 30 ; i++) {
            if(num<= 0 ) break;
            num *=2 ;
            sb.append((int)(num));
            num= num >=1? num -1 : num;

        }
        if(num != 0 ) return "Error";
        else return sb.toString();
    }
    public static void main(String []args){
        BinDecimal s= new BinDecimal();
        System.out.println(s.printBin(0.625));
    }
}
