import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;
import java.util.List;

public class NonDecreasing {

    /**
     * Take a rectangular grid of numbers and find the length
     * of the longest sub-sequence.
     * @return the length as an integer.
     *
     * Question: http://stackoverflow.com/questions/39681758/longest-sub-sequence-in-a-matrix
     */
    public static int longestSequence(int[][] grid) {
        int longest = 0;
        int oldLong = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                oldLong = longestPathFinder(i,j,grid,0,new ArrayList<>());
                longest = oldLong>longest?oldLong:longest;
            }
        }
        return longest+1;
    }

    public static int longestPathFinder(int i,int j,int [][] grid,int pathLen,
                                 List<String> pathArr){
        int x = i-1;
        int y = j-1;
        int yStart = j-1;
        if(i==0){
            x=0;
        }if(j==0){
            yStart = 0;
            y = 0;
        }

        pathArr.add(Integer.toString(i)+","+Integer.toString(j));
        int oldPath = 0;
        // identifying corners
        for(;x<=i+1 ;x++){
            if((x==grid.length) ){
                continue;
            }
            for(y=yStart;y<=j+1;y++){
                if((x==i && y==j) || (y==grid[0].length)
                        || pathArr.contains(Integer.toString(x)+"," + Integer.toString(y))){
                    continue;
                }
                if(Math.abs(grid[x][y]-grid[i][j]) > 3){
                    int foundLen = longestPathFinder(x,y,grid,1,pathArr);
                    oldPath = (oldPath>foundLen)?oldPath:foundLen;
                }
            }
        }
        pathArr.remove(Integer.toString(i)+","+Integer.toString(j));
        return oldPath+pathLen;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numRows = 0;
        int numCols = 0;
        String[] firstLine = reader.readLine().split("\\s+");
        numRows = Integer.parseInt(firstLine[0]);
        numCols = Integer.parseInt(firstLine[1]);

        int[][] grid = new int[numRows][numCols];

        for (int row = 0; row < numRows; row++) {
            String[] inputRow = reader.readLine().split("\\s+");

            for (int col = 0; col < numCols; col++) {
                grid[row][col] = Integer.parseInt(inputRow[col]);
            }
        }
        int length = longestSequence(grid);
        System.out.println(length);
    }
}

