import java.util.Scanner;
public class HealthKiosk {
    public static void main(String[] args) {
        //Task 1
        System.out.println("Welcome To Your Service Router");
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter service(P/L/T/C):");
        char prompt= input.next().toUpperCase().charAt(0);

        switch (prompt){
            case 'P'-> System.out.println("Go to Pharmacy");
            case 'L'-> System.out.println("Got to lab desk");
            case 'T'-> System.out.println("Go to Triage Desk");
            case 'C'-> System.out.println("Go to counseling desk");
            default -> System.out.println("Invalid Service Code");

        }

        //Task 2
        double metricValue = 0;
        if (prompt=='T') {
            System.out.println("Enter Your health metric:(1/2/3)" +
                    "1-BMI, 2 - Dosage round - up, 3- Simple Trig helper.");

            int prompt1 = input.nextInt();
            if (prompt1 == 1) {
                System.out.println("Enter your height in metres");
                double height = input.nextDouble();
                System.out.println("Enter your weight in kilograms");
                double weight = input.nextDouble();
                double BMI = weight / Math.pow(height, 2);
                double roundedBmi = Math.round(BMI * 10) / 10.0;
                metricValue = roundedBmi;

                if (roundedBmi < 18)
                    System.out.println("Underweight");
                else if (roundedBmi >= 18.5 && roundedBmi <= 24.9)
                    System.out.println("Normal");
                else if (roundedBmi >= 25.0 && roundedBmi <= 29.9)
                    System.out.println("Overweight");
                else
                    System.out.println("Obese");


            } else if (prompt1 == 2) {
                System.out.print("Enter the required dosage in mg :");
                double dosage = input.nextDouble();
                int tablets = (int) Math.ceil(dosage / 250.0);
                metricValue = tablets;
                System.out.println("Number of tablets: " + tablets);
            } else if (prompt1 == 3) {
                System.out.print("\nEnter angle in degrees:");
                double angle = input.nextDouble();
                double radians = Math.toRadians(angle);

                double sinAngle = Math.sin(radians);
                double cosAngle = Math.cos(radians);

                double sinRounded = (Math.round(sinAngle * 1000) / 1000.0);
                double cosRounded = (Math.round(cosAngle * 1000) / 1000.0);

                System.out.println("sin(" + angle + ") = " + sinRounded);
                System.out.println("cos(" + angle + ") = " + cosRounded);
            }
        }

        //Task 3
// First random uppercase letter
        char firstChar = (char)('A' + (int)(Math.random() * 26));

        int d1 = (int)(Math.random() * 7) + 3;
        int d2 = (int)(Math.random() * 7) + 3;
        int d3 = (int)(Math.random() * 7) + 3;
        int d4 = (int)(Math.random() * 7) + 3;

// Build the ID
        String id = "" + firstChar + d1 + d2 + d3 + d4;
        System.out.println("Generated ID: " + id);

        boolean valid = true;
        if (id.length() != 5) {
            valid = false;
            System.out.println("Invalid: Wrong length");
        } else if (!Character.isLetter(id.charAt(0))) {
            valid = false;
            System.out.println("Invalid: First character not letter");
        } else if (!Character.isDigit(id.charAt(1)) ||
                !Character.isDigit(id.charAt(2)) ||
                !Character.isDigit(id.charAt(3)) ||
                !Character.isDigit(id.charAt(4))) {
            valid = false;
            System.out.println("Invalid: Non-digit in digits part");
        }

        if (valid) {
            System.out.println("ID OK");
        }


        //Task 4
        System.out.print("\n Enter your first name:");
        String firstName = input.next();
        char firstLetter = Character.toUpperCase(firstName.charAt(0));
        char shifted = (char)('A' + (firstLetter - 'A' + 2) % 26);

        String lastTwo = "" + id.charAt(3) + id.charAt(4);

        int metricInt = (int)Math.round(metricValue);

        String displayCode = shifted + lastTwo + "-" + metricInt;
        System.out.println("Secure Code: " + displayCode);

        // Task 5: Service Summary
        System.out.print(prompt + " | ID=" + id);
        if (prompt=='T') {
            System.out.print(" | Metric=" + metricValue);
        }
        System.out.println(" | Code=" + displayCode);







    }
}