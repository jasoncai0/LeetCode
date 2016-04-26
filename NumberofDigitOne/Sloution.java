package NumberofDigitOne;

/**
 * Created by zhensheng on 2016/3/28.
 */
public class Sloution {

    /*
    public int countDigitOne(int n) {
        int len = (int) (Math.log10(n));
        int base = (int) Math.pow(10,len);
        return (int)countDigitOne(n,n,base);
    }
    public long countDigitOne(int n ,int r, int base ){
        long count = 0 ;
        if (base == 0 ) return 0;
        int a= (int) ((long)n/((long)(base *10) ));
        int b = r /base ;
        r = r %base ;
        if(b ==1 ) {
            count =count +  (r+1);
            count += (a)* (base  );
        }
        else if(b>1 ){
            count = (a+1) *(base) ;
        }
        else if(b==0 ){
            count += a*base ;
        }
        count = count +countDigitOne(n, r,  base /10 );
        return count ;

    }
*/

    /**
     * (1) xyz * 1000                     if d == 0
     (2) xyz * 1000 + abc + 1           if d == 1
     (3) xyz * 1000 + 1000              if d > 1
     * @param n
     * @return
     */

    public int countDigitOne(int n) {

        if (n <= 0) return 0;
        int q = n, x = 1, ans = 0;
        do {
            int digit = q % 10;
            q /= 10;
            ans += q * x;
            if (digit == 1) ans += n % x + 1;
            if (digit >  1) ans += x;
            x *= 10;
        } while (q > 0);
        return ans;
    }
    public static void main(String args[]){
        Sloution s = new Sloution();
        System.out.print(s.countDigitOne(1410065408));
    }
}
