package example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessNumberGameTest {
    private final String answer = "1234";
    @Test
    public void should_return_4A0B_when_guess_1234_given_1234() {
        // given
        GuessNumberGame guessNumberGame = new GuessNumberGame(answer);
        // when
        String result = guessNumberGame.guess("1234");
        // then
        assertEquals("4A0B", result);
    }

    @Test
    public void should_return_1A1B_when_guess_1025_given_1234() {
        // given
        GuessNumberGame guessNumberGame = new GuessNumberGame(answer);
        // when
        String result = guessNumberGame.guess("1234");
        // then
        assertEquals("1A1B", result);
    }
}
