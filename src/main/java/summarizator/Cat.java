package summarizator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Cat {

    public void cat(File file) throws IOException {
        BufferedReader r = null;
        try {
            r = new BufferedReader(new FileReader(file));
            String line;
            while ((line = r.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            throw e;
        } finally {
            try {
                if (r != null) {
                    r.close();
                }
            } catch (IOException e) {
                throw e;
            }
        }

    }
}

