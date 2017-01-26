package com.ctci.strarr;

/**
 * Created by sdj on 12/15/16.
 */
public class InPlaceMatRot {
    public static void main(String[] args) {
        int arr[][] = new int[4][4];
        int len = arr.length;
        int counter = 1;
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                arr[i][j] = counter;
                counter++;
            }
        }
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }


        for(int i=0;i<arr.length/2;i++){
            for(int j=i;j<arr.length-i-1;j++){
                swap(arr,len-i-1,len-j-1,len-j-1,i);
                swap(arr,j,len-i-1,len-i-1,len-j-1);
                swap(arr,i,j,j,len-i-1);
            }
        }
        /* double f = Math.floor(((double) arr.length)/2);
        double c = Math.ceil(((double) arr.length)/2);
        for(int i=0;i<f;i++){
            for(int j=0;j<c;j++){
                swap(arr,len-i-1,len-j-1,len-j-1,i);
                swap(arr,j,len-i-1,len-i-1,len-j-1);
                swap(arr,i,j,j,len-i-1);
            }
        }
        /*for(int i=0;i<f;i++){
            for(int j=0;j<c;j++){
                swap(arr,i,j,j,len-i-1);
                swap(arr,j,len-i-1,len-i-1,len-j-1);
                swap(arr,len-i-1,len-j-1,len-j-1,i);
            }
        }
        for(int i=0;i<f;i++){
            for(int j=0;j<c;j++){
                swap(arr,i,j,j,len-i-1);
                swap(arr,j,len-i-1,len-i-1,len-j-1);
                swap(arr,len-i-1,len-j-1,len-j-1,i);
            }
        }*/
        System.out.println();
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void swap(int [][] arr,int a,int b,int c,int d){
        arr[a][b] = arr[a][b] + arr[c][d];
        arr[c][d] = arr[a][b] - arr[c][d];
        arr[a][b] = arr[a][b] - arr[c][d];
    }
}
