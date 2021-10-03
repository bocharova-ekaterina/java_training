package exercise_2;

public class Point {
    public double x;
    public double y;

    //кнструктор
    public Point(double x, double y) {
       this.x=x;
       this.y=y;
    }
    // первый аргумент метода заменен на this
    public double distance(Point point_2){
        return Math.sqrt((point_2.x-this.x)*(point_2.x-this.x) + (point_2.y-this.y)*(point_2.y-this.y));
    }
}
