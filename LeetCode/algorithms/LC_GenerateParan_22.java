package LeetCode.algorithms;

import java.util.ArrayList;
import java.util.List;

public class LC_GenerateParan_22 {

    public static void main(String[] args) {
        List<String> out = generateParenthesis(3);
        for(String unit:out){
            System.out.println(
                    unit
            );
        }
    }
    public static List<String> generateParenthesis(int n) {
        List<String> outList = new ArrayList<>();
        char [] arr = new char[n*2];
        generate(arr,0,0,0,n,outList);
        return outList;
    }

    private static void generate(char [] generated,int position,int open,int close,int n,List<String> outList){
        if(close==n){
            outList.add(new String(generated));
        }else{
            if(open < n){
                generated[position] = '(';
                generate(generated,position+1,open+1,close,n,outList);
            }
            if(open > close) {
                generated[position] = ')';
                generate(generated,position+1,open,close+1,n,outList);
            }
        }
    }
}
