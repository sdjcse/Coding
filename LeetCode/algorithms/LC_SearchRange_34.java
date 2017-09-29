package algorithms;

public class LC_SearchRange_34 {
    public static void main(String[] args) {
        int [] outArr = searchRange(new int []{9,9,9,9,9,9,9,9,10},9 );
        System.out.println(outArr[0] + " " + outArr[1]);
    }
    public static  int[] searchRange(int[] nums, int target) {
        int [] outArr = new int[]{-1,-1};
        searchRangeUtil(outArr,nums,target,0,nums.length-1);
        return outArr;
    }

    private static void searchRangeUtil(int [] outArr, int [] nums,int target,int start,int end){
        if(start>end){
            return;
        }
        int mid = (start + end) /2;
        if(nums[mid] == target){
            if((mid>0 && mid< nums.length-1) && nums[mid-1] < target && nums[mid+1] > target){
                outArr[0] = outArr[1] = mid;
                return;
            }
            if(      mid == 0 ||
                    (mid!=0 && nums[mid-1] < target)
                    ){
                outArr[0] = mid;
            }else if(nums[mid-1] == target){
                searchRangeUtil(outArr,nums,target,start,mid-1);
            }
            if(     mid == nums.length-1 ||
                    (mid+1!=nums.length && nums[mid+1] > target)
                    ){
                outArr[1] = mid;
            }else if(nums[mid+1] == target){
                searchRangeUtil(outArr,nums,target,mid+1,end);
            }
        }else if(nums[mid] < target){
            searchRangeUtil(outArr,nums,target,mid+1,end);
        }else{
            searchRangeUtil(outArr,nums,target,start,mid-1);
        }
    }
}
