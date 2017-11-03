package algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class LC_CombinationSum_39 {
    public static void main(String[] args) {

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> inputList = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            inputList.add(candidates[i]);
        }
        Collections.sort(inputList);
        List<String> comboList = new ArrayList<>();
        List<List<Integer>> out = new ArrayList<>();
        int consider = 0;
        int start = 0;
        List<Integer> interimList;
        for(int i=0;i<inputList.size();i++){
            consider = inputList.get(i);
            start = target/consider;
            interimList = new ArrayList<>();
            String s = "";
            if(target%consider==0){
                while(start-->0){
                    interimList.add(consider);
                }
                for(Integer iter:interimList){
                    s += iter;
                }
                comboList.add(s);
            }
            while(start>1){

            }
        }
        return out;
    }

    boolean findVal(int start,int end,List<Integer> input,int interimtarget){
        if(start>end){
            return false;
        }
        int mid = (start+end)/2;
        if(input.get(mid)==interimtarget){
            return true;
        }else if(input.get(mid)<interimtarget){
            return findVal(mid+1,end,input,interimtarget);
        }else{
            return findVal(start,mid-1,input,interimtarget);
        }
    }
}
