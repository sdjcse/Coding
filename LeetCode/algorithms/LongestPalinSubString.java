package LeetCode.algorithms;

/**
 * Created by Dhananjayan on 6/10/2017.
 */
public class LongestPalinSubString {
    public static void main(String[] args) {
        System.out.println(
                new LongestPalinSubString().longestPalindrome(
                        "ccc"
                )
        );
    }

    // Brute Force
    /*
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
    */
    public String longestPalindrome(String s) {
        int n = s.length();
        int start=0,maxLen=1;
        boolean determiner[][] = new boolean[n][n];
        for (int i = 0; i < determiner.length; i++) {
            for (int j = 0; j < determiner.length; j++) {
                determiner[i][j] = i==j ;
            }
        }

        for (int i = 0; i < determiner.length-1; i++) {
            determiner[i][i+1] = s.charAt(i) == s.charAt(i+1);
            if(determiner[i][i+1]){
                start=i;
                maxLen=2;
            }
        }

        for (int i = 3; i <= determiner.length; i++) {
            for (int j = 0; j < n-i+1; j++) {
                int k = j+i-1;
                determiner[j][k] = determiner[j+1][k-1] && s.charAt(j) == s.charAt(k);
                if(determiner[j][k] && i>maxLen){
                    start=j;
                    maxLen=i;
                }
            }
        }
        return s.substring(start,start+maxLen);
    }
}
