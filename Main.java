import java.util.*;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        String[] wordList = {"wizard","witch", "spell", "potion", "spell", "wand","crystal" };
        int playerScore = 0;
        boolean keepPlaying = true;

        System.out.println("Welcome to word scramble wizard!");
        System.out.println("Unscramble the words to earn points:");

        while (keepPlaying){
            String word = wordList[random.nextInt(wordList.length)];
            String wordScrambled = WordScrambler(word,random);
            System.out.println("Unscramble the word " + wordScrambled);
            boolean wordGuessed = false;
            int attempts = 3;
            while (attempts > 0 && !wordGuessed){
                String playerGuess = scanner.nextLine();
                if (playerGuess.equalsIgnoreCase(word)){
                    System.out.println("You've guessed the word correctly!");
                    playerScore++;
                    wordGuessed = true;
                }else{
                    attempts--;
                    System.out.println("Wrong!the correct word is " + word);
                    System.out.println("You have " + attempts + " left");
                }
            }
            System.out.println("Your current score is " + playerScore);
            System.out.println("Would you like to keep playing?(yes/no)");
            String keepPlayingAnswer = scanner.nextLine();
            if(!keepPlayingAnswer.equalsIgnoreCase("yes")){
                keepPlaying = false;
                System.out.println("Thank you for playing! your score is " + playerScore);
            };



//            System.out.println(word);
        }





//        TestMethod(scanner.nextLine(), scanner.nextInt());
        scanner.close();

    }
    public static String WordScrambler(String word,Random random){
        char[] letters = word.toCharArray();
        for (int i = 0; i < letters.length; i++) {
            int j = random.nextInt(letters.length);
            char temp = letters[i];
            letters[i] = letters[j];
            letters[j] = temp;
        }
        return new String(letters);
    }
    }

