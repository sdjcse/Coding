import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sdj on 21/8/16.
 *
 * https://www.hackerearth.com/august-circuits/algorithm/killing-assistants/
 */
public class ZombieKiller {
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        int t = 0;
        t = input.nextInt();
        List<Integer> numerator = new ArrayList<>();
        List<Integer> denominator = new ArrayList<>();
        int m=0,n=0,gcd=0;
        while(t>0){
            n = input.nextInt();
            m = input.nextInt();
            n = m+(8*n);
            m = 9*m;
            gcd = new ZombieKiller().findGCD(m,n);
            numerator.add(m/gcd);
            denominator.add(n/gcd);
            t--;
        }

        for(int i=0;i<numerator.size();i++){
            System.out.println(numerator.get(i) + "/" + denominator.get(i));
        }
    }

    public int findGCD(int a,int b){
        int c = 0;
        while(a!=0 && b!=0) // until either one of them is 0
        {
            c = b;
            b = a%b;
            a = c;
        }
        return a+b;
    }
}

