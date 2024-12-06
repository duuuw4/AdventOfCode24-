import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class day2_part2 {
    public static int day2_p2Solution(int[][] lines) {
        int result = 0;

        for (int[] line : lines) {
            if (isSafe(line)) {
                result++;
            } else {
                for (int i = 0; i < line.length; i++) {
                    int[] modifiedLine = removeLevel(line, i);
                    if (isSafe(modifiedLine)) {
                        result++;
                        break;
                    }
                }
            }
        }

        return result;
    }

    private static boolean isSafe(int[] line) {
        for (int j = 0; j < line.length - 1; j++) {
            if (Math.abs(line[j] - line[j + 1]) > 3 || Math.abs(line[j] - line[j + 1]) == 0) {
                return false;
            }
        }

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

        return allIncreasing || allDecreasing;
    }

    private static int[] removeLevel(int[] line, int index) {
        int[] newLine = new int[line.length - 1];
        for (int i = 0, k = 0; i < line.length; i++) {
            if (i != index) {
                newLine[k++] = line[i];
            }
        }
        return newLine;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("./day2_part2/src/inputDay2.txt"));
        String line;

        List<int[]> temp1 = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            temp1.add(Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        reader.close();

        int[][] arr = temp1.toArray(new int[0][]);

        System.out.println(day2_p2Solution(arr));
    }
}
