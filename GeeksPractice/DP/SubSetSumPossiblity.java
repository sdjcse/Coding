package com.ctci.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sdj on 3/20/17.
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
 */
public class SubSetSumPossiblity
{
    public static void main(String[] args)
    {
        List<Integer> inpList = new ArrayList<>();
        inpList.add(3);
        inpList.add(1);
        inpList.add(1);
        inpList.add(2);
        inpList.add(2);
        inpList.add(1);
        inpList.add(12);
        System.out.println(possiblity(inpList));
    }

    public static boolean possiblity(List<Integer> numList){
        int sum = findSum(numList);
        if(sum%2!=0){
            return false;
        }
        boolean possibArray[][] = new boolean[(sum/2)+1][numList.size()+1];
        for(int i=0;i<numList.size()+1;i++){
            possibArray[0][i] = true;
        }

        for(int i=1;i<(sum/2)+1;i++){
            for(int j=1;j<=numList.size();j++){
                possibArray[i][j] = possibArray[i][j-1];
                if(i>=numList.get(j-1)){
                    possibArray[i][j] = possibArray[i][j] || possibArray[i-numList.get(j-1)][j-1];
                }
            }
        }
        return possibArray[(sum/2)][numList.size()];
    }

    public static Integer findSum(List<Integer> numbers){
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++)
        {
            sum +=  numbers.get(i);

        }
        return sum;
    }
}
