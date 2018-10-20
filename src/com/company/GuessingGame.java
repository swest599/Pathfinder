package com.company;
import java.util.Random;
import java.util.Scanner;
public class GuessingGame implements RangeRover {
    @Override
    public void startGame() {
        Scanner scanner= new Scanner(System.in);
        Random random = new Random();
        int rangeNum = random.nextInt(10)+1;
        int guess;
        do {
            System.out.println("Guess a number between 1 and 10");
        }


    }
}
