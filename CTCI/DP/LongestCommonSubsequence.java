package com.ctci.dp;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by sdj on 1/7/17.
 *
 * Program to practice Longest common Subsequence problem
 *
 * Finding the longest common subsequence possible in two given strings
 *
 */
public class LongestCommonSubsequence
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String first = input.next();
        String second = input.next();

        char [] firstArr = first.toCharArray();
        char [] secondArr = second.toCharArray();

        Map<Character,Integer> firstMapping = new HashMap<>();
        Map<Character,Integer> secondMapping = new HashMap<>();

        for(int i=0 , j=0 ; i < firstArr.length && j < secondArr.length ; i++ , j++)
        {
        }

    }
}
