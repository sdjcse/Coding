import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
 
public class CastleGate{
  public static void main(String [] args){
    Scanner inp = new Scanner(System.in);
    int n = inp.nextInt();
    List<Integer> inList = new ArrayList<Integer>();
 
    for(int i=0;i<n;i++){
      inList.add(inp.nextInt());
    }
    CastleGate cg = new CastleGate();
 
    for(Integer j:inList){
      System.out.println(cg.numberOfPairsInList(j));
    }
  }
 
  public boolean isExorGreaterThanN(int a, int b, int n){
    return n >= (a^b);
  }
 
  public int numberOfPairsInList(int n){
    int count = 0;
    for(int i=n;i>0;i--){
      for(int j=i-1;j>0;j--){
        if(isExorGreaterThanN(i,j,n)){
          count++;
        }
      }
    }
    return count;
  }
}
