package oop;

import org.junit.Test;

import java.nio.channels.Pipe;

import static org.junit.Assert.*;

public class PointTest {

    @Test
    public void whenThis01Another20ThenDistance2Point23() {
        Point a = new Point(0, 1);
        Point b = new Point(2, 0);
        double result = a.distance(b);
        double expected = 2.23606797749979;
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void whenThis25Another35ThenDistance1() {
        Point a = new Point(2, 5);
        Point b = new Point(3, 5);
        double result = a.distance(b);
        double expected = 1;
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void whenThis1Point55point3Another28ThenDistance2Point74() {
        Point a = new Point(1.5, 5.3);
        Point b = new Point(2, 8);
        double result = a.distance(b);
        double expected = 2.7459060435491964;
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void whenThisMinus2Minus5AnotherMinus5Minus7ThenDistance3Point60() {
        Point a = new Point(-2, -5);
        Point b = new Point(-5, -7);
        double result = a.distance(b);
        double expected = 3.605551275463989;
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void whenThisPoint568Another124ThenDistance6Point93() {
        Point a = new Point(5, 6, 8);
        Point b = new Point(1, 2, 4);
        double result = a.distance3d(b);
        double expected = 6.93;
        assertEquals(expected, result, 0.01);
    }

    @Test
    public void whenThisPointMinus2Minus5Minus3Point4AnotherMinus2Point1Minus3Minus7ThenDistance4Point12() {
        Point a = new Point(-2, -5, -3.4);
        Point b = new Point(-2.1, -3, -7);
        double result = a.distance3d(b);
        double expected = 4.12;
        assertEquals(expected, result, 0.01);
    }
}