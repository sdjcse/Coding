package algorithms;

public class LC_StrStr_28 {
    public static void main(String[] args) {
        System.out.println(
                strStr(
                        "mississippi",
                        "issipi"
                )
        );
    }
    public static int strStr(String haystack, String needle) {
        if(needle.length()==0){
            return 0;
        }else if(needle.length() > haystack.length()){
            return -1;
        }
        int j = 0;
        for(int i=0;i<haystack.length();i++){
            if(haystack.charAt(i) == needle.charAt(0)){
                j=0;
                for(int k = i;k<i+needle.length() && k <haystack.length();k++){
                    if(!(haystack.charAt(k)==needle.charAt(j++))){
                        j--;
                        break;
                    }
                }
            }
            if(j==needle.length()){
                return i;
            }
        }
        return -1;
    }
}
