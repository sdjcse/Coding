package com.intern.fidessa;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by sdj on 1/30/17.
 */
public class NonRepeater
{
    public static void main(String[] args)
    {
        System.out.println(checkRepeater(new Scanner(System.in).next().toCharArray()));
    }

    public static String checkRepeater(char []a){
        int repeater = -1;
        Set<Character> checkSet = new HashSet<>();
        for(int i = a.length-1;i>=0;i--){
            if (checkSet.contains(a[i])){
                repeater = i;
            }else{
                checkSet.add(a[i]);
            }
        }
        if(repeater!=-1){
            return ""+a[repeater];
        }else {
            return "No repeater";
        }
    }
}
