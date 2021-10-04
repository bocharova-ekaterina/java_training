package ru.stqa.pft.sandbox;
import org.testng.Assert;
import org.testng.annotations.Test;
import exercise_2.*;

@Test
public class PointTests {

    public void testDistanceNotZeroPoints(){
        Point p1 = new Point(42.5, 20.86);
        Point p2 = new Point(100.0, 99.99);
        Assert.assertEquals(p1.distance(p2), 97.81516702434239);
    }

    public void testDistanceOneZeroPoint(){
      Point p1 = new Point(0.0, 0.0);
      Point p2 = new Point(20.0, 40.0);
      Assert.assertEquals(p1.distance(p2), 44.721359549995796);
    }

    public void testDistanceNegativePoints(){
       Point p1 = new Point(-5, -10);
       Point p2 = new Point(-20, -30);
       Assert.assertEquals(p1.distance(p2), 25);

    }
}
