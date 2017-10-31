package algorithms;

import java.util.*;

class Point implements Comparable<Point>{
    private final int x,y;
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x != point.x) return false;
        return y == point.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }


    @Override
    public int compareTo(Point o) {
        return Integer.compare(this.getX(),o.getX())!=0 ?
                    Integer.compare(this.getX(),o.getX()) :
                    Integer.compare(this.getY(),o.getY());
    }
}

class ConnectedComponent {
    private final TreeSet<Point> points;
    ConnectedComponent(){
        points = new TreeSet<>();
    }
    ConnectedComponent(TreeSet<Point> given){
        this.points = given;
    }
    public TreeSet<Point> getPoints() {
        return points;
    }

    // Contains uses equals with that assumption writing equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConnectedComponent that = (ConnectedComponent) o;
        Iterator<Point> thisIter = this.points.iterator();
        Iterator<Point> thatIter = that.points.iterator();
        while (thisIter.hasNext() && thatIter.hasNext()){
            if(!thisIter.next().equals(thatIter.next())){
                return false;
            }
        }
        if(thisIter.hasNext() || thatIter.hasNext()){
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return points != null ? points.hashCode() : 0;
    }
}

public class LC_DistinctIsland_711 {
    public static void main(String[] args) {

    }
    public int numDistinctIslands2(int[][] grid) {
        Set<ConnectedComponent> ccSet = new HashSet<>();
        Set<ConnectedComponent> comparePoolSet = new HashSet<>();
        boolean[][] localBool = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < localBool.length; i++) {
            for (int j = 0; j < localBool[i].length; j++) {
                localBool[i][j] = (grid[i][j]==1);
            }
        }

        for (int i = 0; i < localBool.length; i++) {
            for (int j = 0; j < localBool[i].length; j++) {
                if(localBool[i][j]){
                    doDFS(i,j,localBool,ccSet,comparePoolSet);
                }
            }
        }
        return ccSet.size();
    }

    private void doDFS(int i,int j, boolean[][] matrix,
                       Set<ConnectedComponent> ccSet,Set<ConnectedComponent> comparePoolSet){

        Queue<Point> q = new LinkedList<>();
        TreeSet<Point> points = new TreeSet<>();
        Point start = new Point(i,j);
        points.add(start);
        q.add(start);
        while (!q.isEmpty()){
            for(Point p : giveAdjacentPoints(q.poll())){
                if(matrix[p.getX()][p.getY()]){
                    q.add(p);
                    points.add(p);
                    matrix[p.getX()][p.getY()] = false;
                }
            }
        }
        ConnectedComponent consider = new ConnectedComponent(points);
        if(comparePoolSet.contains(moveToOrigin(consider))){
           return;
        }
        ccSet.add(consider);
        addVariants(consider,comparePoolSet);
    }

    private List<Point> giveAdjacentPoints(Point p){
        List<Point> list = new ArrayList<>();
        list.add(new Point(p.getX()-1,p.getY()));
        list.add(new Point(p.getX(),p.getY()-1));
        list.add(new Point(p.getX()+1,p.getY()));
        list.add(new Point(p.getX(),p.getY()+1));
        return list;
    }

    private void addVariants(ConnectedComponent given,Set<ConnectedComponent> comparePoolSet){
        comparePoolSet.add(moveToOrigin(given));
    }

    private ConnectedComponent moveToOrigin(ConnectedComponent given){
        ConnectedComponent result = new ConnectedComponent();
        Point minXY = getMinXMinY(given.getPoints());
        Iterator<Point> iter = given.getPoints().iterator();
        Point p = null;
        while(iter.hasNext()){
            p = iter.next();
            result.getPoints().add(new Point(
                    p.getX()-minXY.getX(),
                    p.getY()-minXY.getX()
            ));
        }
        return result;
    }

    private Point getMinXMinY(TreeSet<Point> givenSet){
        Iterator<Point> iter =givenSet.iterator();
        int x=Integer.MAX_VALUE,y=Integer.MAX_VALUE;
        Point p = null;
        while (iter.hasNext()){
            p = iter.next();
            y = y>p.getY() ? p.getY() : y;
            x = x>p.getX() ? p.getX() : x;
        }
        return new Point(x,y);
    }
}
