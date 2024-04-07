package labs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class gptF2 {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("grades.txt"));
            BufferedWriter writer = new BufferedWriter(new FileWriter("third.txt"));
            String line;

            // Initialize a map to store grade frequencies
            Map<Integer, Integer> gradeFrequency = new HashMap<>();

            // Read each line from the file
            while ((line = reader.readLine()) != null) {
                // Split the line into individual grades
                String[] grades = line.split(" ");

                // Process each grade
                for (String grade : grades) {
                    
                    int value = Integer.parseInt(grade);
                    // Increment the frequency count for this grade
                    gradeFrequency.put(value, gradeFrequency.getOrDefault(value, 0) + 1);
                }
            }

            // Print headers
            System.out.printf("%11s %11s\n", "GRADE", "FREQUENCY");
            System.out.println("-------------------------");

            // Print grade frequencies
            for (int i = 1; i <= 10; i++) {
                int frequency = gradeFrequency.getOrDefault(i, 0);
                System.out.printf("%8d %12d\n", i, frequency);
            }

            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
