
import java.util.*;

/**
 * Created by sdj on 9/16/16.
 *
 * https://www.hackerearth.com/september-circuits/algorithm/mishki-playing-games/
 */

class MikshiGame {
    public static void main(String[] args) {
        Set<Integer> oddSet = new HashSet<>();

        fillInSet(oddSet);
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int q = input.nextInt();

        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = input.nextInt();
        }

        List<String> opList = new ArrayList<>();

        for(int i=0;i<q;i++){
            opList.add(checkWinner(input.nextInt(),input.nextInt(),arr,oddSet));
        }

        for(String s:opList){
            System.out.println(s);
        }
    }

    public static String checkWinner(int start,int end,int arr[],Set<Integer> oddSet){
        int oddCount = 0;
        String winner = "Mishki";
        for(int i=start-1;i<=end-1;i++){
            if(oddSet.contains(arr[i])){
                oddCount++;
            }
        }
        if(oddCount==0 || oddCount%2==0){
            winner = "Hacker";
        }
        return winner;
    }

    public static void fillInSet(Set<Integer> oddSet){
        oddSet.add(1);
        float logVal = 0f;
        int cap = 0;
        for(int i=2;i<1000001;){
            logVal = log(i,2);
            logVal++;
            cap = i*2;
            if(logVal%2!=0){
                oddSet.add(i);
                for(i=i+1;i<cap && i<1000001;i++){
                    oddSet.add(i);
                }
            }else{
                i=i*2;
            }
        }
    }

    static float log(int x, int base){
        return (float) (Math.log(x) / Math.log(base));
    }
}
