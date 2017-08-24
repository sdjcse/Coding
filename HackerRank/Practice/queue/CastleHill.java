package queue;

import java.util.*;

/*
https://www.hackerrank.com/challenges/castle-on-the-grid
* */
class Point{
    int x,y;

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Point o = (Point) obj;
        return this.x == o.x && this.y == o.y;
    }

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class QueueDS{
    Point p;
    Integer i;
    QueueDS(Point p,Integer i){
        this.p = p;
        this.i = i;
    }
}

public class CastleHill {
    static Map<Point,Integer> points = new HashMap<>();
    static Map<Integer,Point> intPoints = new HashMap<>();
    static boolean [][] adjacencyMat = null;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] grid = new String[n];
        for(int grid_i = 0; grid_i < n; grid_i++){
            grid[grid_i] = in.next();
        }
        int startX = in.nextInt();
        int startY = in.nextInt();
        int goalX = in.nextInt();
        int goalY = in.nextInt();
        int result = minimumMoves(grid, startX, startY, goalX, goalY);
        System.out.println(result-1);
        in.close();
    }

    static int minimumMoves(String[] grid, int startX, int startY, int goalX, int goalY) {
        int count = 0;

        // Mapping points to indices
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if(grid[i].charAt(j) == '.'){
                    points.put(new Point(
                            i,j
                    ),count);
                    intPoints.put(count,new Point(i,j));
                    count++;
                }
            }
        }
        adjacencyMat = new boolean[points.size()][points.size()];

        // Generating adjecency matrix
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if(grid[i].charAt(j)!='x'){
                    fillInSideWays(i,j,adjacencyMat,grid);
                }
            }
        }
        return findPathLen(
                new Point(startX,startY),
                new Point(goalX,goalY)
        );
    }

    private static int findPathLen(Point p1, Point p2){
        PriorityQueue<QueueDS> pQueue = new PriorityQueue<>(10, new QueueDSComparator());
        Set<Point> visitedSet = new HashSet<>();
        int index = points.get(p1);
        int count = 1;
        pQueue.add( new QueueDS(
                p1,1
        ));
        visitedSet.add(p1);
        while(!pQueue.isEmpty()){
            QueueDS temp =pQueue.poll();
            index = points.get(temp.p);
            count = temp.i;
            ++count;
            for (int i = 0; i < points.size(); i++) {
                if(intPoints.get(i).equals(p2) && adjacencyMat[index][i]){
                    return count;
                }
                if(adjacencyMat[index][i] && !visitedSet.contains(intPoints.get(i))){
                    visitedSet.add(intPoints.get(i));
                    pQueue.add(
                            new QueueDS(
                                    intPoints.get(i),count
                            )
                    );
                }
            }
        }
        return 0;
    }

    private static void fillInSideWays(int x,int y,boolean[][] adjacencyMat,String [] grid){
        // downward
        for (int i = x+1; i < grid.length; i++) {
            if(grid[i].charAt(y)=='x'){
                break;
            }
            adjacencyMat[points.get(new Point(x,y))][points.get(new Point(i,y))] = true;
        }
        // upward
        for (int i = x-1; i >= 0; i--) {
            if(grid[i].charAt(y)=='x'){
                break;
            }
            adjacencyMat[points.get(new Point(x,y))][points.get(new Point(i,y))] = true;
        }

        // right
        for (int i = y+1; i < grid.length; i++) {
            if(grid[x].charAt(i)=='x'){
                break;
            }
            adjacencyMat[points.get(new Point(x,y))][points.get(new Point(x,i))] = true;
        }
        // left
        for (int i = y-1; i >= 0; i--) {
            if(grid[x].charAt(i)=='x'){
                break;
            }
            adjacencyMat[points.get(new Point(x,y))][points.get(new Point(x,i))] = true;
        }
    }

}

class QueueDSComparator implements  Comparator<QueueDS>{
    @Override
    public int compare(QueueDS o1, QueueDS o2) {
        return o2.i - o1.i;
    }
}
