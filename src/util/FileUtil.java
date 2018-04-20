package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileUtil
{
    public static String NEWLINE = System.getProperty("line.separator");

    /**
     * Read a file given a file name and return a list of the lines within the file
     *
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

    public static void writeFile(List<String> lineList, String filePath)
    {
        try
        {
            // todo refactor to avoid clearing and instead simply append or overwrite existing text in file
            // Clear file
            new PrintWriter(filePath).close();

            FileWriter fileWriter = new FileWriter(filePath);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (String line : lineList)
            {
                bufferedWriter.write(line + NEWLINE);
            }

            bufferedWriter.close();
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Unable to open file '" + filePath + "'");
        }
        catch (IOException ex)
        {
            System.out.println("Error reading file '" + filePath + "'");
        }
    }
}
