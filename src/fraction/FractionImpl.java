package fraction;

public class FractionImpl implements Fraction {
    private int numerator;
    private int denominator;

    //Returns the greatest common factor of two int's, helper for normalize()
    static int GCD(int num1, int num2){
        num1 = Math.abs(num1);
        num2 = Math.abs(num2);
        int result = -1;
        if (num1 > num2) {
            int temp = num2;
            num2 = num1;
            num1 = temp;
        }
        while (result != 0){
            result = num2 % num1;
            num2 = num1;
            num1 = result;
        }
        return result;
        //int div = Math.min(num1, num2);
        //while(div > 1){
        //    if (num1 % div == 0 && num2 % div == 0) return div;
        //    else div--;
        //}
        //return div;
    }

    //normalizes a FractionImpl object, helper method for constructors
    void normalize(){
        int gcd = GCD(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        if (numerator < 0 && denominator < 0) {
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        }
        else if (denominator < 0){
            denominator = Math.abs(denominator);
            numerator = -numerator;
        }
    }

    /**
     * Parameters are the <em>numerator</em> and the <em>denominator</em>.
     * Normalize the fraction as you create it.
     * For instance, if the parameters are <pre>(8, -12)</pre>, create a <pre>Fraction</pre> with numerator
     * <pre>-2</pre> and denominator <pre>3</pre>.
     *
     * The constructor should throw an <pre>ArithmeticException</pre> if the denominator is zero.
     *
     * @param numerator
     * @param denominator
     */
    public FractionImpl(int numerator, int denominator) throws ArithmeticException {
        this.numerator = numerator;
        if (denominator != 0) this.denominator = denominator;
        else throw new ArithmeticException("Divide by zero");
        this.normalize();
    }

    /**
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {
        this.numerator = wholeNumber;
        this.denominator = 1;
    }

    /**
     * The parameter is a <pre>String</pre> containing either a whole number, such as `5` or `-3`, or a fraction,
     * such as "8/-12".
     * Allow blanks around (but not within) integers.
     * The constructor should throw an <pre>ArithmeticException</pre>
     * if given a string representing a fraction whose denominator is zero.
     * <p>
     * You may find it helpful to look at the available String API methods in the Java API.
     *
     * @param fraction the string representation of the fraction
     */
    public FractionImpl(String fraction) throws ArithmeticException {
        fraction = fraction.replaceAll("\\s+",""); //clear spaces, tabs
        if (fraction.length() > 2){
            String[] frac = fraction.split("/");
            this.numerator = Integer.parseInt(frac[0]);
            int denom = Integer.parseInt(frac[1]);
            if (denom != 0) this.denominator = denom;
            else throw new ArithmeticException("Divide by zero");
        }
        else {
            this.numerator = Integer.parseInt(fraction);
            this.denominator = 1;
        }
        this.normalize();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction add(FractionImpl f) {
        //a/b + c/d is (ad + bc)/bd
        int numerator = this.numerator * f.denominator + this.denominator * f.numerator;
        int denominator = this.denominator * f.denominator;
        return new FractionImpl(numerator, denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public FractionImpl subtract(FractionImpl f) {
        //a/b - c/d is (ad - bc)/bd
        int numerator = this.numerator * f.denominator - this.denominator * f.numerator;
        int denominator = this.denominator * f.denominator;
        return new FractionImpl(numerator, denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public FractionImpl multiply(FractionImpl f) {
        //(a/b) * (c/d) is (a*c)/(b*d)
        int numerator = this.numerator * f.numerator;
        int denominator = this.denominator * f.denominator;
        return new FractionImpl(numerator, denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public FractionImpl divide(FractionImpl f) {
        //(a/b) / (c/d) is (a*d)/(b*c)
        int numerator = this.numerator * f.denominator;
        int denominator = this.denominator * f.numerator;
        return new FractionImpl(numerator, denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public FractionImpl abs() {
        return new FractionImpl(Math.abs(this.numerator), Math.abs(this.denominator));
    }

    /**
     * @inheritDoc
     */
    @Override
    public FractionImpl negate() {
        return new FractionImpl(-this.numerator, this.denominator);
    }

    /**
     * @inheritDoc
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass().getName() == "FractionImpl") return super.equals(obj);
        else throw new IllegalArgumentException("Argument supplied not an instance of FractionImpl");
    }

    /**
     * @inheritDoc
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     */
    @Override
    public FractionImpl inverse() {
        FractionImpl result = new FractionImpl(this.denominator, this.numerator);
        result.normalize();
        return result;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(FractionImpl o) {
        double value1 = (double) this.numerator / this.denominator;
        double value2 = (double) o.numerator / o.denominator;
        if (value1 == value2) return 0;
        else if (value1 < value2) return -1;
        else return 1;
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        return String.valueOf(numerator) + "/" + String.valueOf(denominator);
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }
}