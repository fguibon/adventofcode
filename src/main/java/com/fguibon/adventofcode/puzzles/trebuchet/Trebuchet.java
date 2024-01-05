package com.fguibon.adventofcode.puzzles.trebuchet;

import com.fguibon.adventofcode.utils.FileReader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

/*
https://adventofcode.com/2023/day/1
 */

@Component
public class Trebuchet implements CommandLineRunner {

    public int calculateSum() {
       int result = 0;
       List<String> lines = FileReader.readLines("trebuchet");
       for(String line : lines) {
           String onlyIntegers = line.replaceAll("[a-z]","");
           int lenght = onlyIntegers.length();
           if(onlyIntegers.length() == 1) {
               result += Integer.parseInt(onlyIntegers + onlyIntegers) ;
           } else {
               String firstNumber = onlyIntegers.substring(0,1);
               String lastNumber = onlyIntegers.substring(lenght -1, lenght);
               int number = Integer.parseInt(firstNumber + lastNumber);
               result += number;
           }
       }
       return result;
    }

    @Override
    public void run(String... args) throws Exception {
        //int result = calculateSum();
        //System.out.println("result part 1: "+ result); // Answer 54605
    }
}
