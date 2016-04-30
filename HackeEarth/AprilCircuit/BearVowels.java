/* IMPORTANT: Multiple classes and nested static classes are supported */

// https://www.hackerearth.com/april-circuits/algorithm/circ-bear-and-vowels-2/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Character;

class BearVowels {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputList = new ArrayList<String>();
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
          line = br.readLine();
          inputList.add(line);
        }

        List<String> outputList = new BearVowels().computeDifficulty(inputList);
        // System.out.println(outputList.size());
        for(String iter:outputList){
          System.out.println(iter);
        }
    }


    public List<String> computeDifficulty(List<String> inputList){
      List<String> difficultyOutput = new ArrayList<String>();

      difficultyOutput = computeVowelStrength(inputList);
      difficultyOutput = consecutiveConsonants(inputList,difficultyOutput);
      return difficultyOutput;
    }

    public List<String> consecutiveConsonants(List<String> inputList,List<String> difficultyOutput){
      String s = null;
      for(int y=0;y<inputList.size();y++){
        s = inputList.get(y);
        for(int x=0;x<(s.length()-2);x++){
          if(
          (!isVowel((int)s.charAt(x))) &&
          (!isVowel((int)s.charAt(x+1))) &&
          (!isVowel((int)s.charAt(x+2)))
          ){
            difficultyOutput.remove(y);
            difficultyOutput.add(y,"hard");
            break;
          }
        }
      }
      return difficultyOutput;
    }

    public boolean isVowel(int n){
      return (n == 97 || n==(97+4) || n==(97+8) || n==(97+14) || n==(97+20) || n==(97+24));
    }
    public List<String> computeVowelStrength(List<String> inputList){
      Integer[] dummyData = new Integer[26];
      Arrays.fill(dummyData,new Integer(0));
      List<String> outputList = new ArrayList<String>();

      List<Integer> charList = null;
      char literal;
      int literalAscii = 0;
      Integer worker = 0;
      int vowelCount = 0;
      int consonantCount = 0;
      int iterPoint = 0;
      for(String s:inputList){

        charList = Arrays.asList(dummyData);
        Arrays.fill(dummyData,new Integer(0));
        // Count NUmber of literals

        for(int i=0;i<s.length();i++){
          literal = s.charAt(i);

          literalAscii = (int) literal;

          if(literalAscii >= 97 && literalAscii<=122){
            iterPoint = (literalAscii-'a');
            dummyData[iterPoint]++;
          }
        }

        vowelCount = 0;
        consonantCount = 0;

        // compute if its easy or hard
        for(int z=0;z<dummyData.length;z++){
          if(z==0 || z==4 || z==8 || z==14 || z==20 || z==24){
            vowelCount+=dummyData[z];
          }else
          {
            consonantCount+=dummyData[z];
          }
        }

        if(vowelCount<consonantCount){
          outputList.add("hard");
        }else{
          outputList.add("easy");
        }
      }

      return outputList;
    }
}
