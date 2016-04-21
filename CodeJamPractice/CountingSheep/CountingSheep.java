import java.util.List;
import java.util.Collections;
import java.util.ArrayList;
import java.lang.Math;
import java.util.Arrays;

// https://code.google.com/codejam/contest/6254486/dashboard
public class CountingSheep{

  public static void main(String [] args){
    List<Long> listNew = new CSInput().inputFromFile();
    List<Long> manipList = new CountingSheep().countTheSheeps(listNew);
    new CSOutput().outPutToFile(manipList);
  }

  public List<Long> countTheSheeps(List<Long> listNew){
    List<Long> returnList = new ArrayList<Long>();
    List<Boolean> assertList = Arrays.asList(new Boolean[10]);

    Collections.fill(assertList,Boolean.FALSE);
    long j=0;
    for(Long i:listNew){
      if(i==0){
        returnList.add(0L);
        continue;
      }
      j=i;
      for(long z=1;!isAllTrue(assertList);){
        j=z*i;
        fillBoolList(j,assertList);
        z++;
      }
      returnList.add(j);
      Collections.fill(assertList,Boolean.FALSE);
    }
    return returnList;
  }

  private void fillBoolList(Long n, List<Boolean> boolList){
    int presentNum = 0;
    while(n>=10){
      presentNum = Math.toIntExact(n%10L);
      n = n/10L;
      boolList.set(presentNum,Boolean.TRUE);
    }
    presentNum = Math.toIntExact(n%10L);
    boolList.set(presentNum,Boolean.TRUE);
  }

  private boolean isAllTrue(List<Boolean> boolList){
    boolean bool = true;
    for(boolean i:boolList){
      bool = bool & i;
    }
    return bool;
  }

}
