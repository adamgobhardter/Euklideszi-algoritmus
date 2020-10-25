import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EuclideanAlgorithm {
    
    public static void calculateGCD(int num1, int num2) {
        int stepNumber = 1;
        int remainder = 42;                                 // 42 is just a random number. Variable "remainder" needs to be initialized and must be greater than 0 in order to enter the while loop.
        int divident = num1 > num2 ? num1 : num2;
        int divisor = num1 < num2 ? num1 : num2;

        ArrayList<Integer> remainderStates = new ArrayList<>();

        System.out.println("(" + divident + ", " + divisor + "):\n");

        System.out.print("**************************************************\n\n");

        while(remainder != 0) {
            
            int wholePart = divident / divisor;
            remainder = divident % divisor;

            remainderStates.add(remainder);

            System.out.println((stepNumber++) + ".\t" + divident + " : " + divisor + " = " + wholePart + " * " + divisor + " + " + remainder + "\n");

            if(remainder != 0) {
                divident = divisor;
                divisor = remainder;
            }
        }

        System.out.print("**************************************************\n");

        if(remainderStates.size() > 1) {
            System.out.println("\nGCD = " + remainderStates.get(remainderStates.size() - 2));
        }
        else {
            System.out.println("\nGCD = " + divisor);
        }

        System.out.print("\n**************************************************\n");
    }

    public static void main(String[] args) {        
        try(Scanner sc = new Scanner(System.in)){        
            System.out.print("**************************************************\n");
            
            System.out.print("\n#1: ");
            int num1 = sc.nextInt();

            System.out.print("#2: ");
            int num2 = sc.nextInt();

            System.out.println("\n**************************************************\n");
            
            calculateGCD(Math.abs(num1), Math.abs(num2));
        }
        catch(ArithmeticException a) {
            a.printStackTrace();
        }
        catch(InputMismatchException i) {
            i.printStackTrace();
        }
    }
}