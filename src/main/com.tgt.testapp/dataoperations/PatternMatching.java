package com.tgt.testapp.dataoperations;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatching {


    /**
     * Using regex, this program prints the email address that matches the given pattern.
     *
     * @param args
     */
    public static void main(String[] args)
        {

            Pattern pattern = Pattern.compile("^(.+)@gmail.com$");

            // Input list
            List<String> emails = Arrays.asList("alex@gmail.com", "bob@yahoo.com", "cat@google.com", "david@gmail.com");

            for(String email : emails) {

                Matcher matcher = pattern.matcher(email);

                if(matcher.matches())
                {
                    System.out.println(email);
                }
            }

        }

}
