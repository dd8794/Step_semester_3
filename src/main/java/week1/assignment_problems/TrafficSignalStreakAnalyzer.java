package week1.assignment_problems;

import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {

    static void findLongestStreak(String signalLog) {

        if (signalLog.isEmpty()) {
            System.out.println("Signal log is empty.");
            return;
        }

        char longestColor = signalLog.charAt(0);
        int longestLength = 1;

        char currentColor = signalLog.charAt(0);
        int currentLength = 1;

        for (int i = 1; i < signalLog.length(); i++) {

            char current = signalLog.charAt(i);

            if (current == currentColor) {
                currentLength++;
            } else {

                if (currentLength > longestLength) {
                    longestLength = currentLength;
                    longestColor = currentColor;
                }

                currentColor = current;
                currentLength = 1;
            }
        }

        if (currentLength > longestLength) {
            longestLength = currentLength;
            longestColor = currentColor;
        }

        System.out.println(
                "Longest Streak: '" + longestColor
                        + "' repeated " + longestLength + " times"
        );
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter signal log: ");
        String signalLog = scanner.nextLine();

        findLongestStreak(signalLog);

        scanner.close();
    }
}