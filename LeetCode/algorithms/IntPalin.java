package LeetCode.algorithms;

/**
 * Created by Dhananjayan on 6/9/2017.
 */
public class IntPalin {
    public static void main(String[] args) {
        System.out.println(new IntPalin().isPalindrome(
                12321
        ));
    }
    public boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }
        int len = String.valueOf(x).length();
        int i = len;
        int first =x,second=0;
        while(i-->len/2){
            second = (second*10)+x%10;
            x /= 10;
        }
        first = (int)(first/Math.pow(10,len/2)) ;
        return first == second;
    }
}
