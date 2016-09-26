import java.util.*;

/**
 * Created by sdj on 9/22/16.
 *
 * https://www.hackerearth.com/september-circuits/algorithm/fredo-and-large-numbers/
 */
public class FredoBigNum {
    public static void main(String[] args) {
        Map<Long,Long> testMap = new LinkedHashMap<>();
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        long temp = 0;
        long tempVal = 0;
        for(int i=0;i<n;i++){
            temp = input.nextLong();
            if (testMap.containsKey(temp)){
                tempVal = testMap.get(temp);
                testMap.remove(temp);
                tempVal++;
                testMap.put(temp,tempVal);
            }else{
                testMap.put(temp,new Long(1));
            }
        }

        int q = input.nextInt();
        int queryType = 0;
        long number = 0l;
        Iterator it = null;
        List<String> opList = new ArrayList<>();
        boolean flag = true;
        while (q>0){
            flag = true;
            queryType = input.nextInt();
            number = input.nextLong();
            it = testMap.entrySet().iterator();
            if(!testMap.containsValue(number)){
                q--;
                opList.add("0");
                continue;
            }
            if(queryType == 0){
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();
                    if((Long)pair.getValue() >= number){
                        opList.add(Long.toString((Long)pair.getKey()));
                        flag = false;
                        break;
                    }
                }
            }else{
                while (it.hasNext()) {
                    Map.Entry pair = (Map.Entry)it.next();
                    if((Long)pair.getValue() == number){
                        opList.add(Long.toString((Long)pair.getKey()));
                        flag = false;
                        break;
                    }
                }
            }
            if(flag){
                opList.add("0");
            }
            q--;
        }

        for(String s : opList){
            System.out.println(s);
        }

    }
}
