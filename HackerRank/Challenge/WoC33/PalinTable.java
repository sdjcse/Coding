import java.util.*;

class CustomKey{
    int topLeftX,topLeftY,bottomRightX,bottomRightY;

    public CustomKey(int topLeftX, int topLeftY, int bottomRightX, int bottomRightY) {
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        this.bottomRightX = bottomRightX;
        this.bottomRightY = bottomRightY;
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof CustomKey)) return false;

        CustomKey customKey = (CustomKey) object;
        if (topLeftX != customKey.topLeftX) return false;
        if (topLeftY != customKey.topLeftY) return false;
        if (bottomRightX != customKey.bottomRightX) return false;
        if (bottomRightY != customKey.bottomRightY) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = topLeftX;
        result = 31 * result + topLeftY;
        result = 31 * result + bottomRightX;
        result = 31 * result + bottomRightY;
        return result;
    }

    @Override
    public String toString() {
        return "CustomKey{" +
                "topLeftX=" + topLeftX +
                ", topLeftY=" + topLeftY +
                ", bottomRightX=" + bottomRightX +
                ", bottomRightY=" + bottomRightY +
                '}';
    }
}

public class PalinTable{
    CustomKey maxRect;
    int maxArea = 1;
    List<CustomKey> visitedSet = new ArrayList<>();
    int [][] mat;

    public static void main(String[] args) {
        /*System.out.println(
                new PalinTable().findArea(
                        new CustomKey(
                                0,0,2,2
                        )
                )
        );*/
        /*List<CustomKey> testArr = new ArrayList<>();
        testArr.add(
                new CustomKey(0,1,2,3)
        );
        CustomKey testKey = new CustomKey(0,1,2,3);
        System.out.println(
                testArr.contains(testKey)
        );
        System.out.println(testArr.get(0).equals(testKey));*/
        Scanner input = new Scanner(System.in);
        PalinTable obj = new PalinTable();
        int rows = input.nextInt();
        int cols = input.nextInt();
        obj.mat = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                obj.mat[i][j] = input.nextInt();
            }
        }
        obj.maxRect = new CustomKey(0,0,0,0);
        obj.palinTable(new CustomKey(
                0,0,rows-1,cols-1
        ));
        System.out.println(obj.maxArea);
        System.out.println(obj.maxRect.topLeftX + " " + obj.maxRect.topLeftY + " " + obj.maxRect.bottomRightX + " " + obj.maxRect.bottomRightY);
    }

    public void palinTable(CustomKey key){
        boolean sec = visitedSet.contains(key);
        boolean thir = checkBoundary(key);
        if(sec || !thir){
            return;
        }
        if(maxArea < findArea(key) && isPalin(key)){
            maxArea = findArea(key);
            maxRect = key;
            visitedSet.add(key);
            return;
        }
        visitedSet.add(key);
        palinTable(new CustomKey(
                key.topLeftX,key.topLeftY+1,key.bottomRightX,key.bottomRightY
        ));
        palinTable(new CustomKey(
                key.topLeftX+1,key.topLeftY,key.bottomRightX,key.bottomRightY
        ));
        palinTable(new CustomKey(
                key.topLeftX+1,key.topLeftY+1,key.bottomRightX,key.bottomRightY
        ));
        palinTable(new CustomKey(
                key.topLeftX,key.topLeftY,key.bottomRightX,key.bottomRightY-1
        ));
        palinTable(new CustomKey(
                key.topLeftX,key.topLeftY,key.bottomRightX-1,key.bottomRightY
        ));
        palinTable(new CustomKey(
                key.topLeftX,key.topLeftY,key.bottomRightX-1,key.bottomRightY-1
        ));
    }

    private boolean checkBoundary(CustomKey key){
        return key.bottomRightX>=key.topLeftX && key.bottomRightY>=key.topLeftY;
    }

    private int findArea(CustomKey given){
        return (given.bottomRightX-given.topLeftX+1) * (given.bottomRightY-given.topLeftY+1);
    }

    public boolean isPalin(CustomKey cust){
        short count=0;
        int [] countArr = new int[10];
        for (int i = 0; i < countArr.length; i++) {
            countArr[i] = 0;
        }
        for (int i = cust.topLeftX; i <= cust.bottomRightX; i++) {
            for (int j = cust.topLeftY; j <= cust.bottomRightY; j++) {
                countArr[
                        mat[i][j]]++;
            }
        }
        for (int i = 0; i < countArr.length; i++) {
            count += countArr[i] %2 ==0 ? 0 : 1;
        }
        return count<2 && checkZero(countArr);
    }

    private boolean checkZero(int [] arr){
        if(!(arr[0] > 0) || arr[0]==1){
            return true;
        }
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>0 && arr[i]%2==0){
                return true;
            }
        }
        return false;
    }
}