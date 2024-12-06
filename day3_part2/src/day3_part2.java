import java.io.*;
import java.util.regex.*;
import java.nio.file.*;

public class day3_part2 {
    public static void main(String[] args) throws IOException {
        String filePath = "./day3_part2/src/input3.txt";
        String corruptedMemory = Files.readString(Path.of(filePath));

        String regex = "(mul\\((\\d{1,3}),(\\d{1,3})\\))|(do\\(\\))|(don't\\(\\))";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(corruptedMemory);

        int totalSum = 0;
        boolean isEnabled = true;

        while (matcher.find()) {
            if (matcher.group(1) != null) {
                if (isEnabled) {
                    int x = Integer.parseInt(matcher.group(2));
                    int y = Integer.parseInt(matcher.group(3));
                    totalSum += x * y;
                }
            } else if (matcher.group(4) != null) {
                isEnabled = true;
            } else if (matcher.group(5) != null) {
                isEnabled = false;
            }
        }

        System.out.println(totalSum);
    }
}
