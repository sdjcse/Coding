package LeetCode.algorithms;

import java.util.ArrayList;
import java.util.List;

public class LC_LastWord_58 {
    public static void main(String[] args) {
        System.out.println(
                lengthOfLastWord("tesasdfasdft")
        );
    }
    public static int lengthOfLastWord(String s) {
        List<StringBuffer> words = new ArrayList<>();
        StringBuffer temp = null;
        char arr [] = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == ' ' && temp!=null){
                    words.add(temp);
                    temp = null;
            }else if(arr[i]!=' ' && temp==null){
                    temp = new StringBuffer();
                    temp.append(arr[i]);
            }else if(arr[i]!=' ' && temp!=null){
                temp.append(arr[i]);
            }
        }
        if(temp!=null){
            words.add(temp);
        }
        return words.size() != 0? words.get(words.size()-1).length() : 0;
    }
}
