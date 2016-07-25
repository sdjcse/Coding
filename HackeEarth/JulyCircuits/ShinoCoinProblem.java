package com.hackerearth.problems;

import com.hackerearth.utilities.StringUtils;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by sdj on 25/7/16.
 *
 * HackerEarth Problem: https://www.hackerearth.com/july-circuits/algorithm/little-shino-and-coins-3/
 */
public class ShinoCoinProblem
{
    public ShinoCoinProblem(){

    }
    public static void main(String [] args){
        Scanner inputScaner = new Scanner(System.in);
        int k = inputScaner.nextInt();
        String inputString = inputScaner.next();
        System.out.println(new ShinoCoinProblem().uniquePairs(k,inputString));
    }

    public int uniquePairs(int k, String s){
        int strLen = s.length();
        int uniquePairs = 0;
        for(int i=0;i<strLen;i++){
            for(int j=i+k;j<=strLen;j++){
                if(k == ShinoCoinProblem.removeDuplicates(s.substring(i,j)).length()){
                    uniquePairs++;
                }
                else if(k < ShinoCoinProblem.removeDuplicates(s.substring(i,j)).length()){
                    break;
                }
            }
        }
        return uniquePairs;
    }

    public static String removeDuplicates(String s){
        StringBuilder sb = new StringBuilder();
        Set<Character> seen = new HashSet<Character>();

        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if(!seen.contains(c)) {
                seen.add(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
