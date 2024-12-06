import java.io.*;
import java.util.regex.*;
import java.nio.file.*;


public class day3 {
    public static void main(String[] args) throws IOException {
        String filePath = "./day3/src/input3.txt";
        String corruptedMemory = Files.readString(Path.of(filePath));

        String regex = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(corruptedMemory);

        int totalSum = 0;

        while (matcher.find()) {
            int x = Integer.parseInt(matcher.group(1));
            int y = Integer.parseInt(matcher.group(2));
            totalSum += x * y;
        }

        System.out.println(totalSum);
    }
}

