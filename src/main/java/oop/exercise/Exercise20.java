package oop.exercise;
import java.text.NumberFormat;
import java.util.Scanner;
import java.util.Locale;
/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Joshua Federman
 * More complex programs may have decisions nested in other decisions,
 * so that when one decision is made, additional decisions must be made.

Create a tax calculator that handles multiple states and multiple counties within each state.
* The program prompts the user for the order amount and the state where the order will be shipped.

Wisconsin residents must be changed 5% sales tax with an additional county-level charge.
* For Wisconsin residents, prompt for the county of residence.
For Eau Claire county residents, add an additional 0.005 tax.
For Dunn county residents, add an additional 0.004 tax.
Illinois residents must be charged 8% sales tax with no additional county-level charge.
All other states are not charged tax.
The program then displays the tax and the total for Wisconsin and Illinois residents but just the total
* for everyone else.

Example Output
What is the order amount? 10
What state do you live in? Wisconsin
What county do you live in? Dane
The tax is $0.50.
The total is $10.50.
Constraints
Ensure that all money is rounded up to the nearest cent.
Use a single output statement at the end of the program to display the program results.
 */
public class Exercise20 {
    static Scanner input = new Scanner(System.in);
    static final float WISCONSIN_TAX =0.05F;
    static final float EClAIRE_TAX =0.005F;
    static final float DUNN_TAX =0.004F;
    static final float ILLINOIS_TAX =0.08F;

    public static String state(){
        System.out.print("What state do you live in? ");
        return input.nextLine();
    }
    public static String county(){
        System.out.print("What county do you live in? ");
        return input.nextLine();
    }
    public static String orderAmount(){
        System.out.print("What is the order amount? ");
        return input.nextLine();
    }
    public static void results(String a, String state, String county){
        float amount = Float.parseFloat(a);
        float total = 0;
        float tax = 0;
        boolean isTaxState = true;
        if(state.equalsIgnoreCase("Wisconsin")) {
            if(county.equalsIgnoreCase("Eau Claire")) {
                tax = (WISCONSIN_TAX + EClAIRE_TAX);
                total = amount + (amount * tax);

            }
            if(county.equalsIgnoreCase("Dunn")) {
                tax = (WISCONSIN_TAX + DUNN_TAX);
                total = amount + (amount * tax);
            }
            else {
                tax = WISCONSIN_TAX;
                total = amount + (amount * tax);
            }
        }
        else if(state.equalsIgnoreCase("Illinois")){
            tax = ILLINOIS_TAX;
            total = amount + (amount * ILLINOIS_TAX);
        }
        else{
            isTaxState = false;
            total = amount;
        }

        Locale convert = new Locale("en", "US");
        NumberFormat printDollar = NumberFormat.getCurrencyInstance(convert);
        String result = isTaxState ? "The tax is " + printDollar.format(tax * amount) +
                        ".\nThe total is " + printDollar.format(total) : "The total is " +
                            printDollar.format(total) + ".";

        System.out.print(result);
    }
    public static void main(String[] args){
        String amount = orderAmount();
        String state = state();
        String county = county();
        results(amount,state,county);
    }
}
