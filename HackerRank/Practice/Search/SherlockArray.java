import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sdj on 9/12/16.
 *
 * https://www.hackerrank.com/challenges/sherlock-and-array
 */
public class SherlockArray {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        int n = inputScanner.nextInt();
        int arrSize = 0;
        List<Integer> numList = new ArrayList<>();
        List<String> op = new ArrayList<>();

        for(;n>0;n--){
            arrSize = inputScanner.nextInt();
            numList.clear();
            for(int i=0;i<arrSize;i++){
                numList.add(inputScanner.nextInt());
            }
            op.add(findSums(numList));
        }

        for(String s:op){
            System.out.println(s);
        }
    }

    public static String findSums(List<Integer> numList){
        if(numList.size()==1){
            return "YES";
        }
        String retStr = "NO";
        long netSum = 0;
        for(int i=0;i<numList.size();i++){
            netSum += numList.get(i);
        }

        long forwardSum = 0;
        for(int i=0;i<numList.size();i++){
            if(i==0){
                netSum -= numList.get(i);
                forwardSum += numList.get(i);
                continue;
            }
            if(forwardSum == (netSum-numList.get(i))){
                return "YES";
            }
            netSum -= numList.get(i);
            forwardSum += numList.get(i);
        }
        return retStr;
    }
}
