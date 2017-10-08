package algorithms;

import java.util.*;

public class LC_CutTrees_675 {
    static int[][] dir = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) {
        System.out.println(
                new LC_CutTrees_675().cutOffTree(getArr())
        );
    }


    static List<List<Integer>> getListArr(int [][] num){
        List<List<Integer>> number = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            List<Integer> inner = new ArrayList<>();
            for (int j = 0; j < num[0].length; j++) {
                inner.add(num[i][j]);
            }
            number.add(inner);
        }
        return number;
    }
    static List<List<Integer>> getArr(){
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        inner.add(1);
        inner.add(2);
        inner.add(3);
        arr.add(inner);
        inner = new ArrayList<>();
        inner.add(0);
        inner.add(0);
        inner.add(4);
        arr.add(inner);
        inner = new ArrayList<>();
        inner.add(7);
        inner.add(6);
        inner.add(5);
        arr.add(inner);
        return arr;
    }
    public int cutOffTree(List<List<Integer>> forest) {
        if(forest==null || forest.size()==0 || forest.get(0).get(0)==0){
            return -1;
        }
        int step = 0;
        int row = forest.size(),column = forest.get(0).size();
        int start[] = new int[]{0,0};
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[2]-b[2]);
        for (int i = 0; i < forest.size(); i++) {
            for (int j = 0; j < forest.get(i).size(); j++) {
                if(forest.get(i).get(j)>1){
                    queue.add(new int[]{
                            i,j,forest.get(i).get(j)
                    });
                }
            }
        }
        int current;
        int currArr[];
        while (!queue.isEmpty()){
            currArr = queue.poll();
            current = nextStepCount(forest,currArr,start,row,column);
            if(current<0){
                return -1;
            }
            start[0] = currArr[0];
            start[1] = currArr[1];
            step += current;
        }

        return step;
    }

    private int nextStepCount(List<List<Integer>> forest, int[] current,int[] starting,int rowNum,int colNum){
        int counter = 0;
        Queue<int[]> innerQueue = new LinkedList<>();
        innerQueue.add(starting);
        boolean visited[][] = new boolean[rowNum][colNum];
        int innerRunner = 0;
        int [] walker;
        while (!innerQueue.isEmpty()){
            innerRunner = innerQueue.size();
            for(int i=0;i<innerRunner;i++){
                walker = innerQueue.poll();
                if(walker[0]==current[0] && walker[1]==current[1]){
                    return counter;
                }
                for(int[] unit:dir){
                    int oneStepRow = walker[0] + unit[0];
                    int oneStepCol = walker[1] + unit[1];
                    if(oneStepRow <0 || oneStepCol<0 || oneStepRow>=rowNum || oneStepCol>=colNum
                            || forest.get(oneStepRow).get(oneStepCol) ==0 || visited[oneStepRow][oneStepCol]){
                        continue;
                    }
                    visited[oneStepRow][oneStepCol] = true;
                    innerQueue.add(new int[]{oneStepRow,oneStepCol});
                }
            }
            counter++;
        }
        return -1;
    }

}
