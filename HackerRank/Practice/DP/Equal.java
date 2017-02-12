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

    public static int countOper(List<Integer> inList){
        int oper = 0;
        int mid = 0;
        int min = 0;
        mainSet = new TreeSet<>(inList);
        while (mainSet.size()!=1){
            mid = midVal();
            min = minVal();
            if(mid-min == 1){
                incList(inList,1,inList.indexOf(mid));
            }else if(mid-min<5){
                incList(inList,2,inList.indexOf(mid));
            }else if (mid-min>=5){
                incList(inList,5,inList.indexOf(mid));
            }
            oper++;
        }
        return oper;
    }

    public static boolean allEqual(List<Integer> inList){
        return new HashSet<>(inList).size()==1;
    }
    public static void incList(List<Integer> inList,int num,int doNotIncInd){
        mainSet.clear();
        for (int i = 0; i < inList.size(); i++)
        {

            if(i == doNotIncInd){
                mainSet.add(inList.get(doNotIncInd));
                continue;
            }
            inList.set(i,inList.get(i)+num);
            mainSet.add(inList.get(i));
        }
    }
    public static int midVal(){
        return Arrays.copyOf(mainSet.toArray(),mainSet.size(),Integer[].class)[mainSet.size()/2];
    }

    public static int minVal(){
        return Arrays.copyOf(mainSet.toArray(),mainSet.size(),Integer[].class)[0];
    }
}
