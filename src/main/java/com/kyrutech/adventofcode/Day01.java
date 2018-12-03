package com.kyrutech.adventofcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day01 {

    public static void main(String[] args) {
        Day01 d = new Day01();
        System.out.println(d.getFrequency());
        System.out.println(d.getFirstDuplicate());

    }

    public int getFrequency() {
        int retVal = 0;
        Scanner sc = new Scanner(getClass().getClassLoader().getResourceAsStream("day01input.txt"));

        while(sc.hasNextLine()) {
            String value = sc.nextLine();
            int freqChange = Integer.parseInt(value);
            retVal += freqChange;
        }

        return retVal;
    }

    public int getFirstDuplicate() {
        int currentFreq = 0;
        int dupeFreq = -9999;
        boolean duplicateFound = false;
        List<Integer> foundFrequencies = new ArrayList<>();
        do {
            Scanner sc = new Scanner(getClass().getClassLoader().getResourceAsStream("day01input.txt"));
            while (sc.hasNextLine()) {
                String value = sc.nextLine();
                int freqChange = Integer.parseInt(value);
                currentFreq += freqChange;
                if(foundFrequencies.contains(currentFreq)) {
                    dupeFreq = currentFreq;
                    duplicateFound = true;
                    break;
                }
                foundFrequencies.add(currentFreq);
            }
        } while(!duplicateFound);

        return dupeFreq;
    }
}
