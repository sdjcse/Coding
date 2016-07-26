import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by sdj on 25/7/16.
 *
 * HackerEarth Problem: https://www.hackerearth.com/july-circuits/algorithm/little-shino-and-coins-3/
 */
public class ShinoCoinProblem
{
    public ShinoCoinProblem(){
    }
    public static void main(String [] args){
        Scanner inputScaner = new Scanner(System.in);
        int k = inputScaner.nextInt();
        String inputString = inputScaner.next();
        System.out.println(new ShinoCoinProblem().uniquePairs(k,inputString));
    }

    public int uniquePairs(int k, String s){
        int strLen = s.length();
        HashSet<Integer> banList = new LinkedHashSet<Integer>();
        Set<Character> charSet = new HashSet<>();
        int uniquePairs = 0;
        int findDupLength = 0;

        for(int i=0;i<strLen;i++){
            for(int j=i+k;j<=strLen;j++){
                if(banList.contains(j)){
                    continue;
                }
                if(charSet.isEmpty()) {
                    charSet = removeDuplicatesSet(s.substring(i,j));
                    findDupLength = charSet.size();
                }else if(!charSet.contains(s.charAt(j-1))){
                    charSet.add(s.charAt(j-1));
                    findDupLength++;
                }

                if(k == findDupLength){
                    uniquePairs++;
                }
                else if(k < findDupLength){
                    break;
                }else{
                    banList.add(j);
                }
            }
            charSet.clear();
        }
        return uniquePairs;
    }

    public static Set removeDuplicatesSet(String s){
        Set<Character> seen = new HashSet<Character>();
        int strLen = s.length();

        for(int i = 0; i < strLen; ++i) {
            char c = s.charAt(i);
            if(!seen.contains(c)) {
                seen.add(c);
            }
        }

        return seen;
    }
}
