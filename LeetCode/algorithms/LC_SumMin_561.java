package algorithms;

import java.util.Arrays;

public class LC_SumMin_561 {
    public static void main(String[] args) {

    }
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            sum = i%2 == 0 ? sum + nums[i] : sum;
        }
        return sum;
    }
}
