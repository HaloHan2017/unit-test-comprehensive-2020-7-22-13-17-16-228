package example;

public class GuessNumberGame {
    private String answer;
    private IGenerator answerGenerator = new AnswerGenerator();

    public GuessNumberGame() {
        this.answer = answerGenerator.generateAnswer();
    }

    public String guess(String number) {
        // 拿到 number 和 answer，将其转换成 int[]
        int[] numberArr = convertNumberStringToArray(number);
        int[] answerArr = convertNumberStringToArray(answer);
        // 计算 数字对 的 数量
        int countOfNumber = countIfNumberIsRightButPositionIsWrong(numberArr, answerArr);
        // 计算 位置对 的 数量 （位置对的，数字一定对）
        int countOfPosition = countIfPositionIsRight(numberArr, answerArr);
        return String.format("%dA%dB",countOfPosition,countOfNumber);
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
        public String generateAnswer() {
            return "1234";
        }
    }
}
