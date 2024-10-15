package com.ttd;

import java.util.regex.Pattern;

public class StringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiterRegex = ",|\n";
        String numString = numbers;


        if (numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf('\n');
            String delimiterPart = numbers.substring(2, delimiterEnd);
            delimiterRegex = Pattern.quote(delimiterPart);
            numString = numbers.substring(delimiterEnd + 1);
        }
        String[] tokens = numString.split(delimiterRegex);
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }

        return sum;
    }
}
