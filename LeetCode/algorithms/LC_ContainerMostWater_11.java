package LeetCode.algorithms;

public class LC_ContainerMostWater_11 {
    public static void main(String[] args) {
        System.out.println(
                maxArea(
                        new int[] {1,2,5,4,5,1,6}
                )
        );
    }
    public static int maxArea(int[] height) {
        if(height==null || height.length < 2){
            return 0;
        }
        int left = 0,right = height.length-1 , max = 0;
        while (left < right){
            max = Math.max(
                    max, (right-left) * Math.min(height[left],height[right])
            );
            if(height[left] < height[right]){
                left++;
            }else {
                right--;
            }
        }
        return max;
    }
}
