import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EuclideanAlgorithm {
    
    public static void calculateGCD(int num1, int num2) {
        int remainder = 42;
        int temp1 = num1 > num2 ? num1 : num2;
        int temp2 = num1 < num2 ? num1 : num2;

        ArrayList<Integer> remainderStates = new ArrayList<>();

        while(remainder != 0) {
            
            int whole = temp1 / temp2;
            remainder = temp1 % temp2;

            remainderStates.add(remainder);

            System.out.println("(" + temp1 + ", " + temp2 + ") = " + whole + " * " + temp2 + " + " + remainder + ".");

            temp1 = temp2;
            temp2 = remainder;
        }

        System.out.println("\nGCD = " + remainderStates.get(remainderStates.size() - 2));
    }
    public static void main(String[] args) {        
        try(Scanner sc = new Scanner(System.in)){        
            System.out.print("#1: ");
            int num1 = sc.nextInt();

            System.out.print("\n#2: ");
            int num2 = sc.nextInt();

            System.out.println();
            System.out.println("**************************************************\n");
            
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