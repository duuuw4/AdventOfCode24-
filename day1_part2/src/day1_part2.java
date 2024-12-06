import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class day1_part2 {

    public static int day1_p2Solution(int[] arr1, int[] arr2) {
        int result = 0;

        Map<Integer, Long> counter = Arrays.stream(arr2)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        for (int value : arr1) {
            result += value * counter.getOrDefault(value, 0L);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("./day1_part2/src/input.txt"));
        String line;

        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\s+");
            temp1.add(Integer.parseInt(parts[0]));
            temp2.add(Integer.parseInt(parts[1]));
        }
        reader.close();

        int[] left = temp1.stream().mapToInt(i -> i).toArray();
        int[] right = temp2.stream().mapToInt(i -> i).toArray();

        System.out.println(day1_p2Solution(left, right));
    }
}
