package LeetCode.algorithms;

import java.util.HashMap;
import java.util.Map;

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
        for (int i = 0; i < nums.length; i++) {
            numList.put(nums[i],i);
        }
        int retNum [] = new int[2];
        for (int i = 0; i < numList.size(); i++) {
            retNum[0] = i;
            Boolean bool = numList.containsKey(target-nums[i]);
            if(bool!=null && bool){
                retNum[1] = numList.get(target-nums[i]);
                if(retNum[0]==retNum[1])
                    continue;
                return retNum;
            }
        }
        return null;
    }
}
