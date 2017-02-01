package com.intern.fidessa;

import java.util.*;

/**
 * Created by sdj on 1/30/17.
 */
public class Triangle
{
    public static void main(String[] args)
    {
        Long a[] = new Long[3];
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List<String> outList = new ArrayList<>();
        Set<Long> checkSet = new HashSet<>();
        long temp = 0;
        while (n>0)
        {
            checkSet.clear();
            for (int i=0;i<3;i++){
                temp = input.nextLong();
                a[i] = temp;
                checkSet.add(temp);
            }

            if(checkSet.size()==1){
                outList.add("Equilateral");
            }else if (checkSet.size() == 2 && isTriangle(a)){
                outList.add("Isoceles");
            }else {
                outList.add("None of these");
            }
            n--;
        }
        for(String s : outList){
            System.out.println(s);
        }

    }

    public static boolean isTriangle(Long a[]){
        Long temp [] = a.clone();
        Arrays.sort(temp);
        return temp[0]+temp[1] >= temp[2] && temp[0]!=0;
    }
}
