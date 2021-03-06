package example;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

public class AnswerGenerator implements IGenerator {
    @Override
    public String generateAnswer() throws NoSuchAlgorithmException {
        char[] chars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Random random = SecureRandom.getInstanceStrong();
        int count = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            char randomChar = chars[random.nextInt(chars.length)];
            if (stringBuilder.indexOf(String.valueOf(randomChar)) == -1) {
                stringBuilder.append(randomChar);
                count++;
                if (count == 4) {
                    break;
                }
            }

        }
        return stringBuilder.toString();
    }
}
