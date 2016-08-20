
import java.util.*;

/**
 * Created by sdj on 19/8/16.
 *
 * https://www.hackerearth.com/problem/algorithm/litte-jhool-and-world-tour-1/
 */
public class JhoolWorldTour {
    public static void main(String [] args){
        Scanner inputScanner = new Scanner(System.in);
        long t = inputScanner.nextLong();
        List<String> outputList = new ArrayList<>();

        long n,m=0;
        while(t>0){
            n = inputScanner.nextLong();
            m = inputScanner.nextLong();
            outputList.add(new JhoolWorldTour().scanAndProcess(n,m,inputScanner));
            t--;
        }
        for(String s: outputList){
            System.out.println(s);
        }
    }

    public String scanAndProcess(long n,long m, Scanner inputScanner){
        String ret = "YES";
        long firstNumber = 0,secondNumber = 0;
        Set<Long> visitedSet = new HashSet<>();
        boolean addedOne = false;
        long i=0;
        for(i=0;i<m;i++){
            firstNumber = inputScanner.nextLong();
            secondNumber = inputScanner.nextLong();
            if(firstNumber == secondNumber){
                visitedSet.add(firstNumber);
                addedOne = true;
            }else{
                    for(long j=firstNumber;j<=secondNumber || j<n;j++,j=j%n){
                        if(visitedSet.contains(j)){
                            if(j==secondNumber){
                                break;
                            }
                            continue;
                        }
                        addedOne = true;
                        visitedSet.add(j);
                        break;
                    }
                if(!addedOne){
                    ret = "NO";
                    break;
                }
            }
            addedOne = false;
        }
        i++;
        while(i<m){
            inputScanner.nextLong();
            inputScanner.nextLong();
            i++;
        }
        return ret;
    }
}

