package assignmentB;

import util.FileUtil;
import java.util.List;

public class JsonUtil
{
    private static String getValFromLine(String line)
    {
        // Find the semicolon
        int i = findIndexOfCharInLine(':', line);

        // Trim
        line = line.substring(i, line.length());

        // Find the first double-quote character
        i = findIndexOfCharInLine('"', line);

        // Trim
        line = line.substring(i, line.length());

        // Find the next double-quote character
        i = findIndexOfCharInLine('"', line);

        // Trim
        line = line.substring(0, i - 1);

        return line;
    }

    public static String getValueForKeyFromFile(String key, String path)
    {
        // Get list of lines from file
        List<String> stringList = FileUtil.readFile(path);

        String v = "";

        for (String line : stringList)
        {
            // Skip enclosing braces
            if (!"{".equals(line) && !"}".equals(line))
            {
                // Find the line with the key
                String k = getKeyFromLine(line);

                // If we found it, then return
                if (k.equalsIgnoreCase(key))
                {
                    v = getValFromLine(line);
                    break;
                }
            }
        }

        return v;
    }

    private static int findIndexOfCharInLine(char cToFind, String line)
    {
        int index = 0;
        for (char c : line.toCharArray())
        {
            index++;
            if (c == cToFind)
            {
                break;
            }
        }
        return index;
    }

    private static String getKeyFromLine(String line)
    {
        // Find the first double-quote character
        int i = findIndexOfCharInLine('"', line);

        // Trim
        line = line.substring(i, line.length());

        // Find the next double-quote character
        i = findIndexOfCharInLine('"', line);

        // Trim
        line = line.substring(0, i - 1);

        return line;
    }

    // todo
    public static void setValueForKeyInFile(String key, String val, String path)
    {
        // Get list of lines from file
        List<String> stringList = FileUtil.readFile(path);

        boolean keyExists = false;
        for (String line : stringList)
        {
            // Skip enclosing braces
            if (!"{".equals(line) && !"}".equals(line))
            {
                // Find the line with the key
                String k = getKeyFromLine(line);

                // If we found it, then overwrite
                if (k.equalsIgnoreCase(key))
                {
                    System.out.print("\nFound key: " + key);
                    keyExists = true;
                    break;
                }
            }
        }
    }
}
