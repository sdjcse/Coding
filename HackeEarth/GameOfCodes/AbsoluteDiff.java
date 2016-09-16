
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sdj on 9/15/16.
 *
 * https://www.hackerearth.com/game-of-codes-3/algorithm/problem-1-56/
 */
public class AbsoluteDiff {
    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);
        int n = input.nextInt();
        List<Integer> inpList = new ArrayList<>();
        while(n>0){
            inpList.add(input.nextInt());
            n--;
        }

        List<Integer> outList = findAbsDiff(inpList);

        for(int i:outList){
            System.out.print(i + " ");
        }
    }

    static List<Integer> findAbsDiff(List<Integer> inpList){
        List<Integer> opList = new ArrayList<>();
        Collections.sort(inpList);
        int absDiff = Integer.MAX_VALUE;
        for(int i=0;i<inpList.size()-1;i++){
            if(Math.abs(inpList.get(i)-inpList.get(i+1)) < absDiff ){
                absDiff = Math.abs(inpList.get(i)-inpList.get(i+1));
                opList.clear();
                opList.add(inpList.get(i));
                opList.add(inpList.get(i+1));
            }else if (Math.abs(inpList.get(i)-inpList.get(i+1)) == absDiff){
                opList.add(inpList.get(i));
                opList.add(inpList.get(i+1));
            }
        }
        return opList;
    }
}
