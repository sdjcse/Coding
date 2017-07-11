package ds.arrays;

import java.util.*;

public class SparseArrays{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        Map<String,Integer> dataMap = new HashMap<>();
        String temp = null;
        for (int i = 0; i < n; i++) {
            temp = input.next();
            if(dataMap.containsKey(temp)){
                dataMap.put(temp,dataMap.get(temp)+1);
            }else{
                dataMap.put(temp,1);
            }
        }
        int q = input.nextInt();
        List<Integer> outList = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            temp = input.next();
            if(dataMap.containsKey(temp)){
                outList.add(dataMap.get(temp));
            }else {
                outList.add(0);
            }
        }

        for (int i = 0; i < outList.size(); i++) {
            System.out.println(outList.get(i));
        }
    }
}