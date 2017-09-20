package algorithms;

public class LC_SearchRotated_33{
    public static void main(String[] args) {
        System.out.println(
                search(
                        new int[]{1,3},2
                )
        );
    }
    public static int search(int[] nums, int target) {
        if(nums.length == 0){
            return -1;
        }else if(nums.length == 1){
            return target == nums[0] ? 0 : -1;
        }
        return searchUtil(nums,0,nums.length-1,target);
    }

    private static int searchUtil(int [] nums,int start,int end, int target){
        if(target < nums[0] && target > nums[nums.length-1]){
            return -1;
        }
        if(start==end  ){
            return nums[start] == target ? start : -1;
        }
        int mid = (start+end)/2;
        if(nums[mid] == target){
            return mid;
        }else if(nums[start] <= nums[mid]){
            if(target >= nums[start] && target<= nums[mid]){
                return searchUtil(nums,start,mid,target);
            }else{
                return searchUtil(nums,mid+1,end,target);
            }
        }else {
            if(target >= nums[mid+1] && target <= nums[end]){
                return searchUtil(nums,mid+1,end,target);
            }else{
                return searchUtil(nums,start,mid,target);
            }
        }
    }
}