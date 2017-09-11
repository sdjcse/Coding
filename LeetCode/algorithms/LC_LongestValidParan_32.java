package LeetCode.algorithms;

import java.util.Stack;

public class LC_LongestValidParan_32 {
    public static void main(String[] args) {
        System.out.println(
                longestParans("(((((()()")
        );
    }

    private static int longestParans(String input){
        int n = input.length();
        Stack<Integer> stack = new Stack<>();

        stack.push(-1);
        int result = 0;
        for (int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(!stack.empty()){
                    result = Math.max(result,i-stack.peek());
                }else {
                    stack.push(i);
                }
            }
        }
        return result;
    }
}
