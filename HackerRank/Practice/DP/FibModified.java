package com.hackerrank.practice.dp;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by sdj on 27/8/16.
 */
public class FibModified {
    public static void main(String [] args){
        BigInteger t1,t2;
                int n=0;
        Scanner inputScanner = new Scanner(System.in);

        t1 = inputScanner.nextBigInteger();
        t2 = inputScanner.nextBigInteger();
        n = inputScanner.nextInt();
        BigInteger temp = new BigInteger("0");

        for(int i=3;i<=n;i++){
            temp = t1.add(t2.multiply(t2));
            t1 = t2;
            t2 = temp;
        }

        System.out.println(temp);
    }
}
