package com.company;

import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidatingInputs {
    static String data = "";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("First Name: ");
        String firstName = input.nextLine();
        System.out.print("Last Name: ");
        String lastName = input.nextLine();
        System.out.print("ZIP Code: ");
        String zip = input.nextLine();
        System.out.print("Employee ID: ");
        String employeeID = input.nextLine();

        validateInput(firstName, lastName, zip, employeeID);

    }

    public static void validateInput(String firstName, String lastName, String zip, String employeeID) {
        boolean first = validateFirstName(firstName);
        boolean last = validateLastName(lastName);
        boolean idFlag = validateEmployeeID(employeeID);
        boolean zipFlag = validateZipCode(zip);
        if (first && last && zipFlag && idFlag) {
            data = "There were no errors found.";
        }
        System.out.println(data);
    }
    public static boolean validateFirstName(String firstName) {
        boolean status = true;
        if (firstName.length() < 2) {
            data = data + "The first name must be at minimum 2 characters long.\n";
            status = false;
        }
        if (firstName.length() == 0) {
            data = data + "The first name must be filled in.\n";
        }
        return status;
    }


    public static boolean validateLastName(String lastName) {
        boolean status = true;
        if (lastName.length() < 2) {
            data = data + "The last name must be at minimum 2 characters long.\n";
            status = false;
        }
        if (lastName.length() == 0) {
            System.out.println("The last name must be filled in.");
        }
        return status;
    }

    // This method validate zip
    public static boolean validateZipCode(String zip) {
        boolean status = true;
        try {
            if (zip.length() == 5) {
            } else {
                data = new StringBuilder().append(data).append("The zipcode must be a 5 digit number.\n").toString();
                status = false;
            }
        } catch (Exception e) {
            data = data + "The zipcode must be a 5 digit number.\n";
            status = false;
        }
        return status;
    }

    // This method validate employeeID
    public static boolean validateEmployeeID(String employeeID) {
        String pattern = "[a-zA-Z]{2}[-][0-9]{4}";// two letters, a hyphen, and four numbers.
        if (!Pattern.matches(pattern, employeeID)) {
            data = data + "The employee ID must be in the format of AA-1234.\n";
            return false;
        }
        return true;
    }

}