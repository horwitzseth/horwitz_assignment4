import java.io.*;
import java.util.*;

public class DuplicateRemover {
    public Set<String> uniqueWords = new LinkedHashSet<>();

    public void remove (String dataFile) {
        Scanner in = null;

        try {
            File file = new File(dataFile);
            in = new Scanner(file);
            String word;
            while(in.hasNextLine()) {
                word = in.next();
                String removePunct = word.replaceAll("\\W", "");
                uniqueWords.add(removePunct.toLowerCase());
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
            for (String s : uniqueWords) {
                out.write(s + " ");
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
