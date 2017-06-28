package LeetCode.algorithms;

import java.util.*;

/**
 * Created by Dhananjayan on 6/27/2017.
 */
public class LC_ThreeSum_15 {
    public static void main(String[] args) {
        List<List<Integer>> output = new LC_ThreeSum_15().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for(List<Integer> unit : output){
            for(Integer unitsunit : unit){
                System.out.println(unitsunit);
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int forwardRunner,backwardRunner;
        List<List<Integer>> finList = new ArrayList<>();
        List<Integer> temp;
        for (int i = 0; i < nums.length-2; i++) {
            if(i==0 || nums[i]>nums[i-1]){
                forwardRunner = i+1;
                backwardRunner = nums.length-1;

                while (forwardRunner<backwardRunner){
                    if(nums[i] + nums[forwardRunner] + nums[backwardRunner] ==0){
                        temp = new ArrayList<>();
                        temp.add(nums[1]);
                        temp.add(nums[forwardRunner]);
                        temp.add(nums[backwardRunner]);
                        finList.add(temp);
                        forwardRunner++;
                        backwardRunner--;

                        // incrementing above hence checking one before
                        while (forwardRunner<backwardRunner && nums[forwardRunner] == nums[forwardRunner-1]){
                            forwardRunner++;
                        }
                        // decrementing above hence checking one after
                        while (forwardRunner<backwardRunner && nums[backwardRunner]==nums[backwardRunner+1]){
                            backwardRunner--;
                        }

                    }else if(nums[i] + nums[forwardRunner]+nums[backwardRunner] < 0) {
                        forwardRunner++;
                    }else {
                        backwardRunner--;
                    }
                }
            }
        }
        return finList;
    }
}
