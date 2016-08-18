import java.util.*;

/**
 * Created by sdj on 18/8/16.
 *
 * https://www.hackerearth.com/problem/algorithm/monk-and-power-of-time/
 */
public class MonkPowerTime {
    Queue<Integer> actual = new LinkedList<>();
    List<Integer> ideal = new ArrayList<>();
    int n = 0;

    public static void main(String [] args){
        MonkPowerTime driver = new MonkPowerTime();
        driver.getInput();
        System.out.println(driver.calculateWork());
    }

    public int calculateWork(){
        int workRequired = 0;
        for(int i=0;i<n;i++){
            while(ideal.get(i) != actual.peek()){
                actual.add(actual.poll());
                workRequired++;
            }
            workRequired++;
            actual.poll();
        }
        return workRequired;
    }

    public void getInput(){
        Scanner inputScanner = new Scanner(System.in);
        this.n = inputScanner.nextInt();
        for(int i=0;i<n;i++){
            this.actual.add(inputScanner.nextInt());
        }
        for(int i=0;i<n;i++){
            this.ideal.add(inputScanner.nextInt());
        }
    }

}

