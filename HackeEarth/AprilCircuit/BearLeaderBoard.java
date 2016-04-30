/* IMPORTANT: Multiple classes and nested static classes are supported */

// https://www.hackerearth.com/april-circuits/algorithm/circ-bear-and-leaderboard-1/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Character;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collections;

class BearLeaderBoard {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Long,Long> inputMap = new TreeMap<Long,Long>();
        List<Long> outputList = new ArrayList<Long>();
        BearLeaderBoard stub = new BearLeaderBoard();
        String line = br.readLine();
        String []firstLine = line.split(" ");
        Long pos=0L,value=0L;
        long N = Long.parseLong(firstLine[0]);
        long q = Long.parseLong(firstLine[1]);
        long accumulate = 0L;
        for (long i = 0L; i < q; i++) {
          line = br.readLine();
          firstLine = line.split(" ");
          pos = Long.parseLong(firstLine[0]);
          value = Long.parseLong(firstLine[1]);
          if(inputMap.containsKey(pos)){
            accumulate = inputMap.get(pos);
            value += accumulate;
          }
          inputMap.put(pos,value);
          outputList.add(stub.computeLeaderSum(inputMap));
        }

        inputMap.clear();
        // System.out.prlongln(inputMap.size());

        for(Long i : outputList){
          System.out.println(i);
        }

    }

    public long computeLeaderSum(Map<Long,Long> inputMap){
      List<Long> scoreList = new ArrayList<Long>(inputMap.values());
        Collections.sort(scoreList);
        long rank = 1;
        long prevValue = 0;
        long sum = 0;
        for(int z=scoreList.size()-1;z>=0;z--){
          if(z==scoreList.size()-1){
            prevValue = scoreList.get(z);
            rank = 1;
            sum += (rank*prevValue);
            continue;
          }
          if(prevValue != scoreList.get(z)){
            rank = scoreList.size()-z;
          }
          sum += (rank*scoreList.get(z));
          prevValue = scoreList.get(z);
        }

        return sum;
    }
}
