package com.tgt.testapp.dataoperations;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStreamOperations {

    public static void main(String args[]) {

        List<Integer> list = new ArrayList<>();
        for(int i = 1; i< 10; i++){
            list.add(i);
        }

        //Question-1 Print all even numbers
        //old way
        for(int i : list) {
            if(i % 2 == 0) {
                System.out.println(i);
            }
        }
        //new way
        List<Integer> evenNumbersList = list.stream().filter(i -> i%2 == 0).collect(Collectors.toList());
        System.out.print(evenNumbersList);
        

        //Question-2 Given a list of words, change them to upper case
        //old way
        //new way
        //hint use a map for new way

        //Question-3  Given a list of numbers, multiply each number by 2 and print them
        //old way
        //new way
        //hint use a map for new way

        //Question-4  Given a list of words, return true if they contain letter "a"
        //old way
        //new way
        //hint use a anyMatch for new way

    }
}
