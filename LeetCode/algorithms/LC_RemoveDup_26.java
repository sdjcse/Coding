package LeetCode.algorithms;

public class LC_RemoveDup_26 {

    public static void main(String[] args) {
        System.out.println(
                removeDuplicates(
                        new int[] { 1,1,2,2,2,2,3,3,3,3 }
                )
        );
    }
    public static int removeDuplicates(int[] nums) {
        int runner = 0;
        for(int i=0 ; i<nums.length-1 ; i++){
            if(nums[i] != nums[i+1]){
                nums[runner++] = nums[i];
            }
        }
        nums[runner++] = nums[nums.length-1];
        return runner;
    }
}
