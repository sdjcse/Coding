package LeetCode.algorithms;

public class LC_LongestCommonPref_14 {
    public static void main(String[] args) {
        System.out.println(
                longestCommonPrefix(
                        new String[]{
                                "asdfzxcv",
                                "asdfxcvbcxvb",
                                "asqwevcb"
                        }
                )
        );
    }
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)
            return "";
        int i = 0;
        String prefixStr = strs[0];
        while (i<strs.length){
            while (strs[i].indexOf(prefixStr)!=0){
                prefixStr = prefixStr.substring(0,prefixStr.length()-1);
            }
            i++;
        }
        return prefixStr;
    }
}
