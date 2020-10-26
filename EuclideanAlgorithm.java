import java.util.ArrayList;
import java.util.Scanner;

public class EuclideanAlgorithm {
    
    private static void separatorLine(String mode) {
        if(mode.equals("println")) {System.out.println("*********************************************************************\n");}
        if(mode.equals("print")) {System.out.print("*********************************************************************\n");}
        if(mode.equals("extra")) {System.out.print("\n*********************************************************************\n");}
    }
    
    public static void calculateGCD(int num1, int num2) {
        int stepNumber = 1;
        int wholePart;
        int remainder = 42;                                 // 42 is just a random number. Variable "remainder" needs to be initialized and must be greater than 0 in order to enter the while loop.
        int divident = num1 > num2 ? num1 : num2;
        int divisor = num1 < num2 ? num1 : num2;

        ArrayList<Integer> remainderStates = new ArrayList<>();

        System.out.println("\n(" + divident + ", " + divisor + "):\n");

        separatorLine("println");

        while(remainder != 0) {
            
            wholePart = divident / divisor;
            remainder = divident % divisor;

            remainderStates.add(remainder);

            System.out.println((stepNumber++) + ".\t" + divident + " : " + divisor + " = " + wholePart + " * " + divisor + " + " + remainder + "\n");

            if(remainder != 0) {
                divident = divisor;
                divisor = remainder;
            }
        }

        separatorLine("print");

        if(remainderStates.size() > 1) {
            System.out.println("\nGCD = " + remainderStates.get(remainderStates.size() - 2));
        }
        else {
            System.out.println("\nGCD = " + divisor);
        }

        separatorLine("extra");
    }

    public static void main(String[] args) {        
        String num1;
        String num2;
        
        try(Scanner sc = new Scanner(System.in)){        
            while(true) {
                separatorLine("print");                
                System.out.println("If any of the inputs is equal to \"exit\", then the program terminates.");
                    
                System.out.print("\n#1: ");
                num1 = sc.next();
    
                if(num1.equals("exit")) {System.exit(0);}
        
                System.out.print("#2: ");
                num2 = sc.next();
    
                if(num2.equals("exit")) {System.exit(0);}
        
                separatorLine("extra");            
                    
                calculateGCD(Math.abs(Integer.parseInt(num1)), Math.abs(Integer.parseInt(num2)));
            }
        }
        catch(ArithmeticException a) {
            a.printStackTrace();
        }
        catch(NumberFormatException n) {
            System.err.println("Invalid input. The input must be an integer and it's value must be between " + Integer.MIN_VALUE + " and " + Integer.MAX_VALUE + ".\n");
            n.printStackTrace();
        }
    }
}