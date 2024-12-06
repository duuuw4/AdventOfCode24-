import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class day1 {


    public static int day1Solution(int[] arr1, int[] arr2) {
        int result=0;
        for(int i = 0; i < arr1.length; i++){
            result+=Math.abs(arr1[i]-arr2[i]);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("./day1/src/input.txt"));
        String line;

        List<Integer> temp1 = new ArrayList<>();
        List<Integer> temp2 = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            temp1.add(Integer.valueOf(line.split("   ")[0]));
            temp2.add(Integer.valueOf(line.split("   ")[1]));
        }
        reader.close();

        Collections.sort(temp1);
        Collections.sort(temp2);

        int[] left = temp1.stream().mapToInt(i->i).toArray();
        int[] right = temp2.stream().mapToInt(i->i).toArray();
        System.out.println(day1Solution(left, right));
    }
}