package week1.assignment_problems;

import java.util.Scanner;

public class SeatDuplicationChecker {

    static void checkDuplicateSeats(int[] seatNumbers) {

        boolean duplicateFound = false;

        System.out.println("Duplicate Seat Numbers:");

        for (int i = 0; i < seatNumbers.length; i++) {

            boolean alreadyPrinted = false;

            for (int k = 0; k < i; k++) {
                if (seatNumbers[k] == seatNumbers[i]) {
                    alreadyPrinted = true;
                    break;
                }
            }

            if (alreadyPrinted) {
                continue;
            }

            for (int j = i + 1; j < seatNumbers.length; j++) {

                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: "
                            + seatNumbers[i]);

                    duplicateFound = true;
                    break;
                }
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        int[] seatNumbers = new int[n];

        System.out.println("Enter seat numbers:");

        for (int i = 0; i < n; i++) {
            seatNumbers[i] = scanner.nextInt();
        }

        checkDuplicateSeats(seatNumbers);

        scanner.close();
    }
}
