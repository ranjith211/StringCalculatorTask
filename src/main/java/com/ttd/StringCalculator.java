package com.ttd;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
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
                delimiterRegex = extractDelimitersRegex(delimiterPart);
            } else {
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

    private String extractDelimitersRegex(String delimiterPart) {
        Matcher matcher = Pattern.compile("\\[(.*?)\\]").matcher(delimiterPart);
        List<String> delimiters = new ArrayList<>();
        while (matcher.find()) {
            delimiters.add(Pattern.quote(matcher.group(1)));
        }
        return String.join("|", delimiters);
    }
    public int getCalledCount(){
        return callCount;
    }
}
