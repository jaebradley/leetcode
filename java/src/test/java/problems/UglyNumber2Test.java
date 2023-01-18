package problems;

import org.junit.Test;

import static org.junit.Assert.*;

public class UglyNumber2Test {
    @Test
    public void test1IsFirstUglyNumber() {
        assertEquals(1, new UglyNumber2().nthUglyNumber(1));
    }

    @Test
    public void test2IsSecondUglyNumber() {
        assertEquals(2, new UglyNumber2().nthUglyNumber(2));
    }


    @Test
    public void test3IsThirdUglyNumber() {
        assertEquals(3, new UglyNumber2().nthUglyNumber(3));
    }

    @Test
    public void test4IsFourthUglyNumber() {
        assertEquals(4, new UglyNumber2().nthUglyNumber(4));
    }

    @Test
    public void test5IsFifthUglyNumber() {
        assertEquals(5, new UglyNumber2().nthUglyNumber(5));
    }

    @Test
    public void test6IsSixthUglyNumber() {
        assertEquals(6, new UglyNumber2().nthUglyNumber(6));
    }

    @Test
    public void test8IsSeventhUglyNumber() {
        assertEquals(8, new UglyNumber2().nthUglyNumber(7));
    }

    @Test
    public void test9IsEighthUglyNumber() {
        assertEquals(9, new UglyNumber2().nthUglyNumber(8));
    }

    @Test
    public void test10IsNinthUglyNumber() {
        assertEquals(10, new UglyNumber2().nthUglyNumber(9));
    }

    @Test
    public void test12IsTenthUglyNumber() {
        assertEquals(12, new UglyNumber2().nthUglyNumber(10));
    }
}