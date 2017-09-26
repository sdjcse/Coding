package algorithms;

import java.util.*;

public class LC_LetterCombo_17 {
    public static void main(String[] args) {
        List<String> output = letterCombinations("23");
        for(String unit : output){
            System.out.println(unit);
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> finList = new ArrayList<>();
        if(digits.length()==0){
            return finList;
        }
        StringBuffer temp = new StringBuffer(digits);
        Map<Character,char []> numMap = numMapFun();
        System.out.println(digits.charAt(0));
        letterComboUtil(temp,0,digits,finList,numMap);
        return finList;
    }

    public static Map<Character,char []> numMapFun(){
        Map<Character,char []> outMap = new HashMap<>();
        outMap.put('2', new char[] {'a','b','c'});
        outMap.put('3', new char[] {'d','e','f'});
        outMap.put('4', new char[] {'g','h','i'});
        outMap.put('5', new char[] {'j','k','l'});
        outMap.put('6', new char[] {'m','n','o'});
        outMap.put('7', new char[] {'p','q','r','s'});
        outMap.put('8', new char[] {'t','u','v'});
        outMap.put('9', new char[] {'w','x','y','z'});

        return outMap;
    }

    public static void  letterComboUtil(StringBuffer temp,int position,String digits,List<String> finList,Map<Character,char[]> numMap){
        if(position == digits.length()){
            finList.add(temp.toString());
            return;
        }

        for(char unit : numMap.get(digits.charAt(position))){
            temp.setCharAt(position,unit);
            letterComboUtil(temp,position+1,digits,finList,numMap);
        }
    }
}
