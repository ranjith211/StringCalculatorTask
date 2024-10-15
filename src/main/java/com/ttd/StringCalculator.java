package com.ttd;

import java.util.ArrayList;
import java.util.List;
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
        List<Integer> negatives=new ArrayList<>();
        for (String token : tokens) {
            int num=Integer.parseInt(token);
            if(num<0)
            {
                negatives.add(num);
                continue;
            }
            sum += num;
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
}
