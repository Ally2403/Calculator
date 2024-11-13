/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Calculator;
import core.models.History;
import core.models.Operation;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Allison Ruiz
 */
public class CalculatorController {
    
    public static Response potency(String a, String b){
        double numberA, numberB;
        try {
            numberA = Double.parseDouble(a);
            numberB = Double.parseDouble(b);
            if(!a.matches("-?\\d+(\\.\\d{1,3})?")){
                return new Response("Number 1 can't have more than 3 decimals.", Status.BAD_REQUEST);
            }
            if(!b.matches("-?\\d+(\\.\\d{1,3})?")){
                return new Response("Number 2 can't have more than 3 decimals.", Status.BAD_REQUEST);
            }
            if(numberA == 0 && numberB == 0){
                return new Response("You can't do 0^0", Status.BAD_REQUEST);
            }
            if(numberA > Double.MAX_VALUE){
                return new Response("Number 1 can't be greater than the max value.", Status.BAD_REQUEST);
            }
            if(numberA < -Double.MAX_VALUE){
                return new Response("Number 1 can't be less than the min value.", Status.BAD_REQUEST);
            }
            if(numberB > Double.MAX_VALUE){
                return new Response("Number 2 can't be greater than the max value.", Status.BAD_REQUEST);
            }
            if(numberB < -Double.MAX_VALUE){
                return new Response("Number 2 can't be less than the min value.", Status.BAD_REQUEST);
            }
            
            if(numberA == 0 && numberB < 0){
                return new Response("Number 1 can't be 0 and Number 2 can't be negative at the same time.", Status.BAD_REQUEST);
            }
            if(Math.pow(numberA, numberB) > Double.MAX_VALUE){
                return new Response("Number 1 ^ Number 2 can't be greater than the max value.", Status.BAD_REQUEST);
            }
            if(Math.pow(numberA, numberB) < -Double.MAX_VALUE){
                return new Response("Number 1 ^ Number 2 can't be less than the min value.", Status.BAD_REQUEST);
            }
            
            History history = History.getInstance();
            Calculator calculator = Calculator.getInstance();
            history.addOperation(new Operation(numberA, numberB, "^", new BigDecimal(calculator.power(numberA, numberB)).setScale(3, RoundingMode.HALF_UP).doubleValue()));
            return new Response("Numbers potency succesfully.", Status.OK);
            
        } catch (NumberFormatException ex) {
            return new Response("Number must be numeric", Status.BAD_REQUEST);
        } 
 
    }
    
    public static Response division(String a, String b){
        double numberA, numberB;
        try {
            numberA = Double.parseDouble(a);
            numberB = Double.parseDouble(b);
            if(!a.matches("-?\\d+(\\.\\d{1,3})?")){
                return new Response("Number 1 can't have more than 3 decimals.", Status.BAD_REQUEST);
            }
            if(!b.matches("-?\\d+(\\.\\d{1,3})?")){
                return new Response("Number 2 can't have more than 3 decimals.", Status.BAD_REQUEST);
            }
            if(numberA > Double.MAX_VALUE){
                return new Response("Number 1 can't be greater than the max value.", Status.BAD_REQUEST);
            }
            if(numberA < -Double.MAX_VALUE){
                return new Response("Number 1 can't be less than the min value.", Status.BAD_REQUEST);
            }
            if(numberB > Double.MAX_VALUE){
                return new Response("Number 2 can't be greater than the max value.", Status.BAD_REQUEST);
            }
            if(numberB < -Double.MAX_VALUE){
                return new Response("Number 2 can't be less than the min value.", Status.BAD_REQUEST);
            }
            if(numberB == 0){
                return new Response("Number 2 can't be 0.", Status.BAD_REQUEST);
            }
            if((numberA / numberB) > Double.MAX_VALUE){
                return new Response("Number 1 / Number 2 can't be greater than the max value.", Status.BAD_REQUEST);
            }
            if((numberA / numberB) < -Double.MAX_VALUE){
                return new Response("Number 1 / Number 2 can't be less than the min value.", Status.BAD_REQUEST);
            }
            
            History history = History.getInstance();
            Calculator calculator = Calculator.getInstance();
            history.addOperation(new Operation(numberA, numberB, "/", new BigDecimal(calculator.divide(numberA, numberB)).setScale(3, RoundingMode.HALF_UP).doubleValue()));

            return new Response("Numbers divided succesfully.", Status.OK);
            
        } catch (NumberFormatException ex) {
            return new Response("Number must be numeric", Status.BAD_REQUEST);
        } 
    }
    
    public static Response product(String a, String b){
        double numberA, numberB;
        try {
            numberA = Double.parseDouble(a);
            numberB = Double.parseDouble(b);
            if(!a.matches("-?\\d+(\\.\\d{1,3})?")){
                return new Response("Number 1 can't have more than 3 decimals.", Status.BAD_REQUEST);
            }
            if(!b.matches("-?\\d+(\\.\\d{1,3})?")){
                return new Response("Number 2 can't have more than 3 decimals.", Status.BAD_REQUEST);
            }
            if(numberA > Double.MAX_VALUE){
                return new Response("Number 1 can't be greater than the max value.", Status.BAD_REQUEST);
            }
            if(numberA < -Double.MAX_VALUE){
                return new Response("Number 1 can't be less than the min value.", Status.BAD_REQUEST);
            }
            if(numberB > Double.MAX_VALUE){
                return new Response("Number 2 can't be greater than the max value.", Status.BAD_REQUEST);
            }
            if(numberB < -Double.MAX_VALUE){
                return new Response("Number 2 can't be less than the min value.", Status.BAD_REQUEST);
            }
            if((numberA * numberB) > Double.MAX_VALUE){
                return new Response("Number 1 * Number 2 can't be greater than the max value.", Status.BAD_REQUEST);
            }
            if((numberA * numberB) < -Double.MAX_VALUE){
                return new Response("Number 1 * Number 2 can't be less than the min value.", Status.BAD_REQUEST);
            }
            
            History history = History.getInstance();
            Calculator calculator = Calculator.getInstance();
            history.addOperation(new Operation(numberA, numberB, "*", new BigDecimal(calculator.multiply(numberA, numberB)).setScale(3, RoundingMode.HALF_UP).doubleValue()));
            return new Response("Numbers multiplied succesfully.", Status.OK);
            
        } catch (NumberFormatException ex) {
            return new Response("Number must be numeric", Status.BAD_REQUEST);
        } 
    }
    
    public static Response subtraction(String a, String b){
        double numberA, numberB;
        try {
            numberA = Double.parseDouble(a);
            numberB = Double.parseDouble(b);
            if(!a.matches("-?\\d+(\\.\\d{1,3})?")){
                return new Response("Number 1 can't have more than 3 decimals.", Status.BAD_REQUEST);
            }
            if(!b.matches("-?\\d+(\\.\\d{1,3})?")){
                return new Response("Number 2 can't have more than 3 decimals.", Status.BAD_REQUEST);
            }
            if(numberA > Double.MAX_VALUE){
                return new Response("Number 1 can't be greater than the max value.", Status.BAD_REQUEST);
            }
            if(numberA < -Double.MAX_VALUE){
                return new Response("Number 1 can't be less than the min value.", Status.BAD_REQUEST);
            }
            if(numberB > Double.MAX_VALUE){
                return new Response("Number 2 can't be greater than the max value.", Status.BAD_REQUEST);
            }
            if(numberB < -Double.MAX_VALUE){
                return new Response("Number 2 can't be less than the min value.", Status.BAD_REQUEST);
            }

            if((numberA - numberB) > Double.MAX_VALUE){
                return new Response("Number 1 - Number 2 can't be greater than the max value.", Status.BAD_REQUEST);
            }
            if((numberA - numberB) < -Double.MAX_VALUE){
                return new Response("Number 1 - Number 2 can't be less than the min value.", Status.BAD_REQUEST);
            }
            
            
            History history = History.getInstance();
            Calculator calculator = Calculator.getInstance();
            history.addOperation(new Operation(numberA, numberB, "-", new BigDecimal(calculator.subtract(numberA, numberB)).setScale(3, RoundingMode.HALF_UP).doubleValue()));
            return new Response("Numbers substracted succesfully.", Status.OK);
            
        } catch (NumberFormatException ex) {
            return new Response("Number must be numeric", Status.BAD_REQUEST);
        } 
    }
    
    public static Response addition(String a, String b){
        double numberA, numberB;
        try {
            numberA = Double.parseDouble(a);
            numberB = Double.parseDouble(b);
            if(!a.matches("-?\\d+(\\.\\d{1,3})?")){
                return new Response("Number 1 can't have more than 3 decimals.", Status.BAD_REQUEST);
            }
            if(!b.matches("-?\\d+(\\.\\d{1,3})?")){
                return new Response("Number 2 can't have more than 3 decimals.", Status.BAD_REQUEST);
            }
            if(numberA > Double.MAX_VALUE){
                return new Response("Number 1 can't be greater than the max value.", Status.BAD_REQUEST);
            }
            if(numberA < -Double.MAX_VALUE){
                return new Response("Number 1 can't be less than the min value.", Status.BAD_REQUEST);
            }
            if(numberB > Double.MAX_VALUE){
                return new Response("Number 2 can't be greater than the max value.", Status.BAD_REQUEST);
            }
            if(numberB < -Double.MAX_VALUE){
                return new Response("Number 2 can't be less than the min value.", Status.BAD_REQUEST);
            }
            
            if((numberA + numberB) > Double.MAX_VALUE){
                return new Response("Number 1 + Number 2 can't be greater than the max value.", Status.BAD_REQUEST);
            }
            if((numberA + numberB) < -Double.MAX_VALUE){
                return new Response("Number 1 + Number 2 can't be less than the min value.", Status.BAD_REQUEST);
            }
            
            History history = History.getInstance();
            Calculator calculator = Calculator.getInstance();
            history.addOperation(new Operation(numberA, numberB, "+", new BigDecimal(calculator.add(numberA, numberB)).setScale(3, RoundingMode.HALF_UP).doubleValue()));
            return new Response("Numbers added succesfully.", Status.OK);
            
        } catch (NumberFormatException ex) {
            return new Response("Number must be numeric", Status.BAD_REQUEST);
        } 
    }
}
