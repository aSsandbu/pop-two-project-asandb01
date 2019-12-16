package fraction;

import static org.junit.jupiter.api.Assertions.*;

//This file contains tests for all methods in FractionImpl
class FractionImplTest {

    @org.junit.jupiter.api.Test
    void power() {
        assertEquals(24, FractionImpl.GCF(72,-24));
    }

    @org.junit.jupiter.api.Test
    void GCF() {
        assertEquals(24, FractionImpl.GCF(72,-24));
        assertEquals(1, FractionImpl.GCF(12,1));
    }

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

        try {
            FractionImpl frac13 = new FractionImpl(2, 0);
            assertEquals(frac13.getNumerator(), 2, "Failed two int constructor test4 (zero denominator)");
        }
        catch (ArithmeticException e){
            System.out.println("ArithmeticException caught successfully!");
            assertTrue(true);
        }
    }

    //Constructor test - FractionImpl(int wholeNumber)
    @org.junit.jupiter.api.Test
    void FractionImplSingleInt() {
        FractionImpl frac20 = new FractionImpl(4);
        assertEquals(frac20.getNumerator(), 4, "Failed single int constructor test1");
        assertEquals(frac20.getDenominator(), 1);

        FractionImpl frac21 = new FractionImpl(-4);
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


    }

    @org.junit.jupiter.api.Test
    void add() {
    }

    @org.junit.jupiter.api.Test
    void subtract() {
    }

    @org.junit.jupiter.api.Test
    void multiply() {
    }

    @org.junit.jupiter.api.Test
    void divide() {
    }

    @org.junit.jupiter.api.Test
    void abs() {
    }

    @org.junit.jupiter.api.Test
    void negate() {
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