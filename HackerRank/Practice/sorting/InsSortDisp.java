package com.hackerrank.practice.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sdj on 3/9/17.
 * https://www.hackerrank.com/challenges/insertionsort1/submissions
 */
public class InsSortDisp
{
    public static void main(String[] args)
    {
        Scanner inp = new Scanner(System.in);
        List<Integer> inpList = new ArrayList<>();
        int n = inp.nextInt();
        while(n-->0){
            inpList.add(inp.nextInt());
        }
        int right = inpList.remove(inpList.size()-1);
        inpList.add(-1);
        int j = inpList.size()-2;
        boolean flag = true;
        while(flag){
            for(int i = j;i>-1;){
                if(inpList.get(i)>right){
                    inpList.set(i+1,inpList.get(i));
                    j = i-1;
                    break;
                }else{
                  flag = false;
                    inpList.set(i+1,right);
                    break;
                }
            }

            for (int i = 0; i < inpList.size(); i++)
            {
                System.out.print(inpList.get(i)+ " ");
            }
            System.out.println();
            if(j==-1){
                flag = false;
                inpList.set(0,right);
                for (int i = 0; i < inpList.size(); i++)
                {
                    System.out.print(inpList.get(i)+ " ");
                }
            }
        }

    }
}
