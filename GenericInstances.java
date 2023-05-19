
import java.util.*;

interface DataType<T>{
 void addition(T a, T b);
 void subtraction(T a, T b);
 void multiplication(T a, T b);
 void division(T a, T b);	
}

/*
Write the implementation of the NumericDataType and StringDataType generic classes.
*/

class StringDataType<T> implements DataType<T> {
    
    public void addition(T a, T b) {
        System.out.println("Adding two strings");
        System.out.printf("The result is: %s\n", a.toString() + b.toString());
    }
    
    public void subtraction(T a, T b) {
        System.out.println("Can't perform this operation on strings");
    }
    
    public void multiplication(T a, T b) {
       System.out.println("Can't perform this operation on strings");
    }
    
    public void division(T a, T b) {
        System.out.println("Can't perform this operation on strings");
    }
    
    public void performAll(T a, T b) {
        addition(a, b);
        subtraction(a, b);
        multiplication(a, b);
        division(a, b);
    }
    
}

class NumericDataType<T> implements DataType<T> {
    
    public void addition(T a, T b) {
        System.out.println("Adding 2 generic instances");
        // A way to compile and run correctly if <T> for class generic.
        Number op = ((Number)a).doubleValue() + ((Number)b).doubleValue();
        System.out.printf("The result is: %.2f\n", op);
    }
    
    public void subtraction(T a, T b) {
        System.out.println("Subtracting two generic instances");
        Number op = ((Number)a).doubleValue() - ((Number)b).doubleValue();
        System.out.printf("The result is: %.2f\n", op);
    }
    
    public void multiplication(T a, T b) {
       System.out.println("Multiplying two generic instances"); 
       Number op = ((Number)a).doubleValue()*((Number)b).doubleValue();
       System.out.printf("The result is: %.2f\n", op);
    }
    
    public void division(T a, T b) {
        System.out.println("Dividing two generic instances");
        Number op = ((Number)a).doubleValue()/((Number)b).doubleValue();
        System.out.printf("The result is: %.2f\n", op);
    }
    
    public void performAll(T a, T b) {
        addition(a, b);
        subtraction(a, b);
        multiplication(a, b);
        division(a, b);
    }
    
}