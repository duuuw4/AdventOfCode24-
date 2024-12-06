import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day2 {
    public static int day2Solution(int[][] lines) {
        int result = 0;

        for (int[] line : lines) {
            boolean isSafe = true;

            for (int j = 0; j < line.length - 1; j++) {
                if (Math.abs(line[j] - line[j + 1]) > 3 || Math.abs(line[j] - line[j + 1]) == 0) {
                    isSafe = false;
                    break;
                }
            }

            if (isSafe) {
                boolean allIncreasing = true;
                boolean allDecreasing = true;

                for (int j = 0; j < line.length - 1; j++) {
                    if (line[j] >= line[j + 1]) {
                        allIncreasing = false;
                    }
                    if (line[j] <= line[j + 1]) {
                        allDecreasing = false;
                    }
                }

                if (!allIncreasing && !allDecreasing) {
                    isSafe = false;
                }
            }

            if (isSafe) {
                result++;
            }
        }

        return result;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("./day2/src/inputDay2.txt"));
        String line;

        List<int[]> temp1 = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            temp1.add(Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        reader.close();

        int[][] arr = temp1.toArray(new int[0][]);

        System.out.println(day2Solution(arr));
    }
}
