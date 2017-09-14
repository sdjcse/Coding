package LeetCode.algorithms;

public class LC_RegEx_10 {

    public static void main(String[] args) {
        System.out.println(
                isMatch(
                        "aab","c*a*b"
                )
        );
    }
    public static boolean isMatch(String s, String p) {

        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = p.charAt(i-1) == '*' ? dp[0][i-2] : dp[0][i];
        }
        for (int i = 1; i<s.length()+1; i++) {
            for (int j = 1; j<p.length()+1; j++) {
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1)=='.'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(p.charAt(j-1)=='*'){
                    dp[i][j] = dp[i][j-2];
                    if(  (s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2)=='.')){
                        dp[i][j] = dp[i][j] |   dp[i-1][j];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}
