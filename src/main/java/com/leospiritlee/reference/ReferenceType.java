package com.leospiritlee.reference;

/**
 * @Project: CodeSegment
 * @ClassName ReferenceType
 * @description: 形参 实参
 * @author: leospiritlee
 * @create: 2020-04-09 13:11
 **/
public class ReferenceType {

    public void changePoint(Point point){
        point.x = 5;
        point.y = 10;
    }

    public void changeReference(Point point){
        point = null;
    }

    public void testByString(String value){
        value = "test";
    }


    public static void main(String[] args) {
        ReferenceType referenceType = new ReferenceType();

        Point point = new Point(1,2);
        System.out.println("before change point: " + point);

        referenceType.changePoint(point);
        System.out.println("after change point: " + point);

        referenceType.changeReference(point);
        System.out.println("after change reference: " + point);

        String value = "hello";
        System.out.println("before change value: " + value);
        referenceType.testByString(value);
        System.out.println("after change value: " + value);

    }

}


class Point{

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}