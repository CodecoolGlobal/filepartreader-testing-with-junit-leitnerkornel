import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWordAnalyzer {
    FilePartReader inputData;

    public FileWordAnalyzer(FilePartReader reader) {
        this.inputData = reader;
    }

    public List<String> getWordsOrderedAlphabetically() {
        String inputText = inputData.readLines();
        List<String> words = Arrays.asList(inputText.split("[^a-zA-Z0-9]+"));
        words.sort(String::compareToIgnoreCase);

        return words;
    }

    public List<String> getWordsContainingSubstring(String subString) {
        String inputText = inputData.readLines();
        String[] words = inputText.split("[^a-zA-Z0-9]+");
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (word.toLowerCase().contains(subString.toLowerCase())) {
                result.add(word);
            }
        }

        return result;
    }

    public List<String> getStringWhichPalindromes() {
        String inputText = inputData.readLines();
        String[] words = inputText.split("[^a-zA-Z0-9]+");
        List<String> result = new ArrayList<>();

        for (String word : words) {
            if (word.toLowerCase().equals(new StringBuilder(word.toLowerCase()).reverse().toString())) {
                result.add(word);
            }
        }

        return result;
    }
}