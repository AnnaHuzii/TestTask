package main.java.task1;// If we discard numbers and operation signs from a correctly written arithmetic expression containing numbers,
// operation signs and opening and closing parentheses,
// and then write the brackets remaining in the expression without spaces between them,
// then we will call the result obtained a correct bracket
// expression [bracket expression "(( )(()))" is correct, but "()(" and "())(" are not].
// Find the number of correct bracket expressions containing N opening and N closing brackets.
// N is entered from the keyboard. N is a non-negative integer.

import java.util.Scanner;

public class TaskOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a non-negative integer N = ");

        if (scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n > 0) {
                System.out.println("(".repeat(n) + ")".repeat(n));
            }else {
                System.out.println("You entered a negative number");
            }
        }else {
            System.out.println("You entered not an integer");
        }
    }
}

