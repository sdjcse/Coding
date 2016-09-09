import java.util.*;

public class ListManip {

    public static void main(String[] args) {
        Scanner inpObj = new Scanner(System.in);
        long n = inpObj.nextLong();
        boolean flag = false;
        List<Long> numList = new ArrayList<>();
        for(;inpObj.hasNext();){
            numList.add(inpObj.nextLong());
            if(numList.size()>n){
                numList.remove(0);
                flag = true;
            }
        }

        if(flag){
            System.out.println(numList.get(0));
        }else{
            System.out.println("NIL");
        }
    }
}
