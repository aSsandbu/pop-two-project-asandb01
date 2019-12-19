package fraction;

import static org.junit.jupiter.api.Assertions.*;

//This file contains tests for all methods in FractionImpl
class FractionImplTest {

    @org.junit.jupiter.api.Test
    void GCD() {
        assertEquals(24, FractionImpl.GCD(72,-24));
        assertEquals(1, FractionImpl.GCD(12,1));
    }

    //normalize() is tested within constructor tests
    //Constructor test - FractionImpl(int numerator, int denominator)
    @org.junit.jupiter.api.Test
    void FractionImplTwoInt() {
        FractionImpl frac10 = new FractionImpl(3, 2);
        assertEquals(frac10.getNumerator(), 3, "Failed two int constructor test1");
        assertEquals(frac10.getDenominator(), 2);

        FractionImpl frac11 = new FractionImpl(3, -2);
        assertEquals(frac11.getNumerator(), -3, "Failed two int constructor test2 (negative)");
        assertEquals(frac11.getDenominator(), 2);

        FractionImpl frac12 = new FractionImpl(7, 14);
        assertEquals(frac12.getNumerator(), 1, "Failed two int constructor test3 (factoring)");
        assertEquals(frac12.getDenominator(), 2);

        assertThrows(ArithmeticException.class, () -> {
            FractionImpl frac13 = new FractionImpl(2, 0);
        }, "Failed String constructor test4 (zero denominator)");
    }

    //Constructor test - FractionImpl(int wholeNumber)
    @org.junit.jupiter.api.Test
    void FractionImplSingleInt() {
        FractionImpl frac20 = new FractionImpl(4);
        assertEquals(frac20.getNumerator(), 4, "Failed single int constructor test1");
        assertEquals(frac20.getDenominator(), 1);

        FractionImpl frac21 = new FractionImpl(-12);
        assertEquals(frac21.getNumerator(), -12, "Failed single int constructor test2 (negative)");
        assertEquals(frac21.getDenominator(), 1);
    }

    //Constructor test - FractionImpl(String fraction)
    @org.junit.jupiter.api.Test
    void FractionImplString() {
        FractionImpl frac30 = new FractionImpl("2/5");
        assertEquals(frac30.getNumerator(), 2, "Failed String constructor test1");
        assertEquals(frac30.getDenominator(), 5);

        FractionImpl frac31 = new FractionImpl("2/-5");
        assertEquals(frac31.getNumerator(), -2, "Failed String constructor test2 (negative denominator)");
        assertEquals(frac31.getDenominator(), 5);

        FractionImpl frac32 = new FractionImpl("12/-24");
        assertEquals(frac32.getNumerator(), -1, "Failed String constructor test3 (factoring)");
        assertEquals(frac32.getDenominator(), 2);

        FractionImpl frac33 = new FractionImpl("-5");
        assertEquals(frac33.getNumerator(), -5, "Failed String constructor test4 (single digit)");
        assertEquals(frac33.getDenominator(), 1);

        assertThrows(ArithmeticException.class, () -> {
            FractionImpl frac34 = new FractionImpl("1/0");
        }, "Failed String constructor test5 (zero denominator)");

        FractionImpl frac35 = new FractionImpl("  -14  ");
        assertEquals(frac35.getNumerator(), -14, "Failed String constructor test6 (spaces)");
        assertEquals(frac35.getDenominator(), 1);

        FractionImpl frac36 = new FractionImpl("    5/2      ");
        assertEquals(frac36.getNumerator(), 5, "Failed String constructor test7 (tabs)");
        assertEquals(frac36.getDenominator(), 2);
    }


    @org.junit.jupiter.api.Test
    void add() {
        FractionImpl fracAdd1 = new FractionImpl("2/3");
        FractionImpl fracAdd2 = new FractionImpl("3/4");
        FractionImpl fracResult1 = new FractionImpl("17/12");
        assertEquals(fracAdd1.add(fracAdd2), fracResult1, "Failed add test1");

        FractionImpl fracAdd3 = new FractionImpl("4/2");
        FractionImpl fracAdd4 = new FractionImpl("4/2");
        FractionImpl fracResult2 = new FractionImpl("4/1");
        assertEquals(fracAdd3.add(fracAdd4), fracResult2, "Failed add test2 (factoring)");
    }

    @org.junit.jupiter.api.Test
    void subtract() {
        FractionImpl fracSub1 = new FractionImpl("1/1");
        FractionImpl fracSub2 = new FractionImpl("3/4");
        FractionImpl fracResult1 = new FractionImpl("1/4");
        assertEquals(fracSub1.subtract(fracSub2), fracResult1, "Failed subtract test1");

        FractionImpl fracSub3 = new FractionImpl("2/3");
        FractionImpl fracSub4 = new FractionImpl("3/4");
        FractionImpl fracResult2 = new FractionImpl("-1/12");
        assertEquals(fracSub3.subtract(fracSub4), fracResult2, "Failed subtract test2 (negative result)");

        FractionImpl fracSub5 = new FractionImpl("4/2");
        FractionImpl fracSub6 = new FractionImpl("4/2");
        FractionImpl fracResult3 = new FractionImpl("0/1");
        assertEquals(fracSub5.subtract(fracSub6), fracResult3, "Failed subtract test3 (zero result)");
    }

    @org.junit.jupiter.api.Test
    void multiply() {
        FractionImpl fracMul1 = new FractionImpl("2/3");
        FractionImpl fracMul2 = new FractionImpl("3/4");
        FractionImpl fracResult1 = new FractionImpl("1/2");
        assertEquals(fracMul1.multiply(fracMul2), fracResult1, "Failed multiply test1 (factoring)");

        FractionImpl fracMul3 = new FractionImpl("2/3");
        FractionImpl fracMul4 = new FractionImpl("-1/1");
        FractionImpl fracResult2 = new FractionImpl("-2/3");
        assertEquals(fracMul3.multiply(fracMul4), fracResult2, "Failed multiply test2 (negative result)");

        FractionImpl fracMul5 = new FractionImpl("4/2");
        FractionImpl fracMul6 = new FractionImpl("0/1");
        FractionImpl fracResult3 = new FractionImpl("0/1");
        assertEquals(fracMul5.multiply(fracMul6), fracResult3, "Failed multiply test3 (zero result)");
    }

    @org.junit.jupiter.api.Test
    void divide() {
        FractionImpl fracDiv1 = new FractionImpl("2/3");
        FractionImpl fracDiv2 = new FractionImpl("3/4");
        FractionImpl fracResult1 = new FractionImpl("8/9");
        assertEquals(fracDiv1.divide(fracDiv2), fracResult1, "Failed divide test1");

        FractionImpl fracDiv3 = new FractionImpl("2/3");
        FractionImpl fracDiv4 = new FractionImpl("-1/1");
        FractionImpl fracResult2 = new FractionImpl("-2/3");
        assertEquals(fracDiv3.divide(fracDiv4), fracResult2, "Failed divide test2 (negative result)");

        FractionImpl fracDiv5 = new FractionImpl("12/13");
        FractionImpl fracDiv6 = new FractionImpl("6/7");
        FractionImpl fracResult3 = new FractionImpl("13/14");
        assertEquals(fracDiv5.divide(fracDiv6), fracResult3, "Failed divide test3 (zero result)");
    }

    @org.junit.jupiter.api.Test
    void abs() {
        FractionImpl fracAbs1 = new FractionImpl("-2/3");
        FractionImpl fracResult1 = new FractionImpl("2/3");
        assertEquals(fracAbs1.abs(), fracResult1, "Failed abs test1");
    }

    @org.junit.jupiter.api.Test
    void negate() {
        FractionImpl fracNeg1 = new FractionImpl("-2/3");
        FractionImpl fracResult1 = new FractionImpl("2/3");
        assertEquals(fracNeg1.negate(), fracResult1, "Failed negate test1");
        FractionImpl fracNeg2 = new FractionImpl("2/3");
        FractionImpl fracResult2 = new FractionImpl("-2/3");
        assertEquals(fracNeg2.negate(), fracResult2, "Failed negate test2");
    }

    @org.junit.jupiter.api.Test
    void testHashCode() {
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
    }

    @org.junit.jupiter.api.Test
    void testClone() {
    }

    @org.junit.jupiter.api.Test
    void inverse() {
    }

    @org.junit.jupiter.api.Test
    void compareTo() {
    }

    @org.junit.jupiter.api.Test
    void testToString() {
    }
}