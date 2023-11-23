import java.util.Scanner;
import java.util.Random;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of words");
        int NumberWords = input.nextInt();
        System.out.println("Number of words is " + NumberWords);
        String words[] = new String[NumberWords];
        //System.out.println("Player 1! Enter " + NumberWords + " words");

        for (int i = 0; i < NumberWords; i++) {
            System.out.println("Player 1! Enter " + (i + 1) + " word");
            words[i] = input.next();
        }

        Random random = new Random();
        int randomIndex = random.nextInt(words.length);
        String randomWord = words[randomIndex];

        System.out.println("Player 2! Guess the word! Player 1 guessed the word:");

        int lengthRandomWord = randomWord.length();
        char[] guessedWord = new char[lengthRandomWord];

        for (int i = 0; i < lengthRandomWord; i++) {
            guessedWord[i] = '*';
        }
        System.out.println(String.valueOf(guessedWord));
        System.out.println("In how many attempts can you guess the word?");

        int attempts = input.nextInt();

        for (int i = 0; i < attempts; i++) {
            System.out.println("Your word is " + String.valueOf(guessedWord));
            System.out.println(" ");
            System.out.println("Attempts # " + (i + 1));
            System.out.println("Enter your char");

            char letter = input.next().charAt(0);

            if (randomWord.contains(String.valueOf(letter))) {
                System.out.println("You guessed the letter!");
                for (int k = 0; k < lengthRandomWord; k++) {
                    if (randomWord.charAt(k) == letter) {
                        guessedWord[k] = letter;
                    }
                }
            } else {
                System.out.println("Sorry, you didn't guess the letter!");
                System.out.println(" ");
            }

            if (attempts == (i + 1)) {
                System.out.println("Sorry, you didn't guess the word! Player 1 guessed the word:  " + randomWord);
            }

            if (randomWord.equals(String.valueOf(guessedWord))) {
                System.out.println("Congratulations, you guessed the word! Player 1 guessed the word:   " + randomWord);
                break;
            }
        }

        input.close();
    }
}