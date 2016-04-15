import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Iterator;

// https://code.google.com/codejam/contest/dashboard?c=351101#s=p0
public class StoreCredit{
  public static void main(String [] args){
    BufferedReader br = null;
    String currentLine = null;
    int n = 0;
    List<Integer> listOfStrings = new ArrayList<Integer>();
    Map<Integer,Object> listOfObjects = new LinkedHashMap<Integer,Object>();
    List<Integer> requiredCredit = new ArrayList<Integer>();
    int count=1;
    int prevKey = 0,numTestCase = 0;

    // Reading values from file
    try{

      br = new BufferedReader(new FileReader("/home/sdj/CPPWorkspace/Coding/CodeJamPractice/StoreCredit/StoreCredit.in"));
      currentLine = br.readLine();
      n = Integer.parseInt(currentLine);
      int prevKeyCount=0;

      while((currentLine = br.readLine())!=null){
        if(count%3==0){

          listOfStrings = Arrays.asList(currentLine.split("\\s+")).stream().mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
          listOfObjects.put(prevKeyCount,listOfStrings);
      }else if((count+1)%3==0){
        prevKeyCount++;
        // prevKey = Integer.parseInt(currentLine);
      }else if((count+2)%3==0){
        requiredCredit.add(Integer.parseInt(currentLine));
      }
      count++;
    }
  }
    catch(IOException e){
      System.out.println("Exception occured when reading file");
    }finally{
      try{
        if(br!=null){
          br.close();
        }

      }catch(IOException e){
        System.out.println("IOException in finally :( ");
      }
    }


    // Logic goes here
    Iterator itera = listOfObjects.entrySet().iterator();
    List<Integer> iterList = null;

   count = 0;
   itera = listOfObjects.entrySet().iterator();

    iterList = null;
    int currentElement = 0;
    int firstValue=0,secondValu=0;

    listOfStrings=new ArrayList<Integer>();
    Integer firstIter = null;
    Integer secondIter = null;
     while(itera.hasNext()){
    //for(Map.Entry pair:listOfObjects.entrySet()){
      Map.Entry pair = (Map.Entry) itera.next();
      iterList = (ArrayList)(pair.getValue());

      currentElement = requiredCredit.get(count);
      count++;
      for(Integer curr:iterList){

        if(iterList.indexOf(currentElement-curr)!=-1){
          if(iterList.indexOf(currentElement-curr) > iterList.indexOf(curr)){

            firstIter = iterList.indexOf(curr);
            secondIter = iterList.indexOf(currentElement-curr);
          }else{
            if(currentElement-curr == curr){
              firstIter = iterList.indexOf(curr);
              secondIter = iterList.lastIndexOf(curr);
            }
            else{
              firstIter = iterList.indexOf(currentElement-curr);
              secondIter = iterList.indexOf(curr);
            }
          }
          if(firstIter.equals(secondIter)){
            continue;
          }
          listOfStrings.add(firstIter);
          listOfStrings.add(secondIter);
          break;
        }
      }
    }

    // Output writing to a file
    count = 1;
    try{
      PrintWriter pw = new PrintWriter(new FileOutputStream("/home/sdj/CPPWorkspace/Coding/CodeJamPractice/StoreCredit/StoreCredit.out"));
      for(Integer iter:listOfStrings){
        if(count%2==0){
            pw.println("Case #"+count/2+": "+(prevKey+1) + " "+(iter+1));
        }else{
          prevKey = iter;
        }
        count++;
      }
      pw.close();
      System.out.println("Output written to file!"+ count);
    }
    catch(FileNotFoundException e){
      System.out.println("File not found while outputting");
    }

  }

}
