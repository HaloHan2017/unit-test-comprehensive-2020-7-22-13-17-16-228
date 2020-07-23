package example;

public class GuessNumberGame {
    private String answer;
    private IGenerator answerGenerator = new AnswerGenerator();

    public GuessNumberGame() {
        this.answer = answerGenerator.generateAnswer();
    }

    public String guess(String number) {
        if(answer.equals(number)){
            return "4A0B";
        }
        return "1A1B";
    }

    private interface IGenerator{
        String generateAnswer();
    }

    private class AnswerGenerator implements IGenerator{
        public String generateAnswer() {
            return "";
        }
    }
}
