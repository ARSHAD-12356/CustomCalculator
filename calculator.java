import java.util.Scanner;

/**
 * calculator
 */
/*
 * Problem Statement: -- you have to create custom calculator with following operations
 * 1> + -> Addition
 * 2> - -> Subtraction
 * 3> * -> Multiplication
 * 4> - -> Division
 * which throws the following exceptions:
 * 1> Invalid input Exception (eg: 8 & 9)
 * 2> Cannot divide by 0 exception
 * 3> Max input Exception if any one of the input is greater than 100000
 * 4> Max multiplier reached exception (don't allow any multiplication input to be greater than 7000)
 */
class invalidOperatorException extends Exception{
    @Override
    public String toString() {
        return "Please take a valid operator";
    };
}
class CannotDivideby0Exception extends Exception{
    @Override
    public String toString() {
        return "Sorry, we can't divide at this moment (cannot divide by 0)";
    };
}
class MaxInputException extends Exception{
    @Override
    public String toString() {
        return "Please try to take input less than 100000";
    };
}
class MaxMultiplierException extends Exception{
    @Override
    public String toString() {
        return "You can't allow multiplication grater than 7000";
    };
}

public class calculator {
    public static float cal (float a, char c , float b ) throws invalidOperatorException, CannotDivideby0Exception ,MaxInputException,MaxMultiplierException {
    
        // if (c== '+' && c=='-' && c=='*' && c=='/') {
        //     System.out.println("Great, it is a valid input");
        //     Scanner ds = new Scanner(System.in);
        //     System.out.println("Enter the second operand");
        //      b = ds.nextFloat();
        // }
         if (c!= '+' && c!='-' && c!='*' && c!='/') {
            throw new invalidOperatorException();
        }
        else if(b==0){
            throw new CannotDivideby0Exception();
        }else if(a>100000 || b>100000){
            throw new MaxInputException();
        }
        switch (c) {
        case '+':
               return a+b;
        case '-':
            return a-b;
        case '*':
        if (a>7000 || b>7000) {
            throw new MaxMultiplierException();
        }
        return a*b;
        case '/':
        return a/b;
        default:
        throw new invalidOperatorException();
        }
    }


    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("---------Calculator---------");
            System.out.println("Enter the first operand");
            float a = sc.nextFloat();
            System.out.println("Enter the operator: \n+ , - , * , / ?");
            char c = sc.next().charAt(0);
            System.out.println("Enter the second operand");
            float b = sc.nextFloat();
            float result = cal(a, c,b);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
