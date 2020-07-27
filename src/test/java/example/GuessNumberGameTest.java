package example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

public class GuessNumberGameTest {

    public static final String MOCK_VALUE = "1234";

    @Test
    public void should_return_4A0B_when_guess_1234_given_1234() throws NoSuchAlgorithmException {
        AnswerGenerator answerGeneratorMock = Mockito.mock(AnswerGenerator.class);
        given(answerGeneratorMock.generateAnswer()).willReturn(MOCK_VALUE);
        // given
        GuessNumberGame guessNumberGame = new GuessNumberGame(answerGeneratorMock);
        // when
        String result = guessNumberGame.guess("1234");
        // then
        assertEquals("4A0B", result);
    }

    @Test
    public void should_return_1A1B_when_guess_1025_given_1234() throws NoSuchAlgorithmException {
        AnswerGenerator answerGeneratorMock = Mockito.mock(AnswerGenerator.class);
        given(answerGeneratorMock.generateAnswer()).willReturn(MOCK_VALUE);
        // given
        GuessNumberGame guessNumberGame = new GuessNumberGame(answerGeneratorMock);
        // when
        String result = guessNumberGame.guess("1025");
        // then
        assertEquals("1A1B", result);
    }

    @Test
    public void should_return_2A2B_when_guess_1243_given_1234() throws NoSuchAlgorithmException {
        AnswerGenerator answerGeneratorMock = Mockito.mock(AnswerGenerator.class);
        given(answerGeneratorMock.generateAnswer()).willReturn(MOCK_VALUE);
        // given
        GuessNumberGame guessNumberGame = new GuessNumberGame(answerGeneratorMock);
        // when
        String result = guessNumberGame.guess("1243");
        // then
        assertEquals("2A2B", result);
    }

    @Test
    public void should_return_0A4B_when_guess_4321_given_1234() throws NoSuchAlgorithmException {
        AnswerGenerator answerGeneratorMock = Mockito.mock(AnswerGenerator.class);
        given(answerGeneratorMock.generateAnswer()).willReturn(MOCK_VALUE);
        // given
        GuessNumberGame guessNumberGame = new GuessNumberGame(answerGeneratorMock);
        // when
        String result = guessNumberGame.guess("4321");
        // then
        assertEquals("0A4B", result);
    }

    @Test
    public void should_return_0A2B_when_guess_2107_given_1234() throws NoSuchAlgorithmException {
        AnswerGenerator answerGeneratorMock = Mockito.mock(AnswerGenerator.class);
        given(answerGeneratorMock.generateAnswer()).willReturn(MOCK_VALUE);
        // given
        GuessNumberGame guessNumberGame = new GuessNumberGame(answerGeneratorMock);
        // when
        String result = guessNumberGame.guess("2107");
        // then
        assertEquals("0A2B", result);
    }

    @Test
    public void should_return_0A0B_when_guess_5678_given_1234() throws NoSuchAlgorithmException {
        AnswerGenerator answerGeneratorMock = Mockito.mock(AnswerGenerator.class);
        given(answerGeneratorMock.generateAnswer()).willReturn(MOCK_VALUE);
        // given
        GuessNumberGame guessNumberGame = new GuessNumberGame(answerGeneratorMock);
        // when
        String result = guessNumberGame.guess("5678");
        // then
        assertEquals("0A0B", result);
    }

    @Test
    public void should_return_true_when_invoke_isNumberValid_given_1357() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchAlgorithmException {
        AnswerGenerator answerGeneratorMock = Mockito.mock(AnswerGenerator.class);
        given(answerGeneratorMock.generateAnswer()).willReturn(MOCK_VALUE);
        // given
        GuessNumberGame guessNumberGame = new GuessNumberGame(answerGeneratorMock);
        Method method = GuessNumberGame.class.getDeclaredMethod("isNumberValid", String.class);
        method.setAccessible(true);
        // when
        Boolean result = (Boolean) method.invoke(guessNumberGame, "1357");
        // then
        assertEquals(true, result);
    }


    // todo split the test case to 3
    @Test
    public void should_return_false_when_invoke_isNumberValid_given_135_and_135a_and_1355() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchAlgorithmException {
        // given
        AnswerGenerator answerGeneratorMock = Mockito.mock(AnswerGenerator.class);
        given(answerGeneratorMock.generateAnswer()).willReturn(MOCK_VALUE);
        // given
        GuessNumberGame guessNumberGame = new GuessNumberGame(answerGeneratorMock);
        Method method = GuessNumberGame.class.getDeclaredMethod("isNumberValid", String.class);
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

    @Test
    public void should_return_error_info_when_guess_number_is_not_valid_given_135_and_135a_and_1355() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchAlgorithmException {
        // given
        AnswerGenerator answerGeneratorMock = Mockito.mock(AnswerGenerator.class);
        given(answerGeneratorMock.generateAnswer()).willReturn(MOCK_VALUE);
        // given
        GuessNumberGame guessNumberGame = new GuessNumberGame(answerGeneratorMock);
        String errorInfo = "Wrong Input，Input again";
        // when
        String result1 = guessNumberGame.guess("135");
        String result2 = guessNumberGame.guess("135a");
        String result3 = guessNumberGame.guess("1355");
        // then
        assertEquals(errorInfo, result1);
        assertEquals(errorInfo, result2);
        assertEquals(errorInfo, result3);
    }
}
