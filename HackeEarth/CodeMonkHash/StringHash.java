package com.hackerearth.challenge.monkhash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sdj on 1/11/17.
 */
public class StringHash
{
    public static String hashIt(List<String> inpList)
    {
        char charArr [] = null;
        int iter = 0;
        long tempSum = 0;
        for(String s : inpList)
        {
            charArr = s.toCharArray();
            iter = -1;
            for(char a : charArr)
            {
                iter ++;
                tempSum += iter;
                if ( 96 < a && a < 123 )
                {
                    tempSum += a - 'a';
                }
                else if( 64 < a && a < 91 )
                {
                    tempSum += a - 'A' + 36;
                }
                else if( 47 < a && a < 58)
                {
                    tempSum += (a!='0') ? a - '1' + 26 : a - '0' + 35;
                }
            }
        }
        return Long.toString(tempSum * inpList.size());
    }
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        List<String> inpList = new ArrayList<>();
        List<String> outList = new ArrayList<>();
        while(n>0)
        {
            inpList.clear();
            inpList.addAll(Arrays.asList(input.nextLine().split(" ")));
            outList.add(hashIt(inpList));
            n--;
        }
        for(String s : outList)
        {
            System.out.println(s);
        }
    }
}
