package com.hackerrank.practice.dp;

import java.util.*;

/**
 * Created by sdj on 2/11/17.
 *
 * https://www.hackerrank.com/challenges/equal
 */
public class Equal
{
    static Set<Integer> mainSet = null;
    public static void main(String[] args)
    {
        Scanner inp = new Scanner(System.in);
        int n = inp.nextInt();
        List<Integer> outList = new ArrayList<>();
        List<Integer> inList = new ArrayList<>();
        int t = 0;
        while(n>0){
            n--;
            t = inp.nextInt();
            inList.clear();
            while(t>0){
                inList.add(inp.nextInt());
                t--;
            }
            outList.add(countOper(inList));
        }

        for (int i = 0; i < outList.size(); i++)
        {
            System.out.println(outList.get(i));
        }
    }

    public static int func(int minVal){
        int retVal = 0;
        if(minVal>=5){
            retVal = minVal/5;
            minVal %= 5;
        }
        if(minVal>=0)
        {
            retVal += minVal/2;
            minVal %=2;
        }
        retVal += minVal;
        return retVal;
    }
    public static int countOper(List<Integer> inList){
        Collections.sort(inList);
        int min = inList.get(0);
        int temp = 0;
        List<Integer> compList = new ArrayList<>();
        for (int j=0;j<=5;j++){
            compList.add(0);
            for(int i=0;i<inList.size();i++){
                temp = Math.abs(inList.get(i)-(min-j));
                compList.set(j,compList.get(j)+func(temp));
            }
        }
        Collections.sort(compList);
        return compList.get(0);
    }
}
