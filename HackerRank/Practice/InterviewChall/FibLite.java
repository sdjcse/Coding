import java.util.Scanner;

/**
 * Created by sdj on 9/9/16.
 */
public class FibLite {
    public long fibFinder(long a,long b,long n){
        long c=0;
        c = a+b;
        if(n==0){
            return 0;
        }
        if(n==2 || n==1){
            return c;
        }
        a=b;
        b=c;
        n--;
        return fibFinder(a,b,n);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(new FibLite().fibFinder(0,1,input.nextLong()));
    }
}
