package com.ctci.strarr;

/**
 * Created by sdj on 9/26/16.
 *
 * Cracking the coding interview - replace the space in the string to %20
 * given adequate spaces in the end of the string
 */
public class SpaceReplace {
    public static void main(String[] args) {
        System.out.println(replacedString("I    am   good              "));
    }

    public static String replacedString(String s){
        if(s==null || s.length()==0){
            return null;
        }
        char arr[] = s.toCharArray();
        System.out.println(arr);
        int j=s.length();
        j--;
        int i = j;
        for(;arr[i] == ' ';i--){}
        for(;i>=0;i--,j--){
            //System.out.println(i + " " + j);
            if(arr[i] != ' '){
                arr[j] = arr[i];
            }else{
                arr[j] = '0';
                arr[j-1] = '2';
                arr[j-2] = '%';
                j = j-2;
            }
        }
        System.out.println(arr);
        return new String(arr);
    }
}
