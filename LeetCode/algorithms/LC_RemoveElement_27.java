package LeetCode.algorithms;

public class LC_RemoveElement_27 {
    public static void main(String[] args) {
        System.out.println(
                removeElement(
                        new int[] {2,1,1,1,1,2,1,12,1,2},1
                )
        );
    }
    public static int removeElement(int[] nums, int val) {
        int walker = 0,runner = 0;
        if(nums.length ==1 && nums[0] == val){
            return 0;
        }
        while(runner < nums.length){
            if(nums[walker] == val){
                while(runner<nums.length && nums[runner]==val){
                    runner++;
                }
            }
            if((runner < nums.length && nums[runner]!=val && nums[walker] == val)
                    ||
                    (runner < nums.length && walker < nums.length && nums[runner]!=val)){
                nums[walker] = nums[runner];
                walker++;
                runner++;
            }else{
                runner++;
            }

        }
        return walker;
    }
}
