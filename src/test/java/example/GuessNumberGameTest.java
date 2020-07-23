package example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GuessNumberGameTest {
    @Test
    public void should_return_4A0B_when_guess_1234_given_1234() {
        // given
        GuessNumberGame guessNumberGame = new GuessNumberGame();
        // when
        String result = guessNumberGame.guess("1234");
        // then
        assertEquals("4A0B", result);
    }

    @Test
    public void should_return_1A1B_when_guess_1025_given_1234() {
        // given
        GuessNumberGame guessNumberGame = new GuessNumberGame();
        // when
        String result = guessNumberGame.guess("1025");
        // then
        assertEquals("1A1B", result);
    }

    @Test
    public void should_return_2A2B_when_guess_1243_given_1234() {
        // given
        GuessNumberGame guessNumberGame = new GuessNumberGame();
        // when
        String result = guessNumberGame.guess("1243");
        // then
        assertEquals("2A2B", result);
    }

    @Test
    public void should_return_0A4B_when_guess_4321_given_1234() {
        // given
        GuessNumberGame guessNumberGame = new GuessNumberGame();
        // when
        String result = guessNumberGame.guess("4321");
        // then
        assertEquals("0A4B", result);
    }

    @Test
    public void should_return_0A2B_when_guess_2107_given_1234() {
        // given
        GuessNumberGame guessNumberGame = new GuessNumberGame();
        // when
        String result = guessNumberGame.guess("2107");
        // then
        assertEquals("0A2B", result);
    }

}
