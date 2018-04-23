/*
	ISYS 320
	Name(s):AlfurhudSolomon
	Date: Apr22, 2018
*/


import java.util.Random;
import java.util.Scanner;

public class P2_InfiniteGuessingGame {

	public static void main(String[] args) {

		Scanner console = new Scanner( System.in );
		
		String quit = "";
		
		//track number of games played
		int gamesPlayed = 0;
		
		//track number of wins
		int wins = 0;
		
		//track total guesses
		int totalGuessesTaken = 0;
		
		//loop until the user enter the word quit
		while(!quit.equals("quit"))
		{
			//increment the number of games
			gamesPlayed++;
			
			int secretNumber = getSecretNumber();
			
			outputWelcomeMessage();
			int numberOfGuessesAllowed = 7;
			
			int guessesTaken = playGame(secretNumber, numberOfGuessesAllowed);
			
			//add number of guesses to the total guesses
			totalGuessesTaken += guessesTaken;
			
			//if guesses taken is less or equal to number of guesses allowed then its a win
			if(guessesTaken <= numberOfGuessesAllowed) {
				wins++;
			}
			
			outputEndingMessage(guessesTaken, numberOfGuessesAllowed, secretNumber);
			
			//Ask whether the player would like to continue playing the game
			System.out.println("\n---------------------------------------------------------------------\n");
			System.out.print("Type any character to continue playing (or \"quit\" to stop playing):");
			quit = console.next();
		}
		
		System.out.println("Game Over \n---------------------------------------------------------------------\n");
		System.out.println("Games Played: " + gamesPlayed);
		System.out.println("Number of Wins: " + wins);
		System.out.println("Number of Losses: " + (gamesPlayed - wins));
		System.out.println("Win Percentage: " + ((wins / gamesPlayed) * 100) + "%");
		System.out.println("Average Number of Guesses: " + (totalGuessesTaken/gamesPlayed));
	}

	public static void outputWelcomeMessage() {
		System.out.println("This is a guessing game.");
		System.out.println("I picked a random number from 1 to 100");
	}

	public static void outputEndingMessage(int guessesTaken, int numberOfGuessesAllowed, int secretNumber) {
		if (guessesTaken < numberOfGuessesAllowed) {
			System.out.println("Congratuations, you guessed it!");
		} else {
			System.out.println("The secret number was " + secretNumber + ". Try again.");
		}
	}

	public static int getSecretNumber() {
		Random generator = new Random();
		return generator.nextInt(100) + 1;
	}

	public static int getNextGuess() {
		Scanner console = new Scanner(System.in);
		int nextGuess;
		do {
			System.out.println("What is your guess? ");
			nextGuess = console.nextInt();

			if (nextGuess < 0 || nextGuess > 100) {
				System.out.println("ERROR: Guess should be between 0 and 100");
			}
		} while (nextGuess < 0 || nextGuess > 100);

		return nextGuess;
	}

	public static int playGame(int secretNumber, int allowedGuesses) {
		int numOfGuessesTaken = 0;
		while (numOfGuessesTaken < allowedGuesses) {
			int nextGuess = getNextGuess();

			if (nextGuess == secretNumber) {
				return numOfGuessesTaken;
			} else if(nextGuess > secretNumber) {
				System.out.println("Nope, your guess was too large. ");
				numOfGuessesTaken++;
			} else if(nextGuess < secretNumber) {
				System.out.println("Nope, your guess was too small. ");
				numOfGuessesTaken++;
			}
		}

		return numOfGuessesTaken;
	}

}
