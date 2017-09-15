package LeetCode.algorithms;

import java.util.Arrays;

public class LC_NextPerm_31 {
    public static void main(String[] args) {
        int test1[] =new int[]{2,1,8,7,6,5};
        int test2[] = new int[]{2,3,1};
        nextPermutation(test1);
        printArr(test1);
    }
    public static void nextPermutation(int[] nums) {
           int i = nums.length-1;
           while (i>0){
               if(nums[i-1] < nums[i]){
                   break;
               }
               i--;
           }
           if(i==0){
               reverseArr(nums);
               return;
           }
           int nextMax=i;
           for(int j=i;j<nums.length;j++){
               if(nums[j] > nums[i-1] && nums[nextMax] > nums[j]){
                   nextMax = j;
               }
           }
           nums[nextMax] = nums[nextMax] + nums[i-1];
        nums[i-1] = nums[nextMax] - nums[i-1];
        nums[nextMax] = nums[nextMax] - nums[i-1];
        Arrays.sort(nums,i,nums.length);
    }

    private static void reverseArr(int [] nums){
        int i = 0,j=nums.length-1;
        while (i<j){
            nums[i] = nums[i]+nums[j];
            nums[j] = nums[i]-nums[j];
            nums[i] = nums[i]-nums[j];
            i++;
            j--;
        }
    }

    private static void printArr(int [] nums){
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
