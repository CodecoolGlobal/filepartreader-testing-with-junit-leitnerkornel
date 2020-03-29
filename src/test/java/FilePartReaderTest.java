import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

class FilePartReaderTest {
    @Test
    public void testIsToLineSmallerThanFromLineThrowException() {
        FilePartReader reader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> reader.setup("sample.txt", 10, 6));
    }

    @Test
    public void testIsFromLineSmallerThan1ThrowException() {
        FilePartReader reader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, () -> reader.setup("sample.txt", 0, 6));
    }

    @Test
    public void testIsFilePresentThrowIOException() {
        FilePartReader reader = new FilePartReader();
        reader.setup("src/test/resources/non_exist.txt", 1, 10);
        assertThrows(IOException.class, reader::read);
    }

    @Test
    public void testIsReadingDataCorrect() {
        String correct = "Hello, this is a test file.\nAnd this is the second line.\n";

        FilePartReader reader = new FilePartReader();
        reader.setup("src/test/resources/test_data.txt", 1, 5);
        String actual = null;
        try {
            actual = reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertEquals(correct, actual);
    }

    @Test
    public void testIsReadOnlyTheFirstLine() {
        String correct = "Hello, this is a test file.\n";

        FilePartReader reader = new FilePartReader();
        reader.setup("src/test/resources/test_data.txt", 1, 1);

        assertEquals(correct, reader.readLines());
    }

    @Test
    public void testIsReadOnlyTheSecondLine() {
        String correct = "And this is the second line.\n";

        FilePartReader reader = new FilePartReader();
        reader.setup("src/test/resources/test_data.txt", 2, 2);

        assertEquals(correct, reader.readLines());
    }

    @Test
    public void testIsReadOnlyBetweenTheFifthAndSeventhLines() {
        String correct = "And this is the fifth line.\n" +
                "And this is the sixth line.\n" +
                "And this is the seventh line.\n";

        FilePartReader reader = new FilePartReader();
        reader.setup("src/test/resources/longer_test_data.txt", 5, 7);

        assertEquals(correct, reader.readLines());
    }

    @Test
    public void testIsReadLinesHandleWrongFilePathThrowIOException() {
        FilePartReader reader = new FilePartReader();
        reader.setup("src/test/resources/non_exist.txt", 1, 10);
        assertEquals("\n", reader.readLines());
    }
}