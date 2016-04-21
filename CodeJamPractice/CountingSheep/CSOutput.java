import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CSOutput{
  public void outPutToFile(List<Long> outputList){
    // Output writing to a file
    int count = 1;
    try{
      PrintWriter pw = new PrintWriter(new FileOutputStream("/home/sdj/CPPWorkspace/Coding/CodeJamPractice/CountingSheep/CountingSheep.out"));
      for(Long iter:outputList){
        if(iter==0){
          pw.println("Case #"+count+": INSOMNIA" );
          count++;
          continue;
        }
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
