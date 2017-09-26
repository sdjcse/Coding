


import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

/**
 * Created by sdj on 12/16/16.
 */
public class NameFinder {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder inpStr = new StringBuilder(input.next());
        int indOfStar=0;
        List<Integer> starList = new ArrayList<>();
        while(inpStr.indexOf("*")!=-1){
            indOfStar = inpStr.indexOf("*");
            starList.add(indOfStar);
            inpStr.deleteCharAt(indOfStar);
        }
        int t = input.nextInt();
        StringBuilder iterS = null;
        int counter = 0;
        while(t>0){
            iterS = new StringBuilder(input.next());
            deleteStarChars(iterS,starList);
            counter += (difference(inpStr.toString(),iterS.toString()) <= 2) ? 1 : 0;
            t--;
        }
        System.out.println(counter);
    }
    static void deleteStarChars(StringBuilder iterS,List<Integer> delList){
        for(int i : delList)
            iterS.deleteCharAt(i);
    }
    static int difference(String s1,String s2){
        List<Character> union = convertArrayToList(s1.toCharArray());
        List<Character> intersection = new ArrayList<>(union);
        union.addAll(convertArrayToList(s2.toCharArray()));
        intersection.retainAll(convertArrayToList(s2.toCharArray()));
        union.removeAll(intersection);
        return union.size();
    }
    static List<Character> convertArrayToList(char [] arr){
        List<Character> newList = new ArrayList<>();
        for(char c : arr)
            newList.add(c);
        return newList;
    }
}
