import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class App {
    public static void main(String[] args) throws Exception {
        String fileName = "input.txt";
        String[] words = {"hello", "world", "java"};
        Random random = new Random();
        int numOfLines = 100;
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))) {
            for(int i = 0; i < numOfLines; i++) {
                bufferedWriter.write(words[random.nextInt(words.length)] + "\n");
            }
        }

        String line;
        Map<String, Integer> counts = new TreeMap<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while((line = bufferedReader.readLine()) != null) {
                if(counts.containsKey(line)) {
                    counts.put(line, counts.get(line) + 1);
                } else {
                    counts.put(line, 1);
                }
            }
        }

        String outFileName = "output.txt";
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outFileName))) {
            for (Entry<String, Integer> entry: counts.entrySet()) {
                bufferedWriter.write(entry.getKey() + " " + entry.getValue() + "\n");
            }
        }



    }
}
