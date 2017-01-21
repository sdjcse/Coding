package com.intern.gs;

import java.util.Scanner;

/**
 * Created by sdj on 12/10/16.
 */
public class StringTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        //int num = findfirstChar(s);
        //s =  num == -1 ? "All characters are repeating" : Integer.toString(num);
        System.out.println(findfirstChar(s));
    }
    public static String findfirstChar(String s){
        int num = -1;
        int numArr [][] = new int[26][2];
        for(int i=0;i<s.length();i++){
            System.out.println(s.charAt(i)-'a');
            numArr[s.charAt(i)-'a'][0]++;
            numArr[s.charAt(i)-'a'][1] = numArr[s.charAt(i)-'a'][1] == 0 ? i+1 : numArr[s.charAt(i)-'a'][1];
        }

        for(int i=0;i<numArr.length;i++){
            if(numArr[i][0]==1){
                if (num != -1 && num<numArr[i][1]){
                    continue;
                }
                num = numArr[i][1];
            }
        }
        return String.valueOf(s.charAt(num-1));
    }
}
