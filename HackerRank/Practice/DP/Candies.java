package com.hackerrank.practice.dp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sdj on 3/9/17.
 *
 * https://www.hackerrank.com/challenges/candies
 */
public class Candies
{
    public static void main(String[] args)
    {
        Scanner inp = new Scanner(System.in);
        List<Long> inpList = new ArrayList<>();
        long n = inp.nextInt();
        while (n-->0){
            inpList.add(inp.nextLong());
        }
        System.out.println(maxSum(inpList));
    }

    public static  long maxSum(List<Long> inpList){
        long candy [] = new long[inpList.size()];
        for (int i = 0; i < candy.length; i++)
        {
            candy[i] = 1;
        }

        for(int i=1;i<candy.length;i++){
            if(inpList.get(i)>inpList.get(i-1)){
                candy[i] = candy[i-1]+1;
            }
        }

        for (int i = inpList.size()-2; i > -1; i--)
        {
            if(inpList.get(i)>inpList.get(i+1)){
                candy[i] = Math.max(candy[i],candy[i+1]+1);
            }
        }

        long sum = 0;
        for (int i = 0; i < candy.length; i++)
        {
            sum +=candy[i];
        }
        return sum;
    }
}
