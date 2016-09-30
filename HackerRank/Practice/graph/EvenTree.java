/**
 * Created by sdj 9/29/16.
 *
 * https://www.hackerrank.com/challenges/even-tree
 */

import java.util.Arrays;
import java.util.Scanner;

public class EvenTree{

    public static void main(String[] args) {
        Scanner inpObj = new Scanner(System.in);
        int n = inpObj.nextInt();
        int m = inpObj.nextInt();

        int [][] inpArr = new int[m][2];
        for(int i=0;i<m;i++){
            inpArr[i][0] = inpObj.nextInt();
            inpArr[i][1] = inpObj.nextInt();
        }

        System.out.println(evenTreeCounter(inpArr,n));
    }

    public static int evenTreeCounter(int [][] inpArr,int n){
        int pruneCount = -1;

        int parentTracker[] = new int[n];
        int counter[] = new int[n];

        Arrays.fill(counter,1);
        int child,parent,reachToRoot;
        for(int i=0;i<inpArr.length;i++){
            child = inpArr[i][0];
            parent = inpArr[i][1];

            counter[parent-1] += counter[child-1];
            parentTracker[child-1] = parent;

            reachToRoot = parentTracker[parent-1];
            while(reachToRoot != 0){
                counter[reachToRoot-1] += counter[child-1];
                reachToRoot = parentTracker[reachToRoot-1];
            }
        }

        for(int i=0;i<inpArr.length;i++){
            if(counter[i]%2 == 0){
                pruneCount++;
            }
        }
        return pruneCount;
    }
}
