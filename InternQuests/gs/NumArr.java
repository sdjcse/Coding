package com.intern.gs;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sdj on 12/11/16.
 */
public class NumArr {
    public static void main(String[] args) {
        System.out.println(countPairs(new int[]{10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1},11));
    }
    static int countPairs(int a[], int k){
        int n = a.length;
        Map<Integer,Integer> m = new HashMap<>();
        Integer inc = 0;
        for(int i=0;i<n;i++){
            if(m.get(a[i]) != null){
                inc = m.get(a[i]);
                inc++;
                m.put(a[i],inc);
            }else{
                m.put(a[i],1);
            }

        }
        int two = 0;
        for (int i=0;i<n;i++){
            if(m.get(k - a[i]) != null){
                two +=  m.get(k - a[i]);
                if(k-a[i] == a[i]) {
                    two--;
                }
            }
        }
        return  two/2;
    }
}
