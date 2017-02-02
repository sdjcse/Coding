package com.hackerrank.practice.interviewchall;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sdj on 9/27/16.
 *
 * https://www.hackerrank.com/contests/programming-interview-questions/challenges/fibonacci-returns
 */
public class FibDp {
    public static void fillFib(BigDecimal a,BigDecimal b,List<BigDecimal> arr){
        if(arr.size() == 100){
            return;
        }

        BigDecimal c = new BigDecimal(String.valueOf(a.add(b)));
        arr.add(c);
        a = b;
        b = c;
        fillFib(a,b,arr);
    }
    public static void main(String[] args) {
        BigDecimal a = new BigDecimal(0);
        BigDecimal b = new BigDecimal(1);


        List<BigDecimal> list = new ArrayList<>();
        list.add(a);
        list.add(b);

        fillFib(a,b,list);
        Scanner input = new Scanner(System.in);
        List<Integer> inpList = new ArrayList<>();

        while(input.hasNext()){
            inpList.add(input.nextInt());
        }
        for(int i:inpList){
            if(i==0){
                System.out.println("0");
                continue;
            }
            System.out.println(list.get(i));
        }
    }
}
