package LeetCode.algorithms;

/**
 * Created by dsantha1 on 6/11/2017.
 */
public class ZigZag {
    public static void main(String[] args) {
        System.out.println(
                new ZigZag().convert("ABC",2)
        );
    }
    public String convert(String s, int numRows) {
        String retStr = s;
        String [] subStr = new String[numRows];
        int n = s.length();
        int leaper = numRows-1+numRows-2-1;
        int smallLeaper = 2;
        boolean toggler = true;
        for (int i = 0; i < subStr.length; i++) {
            subStr[i] = "";
        }
        if(numRows==1 || s.length()==numRows)
        {return retStr;}
        else if(numRows == 2){
            for(int i=0,j=1;i<n || j<n;i+=2,j+=2){
                subStr[0] += i<n? s.charAt(i) : "";
                subStr[1] += j<n?s.charAt(j) : "";
            }
        }else
        {
            for (int i = 0; i < numRows; i++) {
                for (int j = i; j < n; j=(i==0 || i==numRows-1) ?j+(2*numRows-2) : (toggler) ? j+leaper : j+smallLeaper,toggler = !toggler
                        )  {
                    subStr[i] += s.charAt(j);
                }
                if(i>=1){
                    leaper -= 2;
                    smallLeaper += 2;
                }
                toggler=true;
            }
        }
        return combiner(subStr);
    }
    private String combiner(String[] arr){
        String ret = "";
        for (int i = 0; i < arr.length; i++) {
            ret += arr[i];
        }
        return ret;
    }
}
