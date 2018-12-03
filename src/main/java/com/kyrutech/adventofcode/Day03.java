package com.kyrutech.adventofcode;

import java.util.Scanner;

public class Day03 {
    public static void main(String[] args) {
        Day03 d = new Day03();
        System.out.println(d.fabricOverlap());
        System.out.println(d.getIdOfValid());
    }

    public int fabricOverlap() {

        int[][] fabric = new int[1000][1000];
        for(int i = 0;i<1000;i++) {
            for(int j = 0;j<1000;j++) {
                fabric[i][j] = 0;
            }
        }

        Scanner sc = new Scanner(getClass().getClassLoader().getResourceAsStream("day03input.txt"));

        while(sc.hasNextLine()) {
            String input = sc.nextLine();
            String[] parts01 = input.split("@");
            String[] parts02 = parts01[1].split(":");

            String[] leftTop = parts02[0].split(",");
            String[] widthHeight = parts02[1].split("x");

            int left = Integer.parseInt(leftTop[0].trim());
            int top = Integer.parseInt(leftTop[1].trim());
            int width = Integer.parseInt(widthHeight[0].trim());
            int height = Integer.parseInt(widthHeight[1].trim());

            for(int i = left;i < left+width;i++) {
                for(int j = top;j < top+height;j++) {
                    if(fabric[i][j] == 0) {
                        fabric[i][j] = 1;
                    } else {
                        fabric[i][j] = 2;
                    }
                }
            }
        }

        int overlap = 0;
        for(int i = 0;i<1000;i++) {
            for(int j = 0;j<1000;j++) {
                if(fabric[i][j] == 2) {
                    overlap++;
                }
            }
        }
        return overlap;
    }


    public String getIdOfValid() {
        String[][] fabric = new String[1000][1000];
        for(int i = 0;i<1000;i++) {
            for(int j = 0;j<1000;j++) {
                fabric[i][j] = "0";
            }
        }

        Scanner sc = new Scanner(getClass().getClassLoader().getResourceAsStream("day03input.txt"));

        while(sc.hasNextLine()) {
            String input = sc.nextLine();
            String[] parts01 = input.split("@");
            String[] parts02 = parts01[1].split(":");

            String[] leftTop = parts02[0].split(",");
            String[] widthHeight = parts02[1].split("x");

            String id = parts01[0];
            int left = Integer.parseInt(leftTop[0].trim());
            int top = Integer.parseInt(leftTop[1].trim());
            int width = Integer.parseInt(widthHeight[0].trim());
            int height = Integer.parseInt(widthHeight[1].trim());

            for(int i = left;i < left+width;i++) {
                for(int j = top;j < top+height;j++) {
                    if(fabric[i][j].equals("0")) {
                        fabric[i][j] = id;
                    } else {
                        fabric[i][j] = "X";
                    }
                }
            }
        }

        //CHeck for valid;
        sc = new Scanner(getClass().getClassLoader().getResourceAsStream("day03input.txt"));

        while(sc.hasNextLine()) {
            String input = sc.nextLine();
            String[] parts01 = input.split("@");
            String[] parts02 = parts01[1].split(":");

            String[] leftTop = parts02[0].split(",");
            String[] widthHeight = parts02[1].split("x");

            String id = parts01[0];
            int left = Integer.parseInt(leftTop[0].trim());
            int top = Integer.parseInt(leftTop[1].trim());
            int width = Integer.parseInt(widthHeight[0].trim());
            int height = Integer.parseInt(widthHeight[1].trim());

            boolean foundOverlap = false;
            for (int i = left; i < left + width; i++) {
                for (int j = top; j < top + height; j++) {
                    if (fabric[i][j].equals("X")) {
                        foundOverlap = true;
                    }
                }
            }
            if (!foundOverlap) {
                return id;
            }
        }
        return "INVALID";
    }
}
