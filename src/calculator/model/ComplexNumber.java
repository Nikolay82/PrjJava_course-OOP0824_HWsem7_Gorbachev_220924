package calculator.model;

import static java.lang.Math.pow;

public class ComplexNumber {
    private double real, imaginary;

    public ComplexNumber() {

    }
    public ComplexNumber(double real, double imaginary)
    {
        this.real = real;
        this.imaginary = imaginary;
    }

    public static ComplexNumber addition(ComplexNumber cn1, ComplexNumber cn2)
    {
        ComplexNumber temp = new ComplexNumber();
        temp.real = cn1.real + cn2.real;
        temp.imaginary = cn1.imaginary + cn2.imaginary;
        return temp;
    }

    public static ComplexNumber subtraction(ComplexNumber cn1, ComplexNumber cn2)
    {
        ComplexNumber temp = new ComplexNumber();
        temp.real = cn1.real - cn2.real;
        temp.imaginary = cn1.imaginary - cn2.imaginary;
        return temp;
    }

    public static ComplexNumber multiplication(ComplexNumber cn1, ComplexNumber cn2) {
        ComplexNumber temp = new ComplexNumber();
        temp.real = cn1.real * cn2.real - cn1.imaginary * cn2.imaginary;
        temp.imaginary = cn1.real * cn2.imaginary + cn1.imaginary * cn2.real;
        return temp;
    }

    public static ComplexNumber division(ComplexNumber cn1, ComplexNumber cn2) {
        ComplexNumber temp = new ComplexNumber();
        temp.real = (cn1.real * cn2.real + cn1.imaginary * cn2.imaginary) / (pow(cn2.real, 2) + pow(cn2.imaginary, 2));
        temp.imaginary = (cn1.imaginary * cn2.real - cn1.real * cn2.imaginary) / (pow(cn2.real, 2) + pow(cn2.imaginary, 2));
        return temp;
    }

    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }
}
