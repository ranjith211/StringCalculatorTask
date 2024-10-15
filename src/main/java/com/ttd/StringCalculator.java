package com.ttd;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    private  int callCount=0;
    public int add(String numbers) {
        callCount++;

        if (numbers.isEmpty()) {
            return 0;
        }
        String delimiterRegex = ",|\n";
        String numString = numbers;


        if (numbers.startsWith("//")) {
            int delimiterEnd = numbers.indexOf('\n');
            String delimiterPart = numbers.substring(2, delimiterEnd);
            if (delimiterPart.startsWith("[") && delimiterPart.endsWith("]")) {
                // Handle delimiters of any length
                delimiterRegex = delimiterPart.substring(1,delimiterPart.length()-1);
            } else {
                // Single character delimiter
                delimiterRegex = Pattern.quote(delimiterPart);
            }
            numString = numbers.substring(delimiterEnd + 1);
        }
        String[] tokens = numString.split(delimiterRegex);
        int sum = 0;
        List<Integer> negatives=new ArrayList<>();
        for (String token : tokens) {
            int num=Integer.parseInt(token);
            if(num<0)
            {
                negatives.add(num);
                continue;
            }
            if (num <= 1000) {
                sum += num;
            }
        }

        if (!negatives.isEmpty()) {
            StringBuilder message = new StringBuilder("negatives not allowed: ");
            for (int i = 0; i < negatives.size(); i++) {
                message.append(negatives.get(i));
                if (i < negatives.size() - 1) {
                    message.append(", ");
                }
            }
            throw new IllegalArgumentException(message.toString());
        }

        return sum;
    }

    public int getCalledCount(){
        return callCount;
    }
}
