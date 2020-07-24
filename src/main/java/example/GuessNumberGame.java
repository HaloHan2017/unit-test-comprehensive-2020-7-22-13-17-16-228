package example;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class GuessNumberGame {
    private String answer;
    private IGenerator answerGenerator = new AnswerGenerator();

    public GuessNumberGame() {
        this.answer = answerGenerator.generateAnswer();
    }

    public void playGuessGame(){
        int guessCount = 0;
        while (guessCount <= 6){
            System.out.print("请输入您的数字（数字之间以空格隔开）：");
            Scanner input = new Scanner(System.in);
            String result = guess(input.nextLine().replaceAll(" ",""));
            System.out.println(result);
            if(!"4A0B".equals(result)){
                guessCount++;
            }else {
                System.out.println("恭喜您赢得胜利！！！");
                return;
            }
        }
        System.out.println("6次机会已用完，很遗憾您没能赢得比赛，继续加油吧~~~");
    }

    public String guess(String number) {
        if(!isNumberValid(number)){
            return "Wrong Input，Input again";
        }
        int[] numberArr = convertNumberStringToArray(number);
        int[] answerArr = convertNumberStringToArray(answer);
        int countOfNumber = countIfNumberIsRightButPositionIsWrong(numberArr, answerArr);
        int countOfPosition = countIfPositionIsRight(numberArr, answerArr);
        return String.format("%dA%dB",countOfPosition,countOfNumber);
    }

    private boolean isNumberValid(String number) {
        return number.length() == 4 && number.matches("[0-9]+") && !isContainsDuplicateStr(number);
    }

    private boolean isContainsDuplicateStr(String number) {
        Set<Character> set = new HashSet<>();
        char[] chars = number.toCharArray();
        for(char c:chars) {
            set.add(c);
        }
        return set.size() != number.length();
    }

    private int countIfPositionIsRight(int[] numberArr, int[] answerArr) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            if(answerArr[i] == numberArr[i]){
                count++;
            }
        }
        return count;
    }

    private int countIfNumberIsRightButPositionIsWrong(int[] numberArr, int[] answerArr) {
        int count = 0;
        for (int i = 0; i < answerArr.length; i++) {
            for (int j = 0; j < numberArr.length; j++) {
                if(answerArr[i] == numberArr[j] && i != j){
                    count++;
                }
            }
        }
        return count;
    }

    private int[] convertNumberStringToArray(String number) {
        int[] array = new int[number.length()];
        char[] chars = number.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            array[i] = Integer.valueOf(String.valueOf(chars[i]));
        }
        return array;
    }

    public interface IGenerator{
        String generateAnswer();
    }

    public class AnswerGenerator implements IGenerator{
        @Override
        public String generateAnswer() {
            return "1234";
//            char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
//            Random random = new Random();
//            int count = 0;
//            StringBuilder stringBuilder = new StringBuilder();
//            while (true) {
//                char c = chars[random.nextInt(chars.length)];
//                if (stringBuilder.indexOf(c + "") == -1) {
//                    stringBuilder.append(c);
//                    count++;
//                    if (count == 4) {
//                        break;
//                    }
//                }
//
//            }
//            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        GuessNumberGame guessNumberGame = new GuessNumberGame();
        guessNumberGame.playGuessGame();
    }
}
