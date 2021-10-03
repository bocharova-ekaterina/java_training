package exercise_2;

public class Distance {

    public static double distance(Point p1, Point p2){
        return Math.sqrt((p2.x-p1.x)*(p2.x-p1.x) + (p2.y-p1.y)*(p2.y-p1.y));
    }

    public static void main (String [] args){
        Point point_1 = new Point(5, 10); // создали первую точку
        Point point_2 = new Point(20, 30); // создали вторую точку
        System.out.println("Расстояние между точками с координатами ("+point_1.x+"; "+point_1.y+") и ("+point_2.x+"; "+point_2.y+") равно "+distance(point_1, point_2));
    }
}
