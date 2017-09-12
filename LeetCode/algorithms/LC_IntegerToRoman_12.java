package LeetCode.algorithms;

import java.util.*;

public class LC_IntegerToRoman_12 {
    public static void main(String[] args) {
        System.out.println(
                intToRoman(
                        11
                )
        );
    }

    private static String intToRoman(int num){
        String output = "";
        Map<Integer,String> bases = frameBaseMap();
        List<Integer> baseList = new ArrayList<>(bases.keySet());
        Collections.sort(baseList);
        int copy = num;
        while(copy > 0){
            if(copy > baseList.get(baseList.size()-1)){
                output += bases.get(baseList.get(baseList.size()-1));
                copy -= baseList.get(baseList.size()-1);
                continue;
            }
            for (int i = 0; i < baseList.size(); i++) {
                if(copy == baseList.get(i)){
                    output += bases.get(copy);
                    copy -= baseList.get(i);
                    break;
                }else if(baseList.get(i) > copy){
                    output += bases.get(baseList.get(i-1));
                    copy -= baseList.get(i-1);
                    i=-1;
                }
            }
        }
        return output;
    }
    private static Map<Integer,String> frameBaseMap(){
        Map<Integer,String> bases = new HashMap<>();
        bases.put(1,"I");
        bases.put(4,"IV");
        bases.put(5,"V");
        bases.put(9,"IX");
        bases.put(10,"X");
        bases.put(40,"XL");
        bases.put(50,"L");
        bases.put(90,"XC");
        bases.put(100,"C");
        bases.put(400,"CD");
        bases.put(500,"D");
        bases.put(900,"CM");
        bases.put(1000,"M");
        return bases;
    }
}
