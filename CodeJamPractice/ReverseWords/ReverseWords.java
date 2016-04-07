import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class ReverseWords{
  public static void main(String [] args){
    BufferedReader br = null;
    String currentLine = null;
    int n = 0;
    List<String> listOfStrings = new ArrayList<String>();

    // Reading values from file
    try{

      br = new BufferedReader(new FileReader("/home/sdj/Coding/CodeJamPractice/ReverseWords/ReverseWords.in"));
      currentLine = br.readLine();
      n = Integer.parseInt(currentLine);
      while((currentLine = br.readLine())!=null){
        listOfStrings.add(currentLine);
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
    String [] arr = null;
    StringBuilder builder = null;
    int count=0;
    for(String iter:listOfStrings){
      arr = iter.split(" ");
       builder = new StringBuilder();
       for(int i=arr.length-1;i>=0;i--){
         builder.append(arr[i] + " ");
       }
       listOfStrings.set(count,builder.toString().trim());
       count++;
    }
    System.out.println("After "+listOfStrings.size());
    count=1;
    // Output writing to a file
    try{
      PrintWriter pw = new PrintWriter(new FileOutputStream("/home/sdj/Coding/CodeJamPractice/ReverseWords/ReverseWords.out"));
      for(String iter:listOfStrings){
        pw.println("Case #"+count+": "+iter);
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
