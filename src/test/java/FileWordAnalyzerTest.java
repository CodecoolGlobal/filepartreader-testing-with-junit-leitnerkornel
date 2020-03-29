import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class FileWordAnalyzerTest {
    @Test
    public void testIsParameterTypeCorrectInConstructor() {
        FilePartReader reader = new FilePartReader();
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        assertEquals(FilePartReader.class, analyzer.inputData.getClass());
    }

    @Test
    public void testIsAlphabeticalOrderCorrectInCaseOfLettersOnly() {
        List<String> correct = new ArrayList<>(Arrays.asList("below", "box", "can", "may", "paste", "seem", "small", "the", "though", "tons", "you"));
        FilePartReader reader = new FilePartReader();
        reader.setup("src/test/resources/abc_order.txt", 2, 2);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        assertEquals(correct, analyzer.getWordsOrderedAlphabetically());
    }

    @Test
    public void testIsAlphabeticalOrderCorrectInCaseOfLettersAndCharacters() {
        List<String> correct = new ArrayList<>(Arrays.asList("be", "box", "can", "low", "may", "seem", "small", "the", "you"));
        FilePartReader reader = new FilePartReader();
        reader.setup("src/test/resources/abc_order.txt", 4, 4);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        assertEquals(correct, analyzer.getWordsOrderedAlphabetically());
    }

    @Test
    public void testIsAlphabeticalOrderCorrectInCaseOfLettersAndCharactersAndNumbers() {
        List<String> correct = new ArrayList<>(Arrays.asList("1", "10", "11", "111", "12", "5", "55", "be", "box", "can", "low", "may", "seem", "small55", "the", "you"));
        FilePartReader reader = new FilePartReader();
        reader.setup("src/test/resources/abc_order.txt", 6, 6);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        assertEquals(correct, analyzer.getWordsOrderedAlphabetically());
    }

    @Test
    public void testIsSubstringCorrectOnlyLowerCaseLetters() {
        List<String> correct = new ArrayList<>(Arrays.asList("helloka", "helloszia", "hellobello", "nahello", "ishellono"));
        FilePartReader reader = new FilePartReader();
        reader.setup("src/test/resources/substring.txt", 1, 1);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        assertEquals(correct, analyzer.getWordsContainingSubstring("hello"));
    }

    @Test
    public void testIsSubstringCorrectCapitalAndLowerAndNumbers() {
        List<String> correct = new ArrayList<>(Arrays.asList("helloka", "helloszia", "123hellobello12", "ishellon23o", "12heLLO", "HELLO"));
        FilePartReader reader = new FilePartReader();
        reader.setup("src/test/resources/substring.txt", 2, 2);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        assertEquals(correct, analyzer.getWordsContainingSubstring("hello"));
    }

    @Test
    public void testIsPalindromeLetters() {
        List<String> correct = new ArrayList<>(Arrays.asList("level", "racecar", "sagas", "solos", "modom"));
        FilePartReader reader = new FilePartReader();
        reader.setup("src/test/resources/palindromes.txt", 1, 1);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        assertEquals(correct, analyzer.getStringWhichPalindromes());
    }

    @Test
    public void testIsPalindromeLettersNumbersAndCapitalLetters() {
        List<String> correct = new ArrayList<>(Arrays.asList("leveL", "123321", "RaCeCar", "Sagas", "solos", "1111", "1modom1"));
        FilePartReader reader = new FilePartReader();
        reader.setup("src/test/resources/palindromes.txt", 2, 2);
        FileWordAnalyzer analyzer = new FileWordAnalyzer(reader);
        assertEquals(correct, analyzer.getStringWhichPalindromes());
    }
}