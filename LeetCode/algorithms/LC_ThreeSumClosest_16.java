package LeetCode.algorithms;

import java.util.Arrays;

public class LC_ThreeSumClosest_16 {
    public static void main(String[] args) {
        System.out.println(
                closestSum(
                        new int[] {1,1,1,0},-100
                )
        );
    }

    private static Integer closestSum(int [] nums,int reqSum){
        Arrays.sort(nums);
        int interSum = 0;
        Integer closestSum = Integer.MAX_VALUE;
        int absDifff = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int j = i+1;
            int k = nums.length - 1;
            while (j<k){
                interSum = nums[i] + nums[j] + nums[k];
                absDifff = Math.abs(interSum - reqSum);
                if(absDifff==0){
                    return reqSum;
                }
                if(absDifff < closestSum){
                    closestSum = absDifff;
                    sum = interSum;
                }
                if(interSum > reqSum) {
                    k--;
                }else if(interSum <= reqSum) {
                    j++;
                }
            }
        }
        return sum;
    }

    private static int makeAbs(int n){
        return n >0? n : (-1*n);
    }
}
