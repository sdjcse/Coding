import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sdj on 27/8/16.
 *
 * https://www.hackerrank.com/challenges/maxsubarray
 */
public class MaxSubArr {
    public static void main(String[] args) {
        Scanner inpObj = new Scanner(System.in);
        int n = inpObj.nextInt();
        int opArr[][] = new int[n][2];
        List<Integer> arrList = new ArrayList<>();
        for(int i=0;i<n;i++){
            int m = inpObj.nextInt();
            arrList.clear();
            while(m>0){
                arrList.add(inpObj.nextInt());
                m--;
            }
            maxSumSubArr(i,opArr,arrList);
        }

        for(int i=0;i<n;i++){
            System.out.println(opArr[i][0] + " " + opArr[i][1]);
        }
    }

    public static void maxSumSubArr(int i,int [][] opArr,List<Integer> arrList){
        int secondSum = 0;
        int maxSumNow = 0,maxSumSoFar = 0;
        for(int j:arrList){
            if(j>0){
                secondSum+=j;
            }
            maxSumNow += j;
            if(maxSumNow<0){
                maxSumNow=0;
            }else if(maxSumNow>maxSumSoFar){
                maxSumSoFar = maxSumNow;
            }
        }
        opArr[i][0] = maxSumSoFar;
        opArr[i][1] = secondSum;
    }
}
