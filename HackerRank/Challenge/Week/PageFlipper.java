package com.hackerrank.challenge.week;

import java.util.Scanner;

public class PageFlipper {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        // your code goes here
        int totPageTurn = posRet(n);
        int pagePos = posRet(p);
        System.out.println(totPageTurn-pagePos<pagePos-1?totPageTurn-pagePos:pagePos-1);
    }
    public static int posRet(int n){
        return (n%2==0) ? (((n+1)+1)/2) : ((n+1)/2);
    }
}
