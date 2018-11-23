package com.tgt.testapp.exceptions;

public class InvalidIDException extends Exception {

    public InvalidIDException(String s, int length) {
        super(String.format(String.format(String.format("%s is not the right length. " +
                "It has to be 4-digit alpha-numeric.You have provided: %d characters", s, length))));
    }

    public InvalidIDException(String s) {
        super(String.format("%s is not a 4 digit alpha-numeric. Please try again", s));
    }
}
