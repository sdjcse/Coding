package LeetCode.algorithms;

/**
 * Created by Dhananjayan on 6/9/2017.
 */
public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(new ReverseInteger().reverse(
                1000000003
        ));
    }
    public int reverse(int x){
        boolean negBool = false;
        if(x<0){
            negBool = true;
        }
        int returnInt = 0;
        int prevNum = returnInt;
        int reducer = negBool ? (x*-1) : x;
        while(Math.abs(reducer)>9)
        {
            returnInt = returnInt == 0 ? reducer%10 : (returnInt*10 + reducer%10);
            if(prevNum != returnInt/10){
                return 0;
            }
            reducer /= 10;
            prevNum = returnInt;
        }
        if(reducer != 0){
            returnInt = (returnInt * 10 + reducer);
        }
        if(prevNum != returnInt/10){
            return 0;
        }
        return negBool ? -1*returnInt : returnInt;
    }
}
