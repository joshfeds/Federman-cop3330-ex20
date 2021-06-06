package oop.exercise;
import java.text.NumberFormat;
import java.util.Scanner;
import java.util.Locale;
/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Joshua Federman
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
        float total;
        float tax = 0;
        boolean isTaxState = true;
        if(state.equalsIgnoreCase("Wisconsin")) {
            if(county.equalsIgnoreCase("Eau Claire")) {
                tax = (WISCONSIN_TAX + EClAIRE_TAX);
                total = amount + (amount * tax);

            }
            else if(county.equalsIgnoreCase("Dunn")) {
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
