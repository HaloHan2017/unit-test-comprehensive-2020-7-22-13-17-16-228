package example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class GuessNumberGame {
    private String answer;

    public GuessNumberGame(AnswerGenerator answerGenerator) {
        this.answer = answerGenerator.generateAnswer();
    }

    public void playGuessGame() {
        int guessCount = 0;
        while (guessCount <= 6) {
            System.out.print("请输入您的数字（数字之间以空格隔开）：");
            Scanner input = new Scanner(System.in);
            String result = guess(input.nextLine().replace(" ", ""));
            System.out.println(result);
            if (!"4A0B".equals(result)) {
                guessCount++;
            } else {
                System.out.println("恭喜您赢得胜利！！！");
                return;
            }
        }
        System.out.println("6次机会已用完，很遗憾您没能赢得比赛，继续加油吧~~~");
    }

    public String guess(String number) {
        if (!isNumberValid(number)) {
            return "Wrong Input，Input again";
        }
        char[] numberCharArray = number.toCharArray();
        char[] answerCharArray = answer.toCharArray();
        int countOfNumber = countIfNumberIsRightButPositionIsWrong(numberCharArray, answerCharArray);
        int countOfPosition = countIfPositionIsRight(numberCharArray, answerCharArray);
        return String.format("%dA%dB", countOfPosition, countOfNumber);
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

    private int countIfPositionIsRight(char[] numberArr, char[] answerArr) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if (answerArr[i] == numberArr[i]) {
                count++;
            }
        }
        return count;
    }

    private int countIfNumberIsRightButPositionIsWrong(char[] numberArr, char[] answerArr) {
        int count = 0;
        for (int i = 0; i < answerArr.length; i++) {
            for (int j = 0; j < numberArr.length; j++) {
                if (answerArr[i] == numberArr[j] && i != j) {
                    count++;
                }
            }
        }
        return count;
    }
}
