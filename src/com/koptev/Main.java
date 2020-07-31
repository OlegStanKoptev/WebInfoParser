package com.koptev;

import com.koptev.abstractions.ParseResultItem;
import com.koptev.abstractions.ParseResultList;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    System.out.println("Program started.");
        ParseService parser = new ParseService(true);
        List<String> addresses = Arrays.asList(
                "https://www.otzyvru.com/rossiyskie-jeleznye-dorogi");

        ParseResultList companies = parser.Parse(addresses);

        if (companies != null) {
            for (ParseResultItem item: companies) {
                System.out.println(item);
            }
        }

	    System.out.println("Program finished.");
    }
}
