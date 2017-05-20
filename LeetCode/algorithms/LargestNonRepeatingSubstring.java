package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by sdj on 5/18/17.
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/#/description
 */
public class LargestNonRepeatingSubstring
{
    public static void main(String[] args)
    {
        System.out.println(new LargestNonRepeatingSubstring().lengthOfLongestSubstring("abcbcdabb"));
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if(s.length()<2){
            return s.length();
        }
        // Brute Force
        /*for(int i=0;i<s.length() && max<s.length()-i;i++){
            temp = subLength(s.substring(i,s.length()));
            max = temp > max ? temp : max;
        }*/

        // DP

        return dpSubLength(s);
    }

    private int dpSubLength(String s){
        Map<Character,Integer> charMap = new HashMap<>();
        int max = 0;
        int len = s.length();
        int start = 0;
        for (int i = 0; i < len; i++)
        {
            if(charMap.containsKey(s.charAt(i)) && charMap.get(s.charAt(i))>= start){
                start = charMap.get(s.charAt(i))+1;
            }
            charMap.put(s.charAt(i),i);
            max = Math.max(max,i-start+1);
        }
        return max;
    }
    private int subLength(String s){
        int lenArr[] = new int[s.length()];
        // abcabcdbb
        Set<Character> chars = new HashSet<>();
        for (int i = 0; i < lenArr.length; i++)
        {
            lenArr[i] = 1;
        }
        for (int i = 0; i < lenArr.length; i++)
        {
            if(i!=0 && !chars.contains(s.charAt(i)) && s.charAt(i)!=s.charAt(i-1)){
                lenArr[i] += lenArr[i-1];
            }else {
                chars.clear();
            }
            chars.add(s.charAt(i));
        }
        return findMax(lenArr);
    }
    private int findMax(int arr[]){
        int max = 0;
        for (int i = 0; i < arr.length; i++)
        {
            max = (arr[i]>max) ? arr[i] : max;
        }
        return max;
    }
}
