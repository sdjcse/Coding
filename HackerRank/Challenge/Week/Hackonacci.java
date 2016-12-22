package com.hackerrank.challenge.week;

import java.util.*;

/**
 * Created by sdj on 12/21/16.
 */
public class Hackonacci {
    public static boolean hackonacci(long n){
        int modVal = (int)(n%(7l));
        switch (modVal){
            case 1:
            case 3:
            case 6:
            case 0:
                return false;
        }
        return true;
    }
    public static void swap(boolean [][] arr,int a,int b,int c,int d){
        boolean temp = arr[a][b];
        arr[a][b] = arr[c][d];
        arr[c][d] = temp;
    }
    public static boolean[][] rotate(boolean arr[][]){
        int len = arr.length;
        boolean newArr[][] = arr.clone();
        for(int i=0;i<arr.length/2;i++){
            for(int j=i;j<arr.length-i-1;j++){
                swap(arr,len-i-1,len-j-1,len-j-1,i);
                swap(arr,j,len-i-1,len-i-1,len-j-1);
                swap(arr,i,j,j,len-i-1);
            }
        }
        return newArr;
    }

    public static boolean[][] rotateAnti(boolean arr[][]){
        int len = arr.length;
        boolean newArr[][] = arr.clone();
        for(int i=0;i<arr.length/2;i++){
            for(int j=i;j<arr.length-i-1;j++){
                swap(arr,i,j,j,len-i-1);
                swap(arr,j,len-i-1,len-i-1,len-j-1);
                swap(arr,len-i-1,len-j-1,len-j-1,i);
            }
        }
        return newArr;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int q = input.nextInt();
        boolean nArr [][] = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                nArr[i][j] = hackonacci(((long)(i+1)*(long)(j+1))*((long)(i+1)*(long)(j+1)));
            }
        }
        int rotate = 0;
        boolean newArr [] [] = null;
        List<Long> outList = new ArrayList<>();
        newArr = copyMat(nArr);
        boolean firstRot[][] = rotate(newArr);
        boolean secondRot[][] = rotate(copyMat(firstRot));
        boolean twosevenrot[][] =  rotate(copyMat(secondRot));
        Map<Integer,Long> outListMap = new HashMap<>();
        outListMap.put(0,0l);
        outListMap.put(1,diffNum(nArr,firstRot));
        outListMap.put(2,diffNum(nArr,secondRot));
        outListMap.put(3,diffNum(nArr,twosevenrot));
        while(q>0){
            rotate = input.nextInt();
            rotate = (rotate/90) % 4;
            outList.add(outListMap.get(rotate));
            q--;
        }
        for(long i:outList){
            System.out.println(i);
        }
    }

    public static boolean[][] copyMat(boolean[][] arr){
        boolean newA[][] = new boolean[arr.length][arr.length];
        for(int i=0;i<arr.length;i++)
            for(int j=0;j<arr.length;j++)
                newA[i][j] = arr[i][j];
        return newA;
    }
    public static  long diffNum(boolean [][] first,boolean [][] second){
        long diff = 0;
        for(int i=0;i<first.length;i++)
            for(int j=0;j<first.length;j++)
                diff += (first[i][j]!=second[i][j]) ? 1l : 0;
        return diff;
    }
}
