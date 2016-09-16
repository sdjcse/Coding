

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by sdj on 9/16/16.
 *
 *https://www.hackerearth.com/problem/algorithm/problem-3-18/
 */
public class SubString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.next();
        char [] b = "ABC".toCharArray();

        int count = 0;
        int limit = s.length()/3;

        for(int j=1;j<limit;j++){
            b = getCharArray(j);
            for(int i=0;i<s.length()-(j*3-1);i++){
                char a [] = s.substring(i,i+(j*3)).toCharArray();
                Arrays.sort(a);
                count = (Arrays.equals(a,b)) ? (count+1) : count;
            }
        }


        System.out.println(count);
    }
    static char [] getCharArray(int i){
        String s = "ABC";
        for(int j=1;j<i;j++){
            s += "ABC";
        }
        char b [] = s.toCharArray();
        Arrays.sort(b);
        return b;
    }
}
