package example;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

    @Test
    public void should_return_0A0B_when_guess_5678_given_1234() {
        // given
        GuessNumberGame guessNumberGame = new GuessNumberGame();
        // when
        String result = guessNumberGame.guess("5678");
        // then
        assertEquals("0A0B", result);
    }

    @Test
    public void should_return_true_when_invoke_isNumberValid_given_1357() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        GuessNumberGame guessNumberGame = new GuessNumberGame();
        Method method = GuessNumberGame.class.getDeclaredMethod("isNumberValid",String.class);
        method.setAccessible(true);
        // when
        Boolean result = (Boolean) method.invoke(guessNumberGame, "1357");
        // then
        assertEquals(true, result);
    }

    @Test
    public void should_return_false_when_invoke_isNumberValid_given_135_and_135a_and_1355() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // given
        GuessNumberGame guessNumberGame = new GuessNumberGame();
        Method method = GuessNumberGame.class.getDeclaredMethod("isNumberValid",String.class);
        method.setAccessible(true);
        // when
        Boolean result1 = (Boolean) method.invoke(guessNumberGame, "135");
        Boolean result2 = (Boolean) method.invoke(guessNumberGame, "135a");
        Boolean result3 = (Boolean) method.invoke(guessNumberGame, "1355");
        // then
        assertEquals(false, result1);
        assertEquals(false, result2);
        assertEquals(false, result3);
    }
}
