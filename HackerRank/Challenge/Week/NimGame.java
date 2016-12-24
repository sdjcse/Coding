package com.hackerrank.challenge.week;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sdj on 12/23/16.
 */
public class NimGame {
    static long calcNimSum(List<Long> gameList){
        int n = gameList.size();
        long nimsum = gameList.get(0);
        for (int i=1; i<n; i++)
            nimsum = nimsum ^ gameList.get(i);
        return nimsum;
    }
    public static String nimFinder(List<Long> gameList){
        if(calcNimSum(gameList) != 0){
            return "W";
        }
        return "L";
    }
    public static void main(String[] args) {
        int t = 0;
        int n = 0;
        List<Long> gameList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        List<String> outList = new ArrayList<>();
        t = input.nextInt();
        while(t>0){
            n = input.nextInt();
            while(n>0){
                gameList.add(input.nextLong()+1l);
                n--;
            }
            outList.add(nimFinder(gameList));
            gameList.clear();
            t--;
        }
        for(String s: outList){
            System.out.println(s);
        }
    }
}
