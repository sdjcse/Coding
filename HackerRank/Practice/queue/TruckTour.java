package queue;

import java.util.*;

class TruckData{
    int petrol;
    int distanceToNext;

    public int getPetrol() {
        return petrol;
    }

    public int getDistanceToNext() {
        return distanceToNext;
    }

    TruckData(int petrol, int distanceToNext){
        this.petrol = petrol;
        this.distanceToNext = distanceToNext;
    }
}

public class TruckTour {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        List<TruckData> inputData = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            inputData.add(
                    new TruckData(
                            input.nextInt(),
                            input.nextInt()
                    )
            );
        }
        System.out.println(findStartPoint(inputData,n));
    }

     private static int findStartPoint(List<TruckData> data, int n){
        int start  = 0;
        int end = 1;
        int current = data.get(start).getPetrol() - data.get(start).getDistanceToNext();
        while(current < 0 || start!=end){
            while(current<0 && start!=end){
                current -= data.get(start).getPetrol() - data.get(start).getDistanceToNext();
                start = (start+1)%n;
                if(start == 0){
                    return -1;
                }
            }
            current += data.get(end).getPetrol() - data.get(end).getDistanceToNext();
            end = (end+1)%n;
        }
        return start;
    }
}
