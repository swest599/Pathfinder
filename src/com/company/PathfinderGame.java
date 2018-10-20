package com.company;
import java.util.Scanner;
public class PathfinderGame {
    Scanner scanner = new Scanner(System.in);
    int tile;
    int roll;
    public void startGame(){ // focus on one executable per method.. If method is longer than 30 lines try to make it simpler
        logo();
        instructions();
        tile = 1;
        input();
        System.out.println("Tile:" + tile);
        checkValue();
//        Counter(input());


    }
    private void instructions(){
        System.out.println("This game is called 'PathFinder'. The goal of this game is to reach the end of the path, 100 tiles. " );
        System.out.println("You start at the first tile, then press enter to roll. You can roll any number from 1 to 10 - then move that ");
        System.out.println("number of tiles forward. If you roll a 7, you get to move 7 tiles, plus a random roll between 1 an 10. ");
        System.out.println("If you roll a 10, you move back a random roll from between 1 and 10. ");
        System.out.println("If the random roll is greater than your current tile, you move back to the first tile.Good luck!");
    }
    private void logo(){
        System.out.println("######                      #######"+
                "\n#     #   ##   ##### #    # #       # #    # #####  ###### #####"+
                "\n#     #  #  #    #   #    # #       # ##   # #    # #      #    #"+
                "\n######  #    #   #   ###### #####   # # #  # #    # #####  #    #"+
                "\n#       ######   #   #    # #       # #  # # #    # #      #####"+
                "\n#       #    #   #   #    # #       # #   ## #    # #      #   #"+
                "\n#       #    #   #   #    # #       # #    # #####  ###### #    #");
    }
    private void input(){
        System.out.println("Press enter to roll...");
        scanner.nextLine();
        roll = roll();
    }
    private int roll(){
        int random = (int)Math.ceil(Math.random()*10);
        return random;
    }
    private void checkValue(){
        do {
            System.out.println("Tiles to go: "+(100-tile));
            input();
            int newRandom0 =roll();
        if (roll == 7){// rolled 7 exception
            tile = tile +roll +roll();
            System.out.println("Great luck! You rolled a 7 Move forward your roll, plus "+newRandom0+" extra spaces! ");
            System.out.println("Your tiles are: "+tile);
        } else if (roll == 10){// rolled 10 exception
            System.out.println("You rolled a "+ roll);
            int newRandom = roll();
            if (tile <= 10 && newRandom >= tile){
                System.out.println("Landed on 10, but newRandom is greater or equal to tile:"+newRandom);
                tile = 1;
            }else{
                System.out.println("Oh no you rolled a 10. You will move back "+newRandom+" tiles.");
                tile = tile - newRandom;}
            System.out.println("Your tiles are: "+tile);
        }else{// rolled all else
            System.out.println("Nothing special, changing tile from "+ tile + " to " +(tile+roll));
            tile = tile +roll;
            System.out.println("New Value:" + tile);
        }
    }while (tile <100);
        System.out.println("Congrats! You've reached the end of the path!");
        gameOver();
             }
             private void gameOver(){
                 System.out.print("Play again? [y/n]:");
                 String input = scanner.nextLine();
                 do {
                    if (input.length() == 0 || input.charAt(0) == 'y' || input.charAt(0) == 'Y') {
                        startGame();
                        break;
                    } else if (input.charAt(0) == 'n' || input.charAt(0) == 'N') {
                        System.out.println("Goodbye! Thanks for playing 'PathFinder'!");
                    } else {
                        System.out.println("Sorry does not compute.");
                    }
                }while (input.length() != 0 || input.charAt(0) != 'y' || input.charAt(0) != 'Y');
                 }
//        Scanner playAgain = new Scanner(System.in);
             }


