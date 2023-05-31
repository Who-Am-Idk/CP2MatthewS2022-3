package hangmanProject;

import java.io.File;
import java.util.*;


public class  Main{
	public static void main(String[] args) throws Exception{
//Welcome Statement
		System.out.println("Welcome to hangman! Type the first letter!\n");
		
//Add word list text file
		//DICTIONARRY CAN BE FOUND HERE:
		//http://www.gwicks.net/dictionaries.htm
		File wordlist = new File("/Users/9598657/eclipse-workspace/hangmanProject/src/words.txt");
//Make Scanners
		Scanner textScanner = new Scanner(wordlist);
		Scanner input = new Scanner(System.in);
		
//Make word list into array
		ArrayList<String> words = new ArrayList<>();
		while(textScanner.hasNextLine()) {
			words.add(textScanner.nextLine());
		}
		
//Get word from Array
		String hidden_text = words.get((int)(Math.random()*words.size()));
		char[] textArray = hidden_text.toCharArray();
		
//Make characters unknown
		char[] myGuesses = new char[textArray.length];
		for(int i = 0; i < textArray.length; i++) {
			myGuesses[i] = '_';
		}
//Print blank spaces
		for (int g=0; g<myGuesses.length;g++) {
			if(myGuesses[g] == '_') {
				System.out.print(" _");
			}
		}
		boolean finished = false;
		int attempts = 0;
//Game loop
		while (!finished) {
			printHangman(attempts);
			String letter = input.next();

		//Make booleans that will be reset every time
			boolean found = false;
			boolean done = true;
			boolean fail = false;
			
			//If the user input a word, check if they wanted to do so
			if (letter.length() >= 2) {
				System.out.println("You inputted multiple letters, do you want to guess your input as the final word?\nIf not, the first letter will be taken as the input");
				char decision = input.next().charAt(0);
				
				//If the user enters 'yes', check if every letter is correct
				if (decision == 'y') {
					for (int i = 0; i < textArray.length; i++) {
						if (letter.charAt(i) != textArray[i]) {
							fail = true;
						}
					}
					
					//If any errors, fail the game
					if (fail) {
						System.out.println("Uh oh you failed");
						attempts = 7;
						finished = true;
						printHangman(attempts);
						input.close();
					}else {
						System.out.println("Congrats you got the word, Impresive!");
						finished = true;
						input.close();
					}
					break;
				}else if (decision == 'n') {
					System.out.println("Okay, just be more careful with typing then");
				}
			}
			
			//Check if the input is a number
			if (Character.isDigit(letter.charAt(0))) {
				System.out.println("Uh oh! you can only write letters");
				letter = input.next();
			}
			for (int i = 0; i < textArray.length; i++) {
				if (letter.charAt(0) == textArray[i]) {
					myGuesses[i] = textArray[i];
					found = true;
				}
			}
		//Print message if wrong
			if(!found) {
				attempts++;
				System.out.println();
				System.out.println("Uh-oh Wrong!");
			}
		//Each time game loop runs, resets variable 'done'
			//Print blank spaces in game loop
			for (int i=0; i<myGuesses.length;i++) {
				if(myGuesses[i] == '_') {
					System.out.print(" _");
					done = false;
				}else {
		//Print correct guesses in word
				 System.out.print(" " + myGuesses[i]);
				}
			}
		//If there is no blank spaces left, print win message
			if (done) {
				System.out.println("\nCongrats you found the word!");
				textScanner.close();
				input.close();
				finished = true;
				
			}
		//If 7 incorrect guesses are made, print lose message
			if (attempts >= 7) {
				System.out.println("\nUh-oh! You died ;-;");
				printHangman(attempts);
				textScanner.close();
				input.close();
				System.out.println("The word was: " + hidden_text);
				finished = true;
			}
		}
	}
	//Switch case method for increasing attempt number
	public static void printHangman(int attempt) {
	    switch (attempt) {
	      case 1:
	    	System.out.println();
	        System.out.println("   ________");
	        System.out.println("   |      |");
	        System.out.println("   |      O");
	        System.out.println("   |    ");
	        System.out.println("   |     ");
	        System.out.println("   |         ");
	        System.out.println("   |         ");
	        System.out.println("   |          ");
	        System.out.println("___|___       ");
	        break;
	      case 2:
		    System.out.println();
	        System.out.println("   ________");
	        System.out.println("   |      |");
	        System.out.println("   |      O");
	        System.out.println("   |      |");
	        System.out.println("   |     ");
	        System.out.println("   |         ");
	        System.out.println("   |         ");
	        System.out.println("   |          ");
	        System.out.println("___|___       ");
	        break;
	      case 3:
	    	System.out.println();
	        System.out.println("   ________");
	        System.out.println("   |      |");
	        System.out.println("   |      O");
	        System.out.println("   |     -|");
	        System.out.println("   |     ");
	        System.out.println("   |         ");
	        System.out.println("   |         ");
	        System.out.println("   |          ");
	        System.out.println("___|___       ");
	        break;
	      case 4:
	    	System.out.println();
	        System.out.println("   ________");
	        System.out.println("   |      |");
	        System.out.println("   |      O");
	        System.out.println("   |    --|");
	        System.out.println("   |     ");
	        System.out.println("   |         ");
	        System.out.println("   |         ");
	        System.out.println("   |          ");
	        System.out.println("___|___       ");
	        break;
	      case 5:
	    	  System.out.println();
	        System.out.println("   ________");
	        System.out.println("   |      |");
	        System.out.println("   |      O");
	        System.out.println("   |    --|--");
	        System.out.println("   |     ");
	        System.out.println("   |         ");
	        System.out.println("   |         ");
	        System.out.println("   |          ");
	        System.out.println("___|___       ");
	        break;
	      case 6:
	    	  System.out.println();
	        System.out.println("   ________");
	        System.out.println("   |      |");
	        System.out.println("   |      O");
	        System.out.println("   |    --|--");
	        System.out.println("   |     // ");
	        System.out.println("   |         ");
	        System.out.println("   |         ");
	        System.out.println("   |          ");
	        System.out.println("___|___       ");
	        break;
	      case 7:
	    	  System.out.println();
	        System.out.println("   ________");
	        System.out.println("   |      |");
	        System.out.println("   |      O");
	        System.out.println("   |    --|--");
	        System.out.println("   |     // \\ ");
	        System.out.println("   |         ");
	        System.out.println("   |         ");
	        System.out.println("   |          ");
	        System.out.println("___|___       ");
	        break;
	      default:
	        break;
	    }
	  }
}
