package Accenture_Ques_Paid;

import java.text.*;

public class CalculateArea {
    // Function to calculate the area
    public static double calculateArea(double radius) {
        return 3.14 * radius * radius;
    }


    // Function to round the result to the nearest integer
    public static int roundToNearestInt(double value) {
        return (int) Math.round(value); // Round to the nearest integer
    }

    // Function to truncate the result
    public static int truncate(double value) {
        return (int) value; // Cast to int to remove decimal part
    }

    // Function to format the result to 2 decimal places
    public static String formatToTwoDecimal(double value) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(value);
    }

    public static void main(String[] args) {
        double radius = 5; // Example input
        double area = calculateArea(radius);

        int truncatedResult = truncate(area);

        String formattedResult = formatToTwoDecimal(area);

        int roundedResult = roundToNearestInt(area);

        System.out.println("Calculated Area  : " + area);
        System.out.println("Truncated Result : " + truncatedResult);
        System.out.println("Formatted Result : " + formattedResult);
        System.out.println("Rounded Result   : " + roundedResult);

    }
}
