import java.awt.*;

public class CallByValueExample {
    public static void change(Point a) {
        a = new Point(5,5);
    }
    public static void main(String[] args) {
        Point p = new Point(1,1);
        change(p);
        System.out.println("x=" + p.x + ";y=" + p.y);


        int[] a = new int[100];
        a[0] = 13;
        a[1] = 26;
        System.out.print(a.length);
        a[99] = 23; //??
    }
}