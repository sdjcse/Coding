package LeetCode.algorithms;

import java.util.Stack;

public class LC_ValidParan_20 {
    public static void main(String[] args) {
        System.out.println(
                isValid(
                        "()[]{}"
                )
        );

        System.out.println(
                isValid(
                        "([)]"
                )
        );

        System.out.println(
                isValid(
                        "(((({[]}))))"
                )
        );
    }
    public static boolean isValid(String s) {
        char [] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == '[' || arr[i] == '{' || arr[i] == '('){
                stack.push(arr[i]);
            }else if(!stack.isEmpty() && ((arr[i] == ']' && stack.peek() != '[')
                    || (arr[i] == '}' && stack.peek()!= '{')
                    || (arr[i] == ')' && stack.peek() != '(')
                    )){
                return false;
            }else if(stack.isEmpty() && (arr[i] == ']' || arr[i] == '}' || arr[i] == ')')) {
                return false;
            }else {
                stack.pop();
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}
