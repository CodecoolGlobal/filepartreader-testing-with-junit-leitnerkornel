public class Main {
    public static void main(String[] args) {
        FilePartReader inputText = new FilePartReader();
        inputText.setup("src/main/resources/sample.txt", 1, 102);
        System.out.println(inputText.readLines());
    }

}
