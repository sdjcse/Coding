package com.hackerearth.problems;

import java.util.*;

// Problem - https://www.hackerearth.com/problem/algorithm/gudi-trapped-in-the-room-july-easy/
public class GudiTrapped {

    public SortedSet<String> getBaseSet() {
        return baseSet;
    }

    private SortedSet<String> baseSet;


    public GudiTrapped() {
        baseSet = new TreeSet<String>();
    }

    public static void main(String[] args) {
        List<String> outputList = new ArrayList<String>();

        // Pilot Object to drive the program
        GudiTrapped pilotObject = new GudiTrapped();

        Scanner inputGetter = new Scanner(System.in);

        int t = inputGetter.nextInt();
        while(t>0){
            pilotObject.driver(inputGetter);
            outputList.add(pilotObject.getBaseSet().first());
            t--;
        }

        for(String iter:outputList){
            System.out.println(iter);
        }
    }


    public void driver(Scanner inputScanner){
        String inputString;
        int add,shift;
        // Clearing baseSet each time before use
        baseSet.clear();

        inputString = inputScanner.next();
        add = inputScanner.nextInt();
        shift = inputScanner.nextInt();
        depthFirstTraversal(inputString,add,shift);
    }

    public void depthFirstTraversal(String temp, int add, int shift){
        int oldChar ;

        Stack<String> checkStack = new Stack<String>();
        checkStack.push(temp);

        // Shift String initially and add to the superset
        String morphedString = null;
        String oldString = null;
        while(!checkStack.isEmpty()){
            morphedString = checkStack.pop();
            oldString = morphedString;
            baseSet.add(morphedString);
            morphedString = shiftString(morphedString,shift);
            if(!baseSet.contains(morphedString)){
                checkStack.push(morphedString);
            }

            morphedString = oldString;
            for(int i=0;i<morphedString.length();i++){
                if(i%2!=0){
                    oldChar = (morphedString.charAt(i))-'0';
                    oldChar = (oldChar+add)%10;
                    morphedString = morphedString.substring(0,i) + Integer.toString(oldChar)+ morphedString.substring(i+1);
                }
            }
            if(!baseSet.contains(morphedString)) {checkStack.push(morphedString); }
        }
        return;
    }

    public String shiftString(String s, int places){
        String shifted = s;
        for(int i=0;i<places;i++){
            shifted = shifted.charAt(shifted.length()-1) + shifted.substring(0,s.length()-1);
        }
        return shifted;
    }
}

