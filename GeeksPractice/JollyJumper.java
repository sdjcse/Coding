import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by sdj on 11/8/16.
 *
 * Practice code : GeeksForGeeks
 * http://www.geeksforgeeks.org/jolly-jumper-sequence/
 */
public class JollyJumper {
    public static void main(String [] args){
        Scanner inputScanner = new Scanner(System.in);
        ArrayList<Integer> mainChecker = new ArrayList<>();
        int prev = 0,next = 0;
        int n = 0;
        int absDiff = 0;

        n = inputScanner.nextInt();

        prev = inputScanner.nextInt();
        for(int i=0;i<n-1;i++){
            next = inputScanner.nextInt();
            absDiff = Math.abs(next - prev);
            prev = next;
            if(absDiff>0 && absDiff<=n-1 && !mainChecker.contains(absDiff)){
                mainChecker.add(absDiff);
            }else{
                System.out.println("Not a Jolly Jumper");
                break;
            }
        }
        if(mainChecker.size() == n-1){
            System.out.println("Yay! Jolly Jumper! ");
        }

    }
}

