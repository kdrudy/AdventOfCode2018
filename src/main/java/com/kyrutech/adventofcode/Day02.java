package com.kyrutech.adventofcode;

import java.util.*;

public class Day02 {
    public static void main(String[] args) {
        Day02 d = new Day02();
        System.out.println(d.checkSum());
        System.out.println(d.sameCharacters());

    }

    public int checkSum() {
        Scanner sc = new Scanner(getClass().getClassLoader().getResourceAsStream("day02input.txt"));
        int twoDuplicates = 0;
        int threeDuplicates = 0;

        while(sc.hasNextLine()) {
            String input = sc.nextLine();

            //Count letters
            Map<Character, Integer> letterCounts = new HashMap<>();
            for(int i = 0;i<input.length();i++) {
                char letter = input.charAt(i);
                if(letterCounts.containsKey(letter)) {
                    letterCounts.put(letter, letterCounts.get(letter)+1);
                } else {
                    letterCounts.put(letter, 1);
                }
            }

            //Look for 2 letters
            for(Map.Entry<Character, Integer> entry : letterCounts.entrySet()) {
                if(entry.getValue() == 2) {
                    twoDuplicates++;
                    break;
                }
            }

            //Look for 3 letters
            for(Map.Entry<Character, Integer> entry : letterCounts.entrySet()) {
                if(entry.getValue() == 3) {
                    threeDuplicates++;
                    break;
                }
            }
        }
        return twoDuplicates * threeDuplicates;
    }

    public String sameCharacters() {
        Scanner sc = new Scanner(getClass().getClassLoader().getResourceAsStream("day02input.txt"));
        List<String> boxIds = new ArrayList<>();
        while(sc.hasNextLine()) {
            String input = sc.nextLine();
            boxIds.add(input);
        }
        for(String boxIdA : boxIds) {
            for(String boxIdB : boxIds) {
                if(boxIdA.equals(boxIdB)) {
                    continue;
                }

                int differences = 0;
                String similarChars = "";
                for(int i = 0;i<boxIdA.length();i++) {
                    if(boxIdA.charAt(i) != boxIdB.charAt(i)) {
                        differences++;
                    } else {
                        similarChars += boxIdA.charAt(i);
                    }
                }
                if(differences == 1) {
                    return similarChars;
                }
            }
        }
        return "INVALID";
    }
}
