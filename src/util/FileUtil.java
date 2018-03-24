package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtil
{
    /**
     * Read a file given a file name and return a list of the lines within the file
     * @param fileName the filename to read
     * @return a list of the lines within the file
     */
    public static List<String> readFile(String fileName)
    {
        List<String> stringList = new ArrayList<>();
        String line;

        try
        {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null)
            {
                System.out.println(line);
                stringList.add(line);
            }

            bufferedReader.close();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Unable to open file '" + fileName + "'");
        }
        catch (IOException ex)
        {
            System.out.println("Error reading file '" + fileName + "'");
        }

        return stringList;
    }
}
