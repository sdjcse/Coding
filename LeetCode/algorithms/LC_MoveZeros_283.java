package LeetCode.algorithms;

public class LC_MoveZeros_283 {
    public static void main(String[] args) {
        moveZeroes(new int[] {0,1,0,3,12});
    }
    public static void moveZeroes(int[] nums) {
        if(nums== null || nums.length < 2){
            return;
        }
        int runner = 0,walker = 0;
        int nonZeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            nonZeroCount += nums[i]!=0 ? 1 : 0;
        }

        for (int i = 0; i < nums.length && walker < nonZeroCount; i++) {
            if(nums[i]!=0){
                nums[walker++] = nums[i];
            }
        }
        for (int i = walker; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
