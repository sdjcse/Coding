package com.hackerrank.challenge.week;

import java.util.*;

/**
 * Created by sdj on 12/20/16.
 */
public class ClusterTailor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int pricePerButton = input.nextInt();
        int copyN = n;
        List<Integer> numList = new ArrayList<>();
        // Set<Integer> uniqueSet = new HashSet<>();
        List<Integer> uniqueSet = new ArrayList<>();
        long temp = 0;
        List<Integer> actList = new ArrayList<>();
        long max = 0;

        while(copyN > 0){
            actList.add(input.nextInt());
            copyN--;
        }
        Collections.sort(actList);
        copyN = n;
        int i = 0;
        long sum = 0;
        long q = 0;
        while(copyN!=i){
            temp = actList.get(i);
            q = temp/pricePerButton;
            if(q <= max){
                max = max+1;
                q = max;
            }else{
                if(temp % pricePerButton != 0){
                    q+= 1;
                }
                max = q;
            }
            sum += q;
            i++;
        }
        System.out.println(sum);
    }
}
