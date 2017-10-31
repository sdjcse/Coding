package algorithms;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

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

class ConnectecComponent {
    private final Set<Point> points;
    ConnectecComponent(){
        points = new TreeSet<>();
    }
    public Set<Point> getPoints() {
        return points;
    }

    // Contains uses equals with that assumption writing equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConnectecComponent that = (ConnectecComponent) o;
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
    public int numDistinctIslands2(int[][] grid) {
        int size = 0;
        return size;
    }
}
