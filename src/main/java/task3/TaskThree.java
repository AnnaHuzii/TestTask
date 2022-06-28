package main.java.task3;

import java.util.ArrayList;

// Find the sum of the digits in the number 100! (i.e. 100 factorial)

public class TaskThree {
    // Function to multiply x with large number
    // stored in vector v. Result is stored in v.
    static ArrayList<Integer> v = new ArrayList<>();

    static void multiply(int x) {
        int carry = 0;
        int size = v.size();
        for (int i = 0; i < size; i++) {
            // Calculate res + prev carry
            int res = carry + v.get(i) * x;

            // updation at ith position
            v.set(i, res % 10);
            carry = res / 10;
        }
        while (carry != 0) {
            v.add(carry % 10);
            carry /= 10;
        }
    }

    // Returns sum of digits in n!
    static int findSumOfDigits(int n) {
        v.add(1); // adds 1 to the end

        // One by one multiply i to current vector
        // and update the vector.
        for (int i = 1; i <= n; i++)
            multiply(i);

        // Find sum of digits in vector v[]
        int sum = 0;
        for (Integer integer : v) sum += integer;
        return sum;
    }

    public static void main(String[] args) {
        int n = 100;
        System.out.println(findSumOfDigits(n));
    }
}

