package ds.arrays;

import java.util.Scanner;

/**
 * Created by sdjcs on 7/11/2017.
 */
public class AlgoCrush {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int dataArr[] = new int[n+1];
        int maxVal = Integer.MIN_VALUE;
        int start,end,incrementer;

        for (int i = 0; i < dataArr.length; i++) {
            dataArr[i] = 0;
        }

        for (int i = 0; i < m; i++) {
            start = input.nextInt();
            end = input.nextInt();
            incrementer = input.nextInt();
            for(int j = start;j<=end;j++){
                dataArr[j] += incrementer;
                if(dataArr[j] > maxVal){
                    maxVal = dataArr[j];
                }
            }
        }

        System.out.println(maxVal);
    }
}
