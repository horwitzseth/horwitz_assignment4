import java.io.*;
import java.util.*;

public class DuplicateCounter {
    Map<String, Integer> wordCounter = new HashMap<String, Integer>();

    public void count (String dataFile) {
        Scanner in = null;
        try {
            File file = new File(dataFile);
            in = new Scanner(file);
            String word = new String();
            while(in.hasNext()) {
                word = in.next();
                String removePunct = word.replaceAll("\\W", "");
                if(wordCounter.containsKey(removePunct.toLowerCase())){
                    int count = wordCounter.get(removePunct.toLowerCase());
                    wordCounter.put(removePunct.toLowerCase(), count + 1);
                }
                else {
                    wordCounter.put(removePunct.toLowerCase(), 1);
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error, can't find file\n");
            System.exit(1);
        }
        finally {
            if (in != null) {
                in.close();
            }
        }
    }

    public void write (String outputFile) {
        FileWriter out = null;
        try {
            out = new FileWriter(outputFile);
            for (Map.Entry< String,Integer> entry : wordCounter.entrySet()) {
                out.write(entry.getKey() + ":" + entry.getValue() + "\n");
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error, could not find file!");
            System.exit(1);
        }
        catch (IOException e) {
            System.out.println("Error, could not open FileWriter!");
            System.exit(1);
        }
        finally {
            try {
                if (out != null) {
                    out.close();
                }
            }
            catch (IOException e) {
                System.out.println("Error, could not close FileWriter!");
                System.exit(1);
            }
        }
    }
}
