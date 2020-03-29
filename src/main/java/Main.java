public class Main {
    public static void main(String[] args) {
        FilePartReader inputText = new FilePartReader();
        inputText.setup("src/main/resources/sample.txt", 1, 100);

        String substring = "s";

        FileWordAnalyzer analyzer = new FileWordAnalyzer(inputText);
        System.out.println("Alphabetically ordered words");
        System.out.println(analyzer.getWordsOrderedAlphabetically());
        System.out.println("\nWords what are containing the given substring (" + substring + ") - Case insensitive: ");
        System.out.println(analyzer.getWordsContainingSubstring(substring));
        System.out.println("\nPalindrome words");
        System.out.println(analyzer.getStringWhichPalindromes());
    }
}
