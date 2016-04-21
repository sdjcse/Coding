import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

public class CSInput{
  public List<Long> inputFromFile(){
    BufferedReader br = null;
    String currentLine = null;
    int n = 0;
    List<Long> listOfInput = new ArrayList<Long>();

    int count=1;

    // Reading values from file
    try{

      br = new BufferedReader(new FileReader("/home/sdj/CPPWorkspace/Coding/CodeJamPractice/CountingSheep/CountingSheep.in"));
      currentLine = br.readLine();
      n = Integer.parseInt(currentLine);

      while((currentLine = br.readLine())!=null){
        listOfInput.add(Long.parseLong(currentLine));
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

    return listOfInput;
  }

}
