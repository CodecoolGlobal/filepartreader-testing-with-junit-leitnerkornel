import java.io.*;

public class FilePartReader {
    protected String filePath;
    protected Integer fromLine;
    protected Integer toLine;

    public FilePartReader() {
        this.filePath = "invalid file path";
        this.fromLine = 12;
        this.toLine = 10;
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) {
        if (toLine < fromLine) throw new IllegalArgumentException("toLine can't be smaller than fromLine");
        if (fromLine < 1) throw new IllegalArgumentException("fromLine can't be smaller than 1");

        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    public String read() {
        File file = new File(filePath);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder result = new StringBuilder();
        try {
            String line;
            if (reader != null) {
                while ((line = reader.readLine()) != null) {
                    result.append(line).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public String readLines() {
        String inputText = read();
        String[] lines = inputText.split("[\\r\\n]+");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            if (i + 1 >= fromLine && i + 1 <= toLine) {
                result.append(lines[i]).append("\n");
            }
        }
        return result.toString();
    }
}