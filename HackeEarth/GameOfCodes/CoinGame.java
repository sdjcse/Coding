

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by sdj on 9/15/16.
 *
 * https://www.hackerearth.com/game-of-codes-3/algorithm/problem-2-34/
 */
public class CoinGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int numOfGames = 0;
        List<Integer> opList = new ArrayList<>();

        while(n>0){
            numOfGames = input.nextInt();
            while(numOfGames>0){
                opList.add(findNumbers(input.nextInt(),input.nextInt(),input.nextInt()));
                numOfGames--;
            }
            n--;
        }

        for(int i:opList){
            System.out.println(i);
        }
    }

    static int findNumbers(int x,int n,int y){
        int num = 0;
        if(n%2==0){
            num = n/2;
        }else {
            num = n/2;
            if(x!=y){
                num++;
            }
        }
        return num;
    }
}
