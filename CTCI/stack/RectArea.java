package com.ctci;

import java.util.Stack;

/**
 * Created by sdj on 2/17/17.
 * Find the maximum area formed by a rectangle in a given histogram	
 */
public class RectArea
{
    public static void main(String[] args)
    {
        int arr[] = {6,2,5,4,5,1,6};
        System.out.println(maxArea(arr));
    }

    public static int maxArea(int arr[]){
        int maxArea = 0;
        int iter = 0;
        int popped = 0;
        int innerIter = 0;
        Stack<Integer> numStack = new Stack<>();
        Stack<Integer> posStack = new Stack<>();
        while(iter<arr.length){
            if(numStack.size()==0 || numStack.peek()<arr[iter]){
                numStack.push(arr[iter]);
                posStack.push(iter);
            }
            else if(numStack.peek()>arr[iter]){
                while(!numStack.isEmpty() && numStack.peek()>arr[iter]){
                    popped = numStack.pop();
                    innerIter = posStack.pop();
                    maxArea = Math.max(maxArea,popped*(iter-innerIter));
                }
                numStack.push(arr[iter]);
                posStack.push(innerIter);
            }
            iter++;
        }
        while(!numStack.isEmpty()){
            popped = numStack.pop();
            innerIter = posStack.pop();
            maxArea = Math.max(maxArea,popped*(iter-innerIter));
        }
        return maxArea;
    }
}
