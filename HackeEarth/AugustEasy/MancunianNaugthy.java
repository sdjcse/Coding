
import java.util.*;

/**
 * Created by sdj on 7/8/16.

https://www.hackerearth.com/august-easy-16/algorithm/mancunian-and-naughty-numbers-1/
 */
public class MancunianNaughty {

    public  static  void main(String [] args){
        Map<Integer,Integer> factorCount = new HashMap<Integer,Integer>();
        Scanner inputScanner = new Scanner(System.in);
        int q = inputScanner.nextInt();
        List<Integer> outputList = new ArrayList<Integer>();
        int min=0,max=0;
        int numPrimeFact = 0,length = 0;
        int naughtyCount = 0;
        MancunianNaughty driver = new MancunianNaughty();
        for(int i=0;i<q;i++){
                min = inputScanner.nextInt();
                max = inputScanner.nextInt();
            for(int j=min;j<=max;j++){
                if(j==1){
                    naughtyCount++;
                    continue;
                }
                if(factorCount.containsKey(j)){
                    numPrimeFact = factorCount.get(j);
                }else{
                    numPrimeFact = driver.countPrimeFactors(j);
                    numPrimeFact = (numPrimeFact==0 && j!=1)? 1 : numPrimeFact;
                    factorCount.put(j,numPrimeFact);
                }
                length = driver.countNumberOfDigits(j);
                naughtyCount = (numPrimeFact==length) ? naughtyCount+1 : naughtyCount;
            }
            outputList.add(naughtyCount);
            naughtyCount = 0;
        }

        for(int i:outputList){
            System.out.println(i);
        }
    }

    public int countNumberOfDigits(int n){
        int j=n;
        int length = 1;
        while(j>=10){
            length++;
            j=j/10;
        }
        return length;
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

