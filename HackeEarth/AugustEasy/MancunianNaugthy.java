import java.util.*;

/**
 * Created by sdj on 7/8/16.
 *
 * https://www.hackerearth.com/august-easy-16/algorithm/mancunian-and-naughty-numbers-1/description/
 */
public class MancunianNaughty {

    public  static  void main(String [] args){
        Scanner inputScanner = new Scanner(System.in);
        int q = inputScanner.nextInt();
        List<Integer> outputList = new ArrayList<Integer>();
        int min=0,max=0;
        MancunianNaughty driver = new MancunianNaughty();
        int []isNaugthyArray = new int[100001];
        isNaugthyArray[1] = 1;
        isNaugthyArray[0] = 0;

        for(int i=2;i<=100000;i++){
            isNaugthyArray[i] = isNaugthyArray[i-1] + (driver.isNaughty(i)?1:0);
        }

        for(int i=0;i<q;i++){
                min = inputScanner.nextInt();
                max = inputScanner.nextInt();
            outputList.add(isNaugthyArray[max]-isNaugthyArray[min-1]);
        }

        for(int i:outputList){
            System.out.println(i);
        }
    }

    public boolean isNaughty(int n){
        return countPrimeFactors(n)==String.valueOf(n).length() ? true : false;
    }
    public int countPrimeFactors(int n){
        int i=n;
        int count = 0;
            while(i%2==0){
                count ++;
                i /= 2;
            }
        count = count >=1 ? 1 : 0;
        for(int j=3;j<=Math.sqrt(new Double(n));j+=2){
            if(i%j==0){
                count ++;
                while(i%j==0){
                    i /= j;
                }
            }
        }
        count = (i>2) ? count+1 : count;
        return count;
    }

}

