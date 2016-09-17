import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by sdj on 9/16/16.
 *
 * https://www.hackerearth.com/september-circuits/algorithm/print-hackerearth/
 */
public class StringPossiblities {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Integer len = input.nextInt();
        String s = input.next();

        char [] inp = s.toCharArray();
        boolean [] asserter = new boolean[7];
        for(int i=0;i<asserter.length;i++){
            asserter[i] = false;
        }
        Map<Character,Integer> numMap = new HashMap<>();
        int counter = 0;
        for(int i=0;i<len;i++){
            switch (inp[i]){
                case 'a':
                    asserter[0] = true;
                    affectMap(numMap,inp[i]);
                    break;
                case 'h':
                    asserter[1] = true;
                    affectMap(numMap,inp[i]);
                    break;
                case 'c':
                    asserter[2] = true;
                    affectMap(numMap,inp[i]);
                    break;
                case 'k':
                    asserter[3] = true;
                    affectMap(numMap,inp[i]);
                    break;
                case 'e':
                    asserter[4] = true;
                    affectMap(numMap,inp[i]);
                    break;
                case 't':
                    asserter[5] = true;
                    affectMap(numMap,inp[i]);
                    break;
                case 'r':
                    asserter[6] = true;
                    affectMap(numMap,inp[i]);
                    break;
            }
        }

        boolean finAss = true;
        for(int i=0;i<asserter.length;i++){
            finAss = finAss && asserter[i];
        }



        Iterator it = numMap.entrySet().iterator();
        while (it.hasNext() && finAss) {
            Map.Entry pair = (Map.Entry)it.next();
            switch ((Character)pair.getKey()) {
                case 'a':
                case 'h':
                case 'e':
                case 'r':
                    counter = (numMap.get(pair.getKey())==null) ? 0 : numMap.get(pair.getKey());
                    if(counter < 2){
                        finAss = false;
                        break;
                    }
                    counter = counter/2;
                    numMap.put((Character) pair.getKey(),counter);
                    break;
            }
        }



        int minVal = numMap.get('a');
        it = numMap.entrySet().iterator();
        while (it.hasNext() && finAss) {
            Map.Entry pair = (Map.Entry) it.next();
            if((Integer)pair.getValue() < minVal){
                minVal = (Integer) pair.getValue();
            }
        }
        if(!finAss){
            System.out.println("0");
        }else {
            System.out.println(minVal);
        }
    }

    public static void affectMap(Map<Character,Integer> numMap, Character inp){
        int counter =0;
        counter = (numMap.get(inp)==null) ? 0 : numMap.get(inp);
        counter ++;
        numMap.put(inp,counter);
    }
}
