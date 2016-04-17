import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Iterator;
import java.util.Collections;

// https://code.google.com/codejam/contest/32016/dashboard#s=p0
public class MinScalaProd{
  public static void main(String [] args){
    BufferedReader br = null;
    String currentLine = null;
    int n = 0;
    List<Long> listOfStrings = new ArrayList<Long>();
    List<Long> secondList = new ArrayList<Long>();

    List<Long> outputList = new ArrayList<Long>();
    int count=1;
    int prevKey = 0,numTestCase = 0;

    // Reading values from file
    try{

      br = new BufferedReader(new FileReader("/home/sdj/CPPWorkspace/Coding/CodeJamPractice/MinScalarProd/MinScalaProd.in"));
      currentLine = br.readLine();
      n = Integer.parseInt(currentLine);
      int prevKeyCount=0;
      int z = 0;
      long scalarMulti = 0;

      while((currentLine = br.readLine())!=null){
        if(count%3==0){

          listOfStrings = Arrays.asList(currentLine.split("\\s+")).stream().mapToLong(Long::parseLong).boxed().collect(Collectors.toList());
          Collections.sort(secondList);
          Collections.sort(listOfStrings);

          Collections.reverse(listOfStrings);
          scalarMulti = 0;
          z=0;
          for(long x : listOfStrings){
            scalarMulti += (x*secondList.get(z));
            z++;
          }
          // if(count==6){
          //     for(int i:listOfStrings){
          //       System.out.print(i + " ");
          //     }
          //     for(int i:secondList){
          //       System.out.print(i + " ");
          //     }
          //     System.out.println(" " + scalarMulti);
          //     System.out.println(" " + listOfStrings.size() + " " + secondList.size());
          // }
          outputList.add(scalarMulti);
      }else if((count+1)%3==0){
        secondList = Arrays.asList(currentLine.split("\\s+")).stream().mapToLong(Long::parseLong).boxed().collect(Collectors.toList());
      }else if((count+2)%3==0){
        prevKeyCount++;
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

    // Output writing to a file
    count = 1;
    try{
      PrintWriter pw = new PrintWriter(new FileOutputStream("/home/sdj/CPPWorkspace/Coding/CodeJamPractice/MinScalarProd/MinScalaProd.out"));
      for(Long iter:outputList){
            pw.println("Case #"+count+": "+iter );
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
