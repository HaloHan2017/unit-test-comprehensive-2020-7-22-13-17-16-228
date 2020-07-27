package example;

import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GuessNumberGame {
    private static final String THE_FLAG_OF_WIN = "4A0B";
    private String answer;

    public GuessNumberGame(AnswerGenerator answerGenerator) throws NoSuchAlgorithmException {
        this.answer = answerGenerator.generateAnswer();
    }

    public void playGuessGame() {
        int guessCount = 0;
        Scanner input = new Scanner(System.in);
        while (guessCount <= 6) {
            System.out.print("Please enter your number (separated by Spaces) :");
            String result = guess(input.nextLine().replace(" ", ""));
            System.out.println(result);
            if (!THE_FLAG_OF_WIN.equals(result)) {
                guessCount++;
            } else {
                System.out.println("Congratulations on your victory!!!");
                input.close();
                return;
            }
        }
        System.out.println("Six chances have been used up. It's a pity that you didn't win the game. Keep up the good work");
        input.close();
    }

    public String guess(String number) {
        if (!isNumberValid(number)) {
            return "Wrong Input，Input again";
        }
        int countRightPositionAndRightNumber = 0;
        int countRightPositionAndWrongNumber = 0;
        for (int i = 0; i < number.length(); i++) {
            int index = answer.indexOf(number.charAt(i));
            if(index != -1 && index == i){
                countRightPositionAndRightNumber++;
            }else if(index != -1 && index != i){
                countRightPositionAndWrongNumber++;
            }
        }
        return String.format("%dA%dB", countRightPositionAndRightNumber, countRightPositionAndWrongNumber);
    }

    private boolean isNumberValid(String number) {
        return number.length() == 4 && number.matches("[0-9]+") && !isContainsDuplicateStr(number);
    }

    private boolean isContainsDuplicateStr(String number) {
        Set<Character> set = new HashSet<>();
        char[] chars = number.toCharArray();
        for (char c : chars) {
            set.add(c);
        }
        return set.size() != number.length();
    }
}
