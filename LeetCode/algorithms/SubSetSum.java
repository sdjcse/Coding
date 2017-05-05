package LeetCode.algorithms;

import java.util.*;

/**
 * Created by Dhananjayan on 5/5/2017.
 */
public class SubSetSum {
    public static void main(String[] args) {
        int [] arr = new SubSetSum().subSetSum(new int[]{3,2,4},6);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int [] subSetSum( int [] nums,int target){
        Map<Integer,Integer> numList = new HashMap<>();
        int [] retArr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if(numList.containsKey(target-nums[i])){
                retArr[1] = i;
                retArr[0] = numList.get(target-nums[i]);
                return retArr;
            }
            numList.put(nums[i],i);
        }
        return retArr;
    }
}
