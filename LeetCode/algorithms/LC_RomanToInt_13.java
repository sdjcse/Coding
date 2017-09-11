package LeetCode.algorithms;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LC_RomanToInt_13 {
    public static void main(String[] args) {
        System.out.println(
                romanToInt("XL")
        );
    }

    private static int romanToInt(String roman){
        int num = 0;
        Map<Character,Integer> romanMap = new HashMap<>();
        romanMap.put('I',1);
        romanMap.put('V',5);
        romanMap.put('X',10);
        romanMap.put('L',50);
        romanMap.put('C',100);
        romanMap.put('D',500);
        romanMap.put('M',1000);
        if(roman.length()==0){
            return 0;
        }
        num += romanMap.get(
                roman.charAt(roman.length()-1)
        );
        int maxTill = num;
        for (int i = roman.length()-2; i >=0; i--) {
            if(romanMap.get(roman.charAt(i)) < maxTill){
                num -= romanMap.get(
                        roman.charAt(i)
                );
            }else{
                num += romanMap.get(
                        roman.charAt(i)
                );
                maxTill = romanMap.get(roman.charAt(i));
            }
        }
        return num;
    }
}
