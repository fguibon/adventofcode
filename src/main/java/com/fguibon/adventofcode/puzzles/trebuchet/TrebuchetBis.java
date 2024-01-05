package com.fguibon.adventofcode.puzzles.trebuchet;

import com.fguibon.adventofcode.utils.FileReader;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://adventofcode.com/2023/day/1
 */

@Component
public class TrebuchetBis implements CommandLineRunner {

    Map<String, String> numbers = new HashMap<>() {{
        put("one", "1");
        put("two", "2");
        put("three", "3");
        put("four", "4");
        put("five", "5");
        put("six", "6");
        put("seven", "7");
        put("eight", "8");
        put("nine", "9");
    }};

    public int calculateSum() {
       int result = 0;
       List<String> lines = FileReader.readLines("trebuchet");
       for(String line : lines) {
           // Not explained on page of puzzle but 'eightwo' gives 82,
           // so we must modify a bit to keep leading and trailing characters
           line = line .replace("one","o1e").replace("two","t2o")
                   .replace("three","thr3e").replace("four","fo4r")
                   .replace("five","fi5e").replace("six","s6x")
                   .replace("seven","se7en").replace("eight","eig8t")
                   .replace("nine","ni9e");

           for(Map.Entry<String, String> entry : numbers.entrySet()) {
               line = line.replaceAll(entry.getKey(), entry.getValue());
           }
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
        //System.out.println("result part 2: "+ result); // Correct Answer 55429 (54926 before fix)
    }
}
