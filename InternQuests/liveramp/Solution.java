package com.intern.liveramp;
// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
// Time problem - form the maximum possible time based on the given four integers

public class Solution {
    public String solution(int A, int B, int C, int D) {
        // write your code in Java SE 8
        List<Integer> numArr = new ArrayList<>();
        numArr.clear();
        numArr.add(A); numArr.add(B); numArr.add(C); numArr.add(D);
        int hourMax = -1;
        for(int hMax : numArr){
            if(hMax <=2 && hMax>hourMax ){
                hourMax = hMax;
            }
        }
        numArr.remove(new Integer(hourMax));
        int secMax = 100;
        if(hourMax==2 ){
            for(int sec:numArr){
                if(sec < 4){
                    secMax = sec;
                }
            }
        }else{
            secMax = Collections.max(numArr);
        }
        numArr.remove(new Integer(secMax));
        int third = numArr.get(0);
        int fourth = numArr.get(1);

        if(hourMax == -1 || secMax == 100 || (third > 6 && fourth >6)){
            return "NOT POSSIBLE";
        }
        third = third < 6 ? (third*10+fourth) : fourth*10+third;
        String timeStr = Integer.toString(hourMax*10+secMax) + ":" + Integer.toString(third);
        return timeStr;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(2,4,0,0));
        System.out.println(s.solution(3,0,7,0));
        System.out.println(s.solution(9,1,9,7));
    }
}