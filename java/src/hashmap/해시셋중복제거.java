package hashmap;

import java.util.HashSet;
import java.util.Objects;

public class 해시셋중복제거 {

    public static void main(String[] args){
        HashSet<Point> set=new HashSet<>();
        set.add(new Point(1, 1));
        set.add(new Point(2, 2));
        set.add(new Point(1, 1));
        set.add(new Point(3, 3));
        for(Point p:set){
            p.print();
        }
    }

    static class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            return ((Point)obj).x==this.x && ((Point)obj).y==this.y;
        }

        //equals뿐만아니라 hashCode도 해줘야한다.
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        void print() {
            System.out.println("["+this.x+","+this.y+"]");
        }
    }
}
