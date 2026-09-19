
package week1.class_problems;

import java.util.Scanner;

public class TeamBmiWellnessReport {

    static String getBmiStatus(double bmi) {

        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi <= 24.9) {
            return "Normal";
        } else if (bmi <= 29.9) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    static void printWellnessReport(double[] heights, double[] weights) {

        System.out.println();
        System.out.println("============== WELLNESS REPORT ==============");
        System.out.printf("%-10s %-15s %-15s %-10s %-15s%n",
                "Person", "Height(m)", "Weight(kg)", "BMI", "Status");

        for (int i = 0; i < heights.length; i++) {

            double bmi = weights[i] / (heights[i] * heights[i]);
            String status = getBmiStatus(bmi);

            System.out.printf("%-10d %-15.2f %-15.2f %-10.2f %-15s%n",
                    i + 1,
                    heights[i],
                    weights[i],
                    bmi,
                    status);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final int people = 10;

        double[] heights = new double[people];
        double[] weights = new double[people];

        System.out.println("Enter height and weight for 10 people.");

        for (int i = 0; i < people; i++) {

            System.out.println("\nPerson " + (i + 1));

            System.out.print("Height in meters: ");
            heights[i] = scanner.nextDouble();

            System.out.print("Weight in kilograms: ");
            weights[i] = scanner.nextDouble();
        }

        printWellnessReport(heights, weights);

        scanner.close();
    }
}