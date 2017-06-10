package LeetCode.algorithms;

/**
 * Created by Dhananjayan on 6/10/2017.
 */
public class LongestPalinSubString {
    public static void main(String[] args) {
        System.out.println(
                new LongestPalinSubString().longestPalindrome(
                        "babad"
                )
        );
    }
    public String longestPalindrome(String s) {
        int len = s.length();
        if( isPalindrome(
                s
        ) || len == 0){
            return s;
        }
        int leftOutCnt = 0;
        for(int i=1;i<len;i++){
            leftOutCnt = len-i;
            for(int j=0;leftOutCnt<len+1;j++,leftOutCnt++){
                if(isPalindrome(s.substring(j,leftOutCnt))){
                    return s.substring(j,leftOutCnt);
                }
            }
        }
        return s.substring(0,1);
    }

    private boolean isPalindrome(String a){
        return new StringBuilder(a).reverse().toString().equals(a);
    }
}
