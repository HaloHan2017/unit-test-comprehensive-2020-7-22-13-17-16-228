package example;

import java.util.Random;

public class AnswerGenerator implements IGenerator {
    @Override
    public String generateAnswer() {
        char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Random random = new Random();
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            char c = chars[random.nextInt(chars.length)];
            if (stringBuilder.indexOf(c + "") == -1) {
                stringBuilder.append(c);
                count++;
                if (count == 4) {
                    break;
                }
            }

        }
        return stringBuilder.toString();
    }
}
