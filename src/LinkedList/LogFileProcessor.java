import java.io.*;
import java.util.*;
import java.util.regex.*;

public class LogFileProcessor {
    public static void main(String[] args) {
        String logFilePath = "/home/apple/IdeaProjects/backup/Problem_Solving_With_Java/src/LinkedList/Log_File.txt";
        String mainLogFilePath = "/home/apple/IdeaProjects/backup/Problem_Solving_With_Java/src/LinkedList/Main_Log.txt";


        // Initialize frequency maps
        Map<String, Integer> freqDic = new HashMap<>();
        Map<String, Integer> freqDic2 = new HashMap<>();
        Map<String, List<String>> notPres = new HashMap<>();

        try {
            // Read Log_File.txt
            List<String> logLines = readLinesFromFile(logFilePath);

            // Process each line in Log_File.txt to populate freqDic
            for (String logLine : logLines) {
                if (logLine.contains("SRS")) {
                    String srsId = logLine.split("SRS-")[1].trim();
                    String srsKey = "SRS-" + srsId;
                    freqDic.put(srsKey, freqDic.getOrDefault(srsKey, 0) + 1);
                }
            }

            // Read Main_Log.txt content
            String mainLogContent = readFileContent(mainLogFilePath);

            // Process each line in Log_File.txt to compare with Main_Log.txt and populate freqDic2 and notPres
            for (String logLine : logLines) {
                String logLineStripped = logLine.split("SRS-6")[0].trim();
                if (logLine.contains("SRS")) {
                    String srsId = logLine.split("SRS")[1].trim();
                    String srsKey = "SRS" + srsId;

                    if (mainLogContent.contains(logLineStripped)) {
                        freqDic2.put(srsKey, freqDic2.getOrDefault(srsKey, 0) + 1);
                    } else {
                        freqDic2.put(srsKey, 0);
                        notPres.computeIfAbsent(srsKey, k -> new ArrayList<>()).add(logLineStripped);
                    }
                }
            }

            // Write results to output.txt
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("/home/apple/IdeaProjects/backup/Problem_Solving_With_Java/src/LinkedList/output.txt"))) {
                for (Map.Entry<String, Integer> entry : freqDic2.entrySet()) {
                    String id = entry.getKey();
                    int value = entry.getValue();

                    if (value >= freqDic.getOrDefault(id, 0)) {
                        writer.write(id + " is met\n");
                    } else {
                        writer.write(notPres.get(id) + " " + id + ": is NOT met\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Helper function to read lines from a file into a List
    private static List<String> readLinesFromFile(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }

    // Helper function to read the entire content of a file into a String
    private static String readFileContent(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    // Function to extract SRS ID using regex (not used directly in this code)
    private static String extractSrsId(String line) {
        Pattern pattern = Pattern.compile("SRS-\\d+");
        Matcher matcher = pattern.matcher(line);
        return matcher.find() ? matcher.group(0) : null;
    }
}
