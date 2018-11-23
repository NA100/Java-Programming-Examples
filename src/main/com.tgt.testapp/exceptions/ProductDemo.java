package com.tgt.testapp.exceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductDemo {

//  product weight check.
//  invalid if < 100 lbs.
    void productWeightCheck(int weight) throws InvalidProductException {
        if (weight < 100) {
            throw new InvalidProductException("product invalid");
        }
    }

/*   id is a 4-digit alpha-numeric string.
*    First character is an alphabet, followed by a 3-digit integer.
*    e.g: A123, B321.
*/
    void productIDCheck(String id) throws InvalidIDException {
        if (id.length() == 4) {
            Pattern pattern = Pattern.compile("[a-z,A-Z\\d+]");
            Matcher matcher = pattern.matcher(id);

            if (matcher.lookingAt()) {
                System.out.println("Your product will be delivered shortly");
            } else {
                throw new InvalidIDException(id);
            }

        } else {
            throw new InvalidIDException(id, id.length());
        }

    }

    public static void main(String[] args) {
        ProductDemo productDemo = new ProductDemo();
        try {
            productDemo.productWeightCheck(90);
            productDemo.productIDCheck("A1234");
        } catch (InvalidProductException ex) {
            System.out.println("caught the exception");
            System.out.println(ex.getMessage());
        } catch (InvalidIDException ex) {
            System.out.println("caught the exception");
            System.out.println(ex.getMessage());
        }

        System.out.println("everything looks good");

    }

}
