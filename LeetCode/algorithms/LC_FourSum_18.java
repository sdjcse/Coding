package LeetCode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_FourSum_18 {

    public static void main(String[] args) {
        List<List<Integer>> outList = fourSum(new int[]{1,0,-1,0,-2,2},0);
        for (int i = 0; i < outList.size(); i++) {
            for (int j = 0; j < outList.get(i).size(); j++) {
                System.out.print(outList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(nums==null|| nums.length<4)
            return result;

        Arrays.sort(nums);

        for (int i = 0; i < nums.length-3; i++) {
            if(i!=0 && nums[i] == nums[i-1]){
                continue;
            }
            for (int j = i+1; j < nums.length-2; j++) {
                if(j!=i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                int k = j+1;
                int l = nums.length - 1;
                while(k<l){
                    if(nums[i]+nums[j]+nums[k]+nums[l] < target){
                        k++;
                    }else if(nums[i]+nums[j]+nums[k]+nums[l] > target){
                        l--;
                    }else{
                        List<Integer> innerList = new ArrayList<>();
                        innerList.add(nums[i]);
                        innerList.add(nums[j]);
                        innerList.add(nums[k]);
                        innerList.add(nums[l]);
                        result.add(innerList);

                        k++;
                        l--;
                        while (k<l && nums[l] == nums[l+1]){
                            l--;
                        }
                        while (k<l && nums[k] == nums[k-1]){
                            k++;
                        }
                    }

                }
            }
        }
        return result;
    }
}
