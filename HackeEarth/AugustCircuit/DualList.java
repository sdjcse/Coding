import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by sdj on 20/8/16.
 * https://www.hackerearth.com/august-circuits/algorithm/dual-issues/
 */
public class DualList {
    boolean isPrime(long n){
        if(n==1){
            return false;
        }
        for(long i=2;i<=Math.sqrt(n);i++){
            if(n%i == 0){
                return false;
            }
        }
        return true;
    }
    public static void main(String [] args){
        Scanner inputScanner = new Scanner(System.in);
        int t = inputScanner.nextInt();
        int m = 0;
        ArrayList<Long> numList = new ArrayList<>();
        ArrayList<Long> outputList = new ArrayList<>();
        while(t>0){
            m = inputScanner.nextInt();
            while(m>0){
                numList.add(inputScanner.nextLong());
                m--;
            }
            Collections.sort(numList);
            Collections.reverse(numList);
            outputList.add(new DualList().doWork(numList));
            numList.clear();
            t--;
        }

        for(long i:outputList){
            System.out.println(i);
        }
    }

    public long doWork(ArrayList<Long> listOfNumbers){
        long num = -1;
        for(long i : listOfNumbers){
            if(this.isPrime(i)){
                num = i;
                break;
            }
        }
        return num*num;
    }
}

