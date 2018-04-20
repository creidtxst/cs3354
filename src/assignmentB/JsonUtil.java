package assignmentB;

import util.FileUtil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;

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

        if (stringList.size() > 1)
        {
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
        int keyIndex = 0;

        if (stringList.size() > 1)
        {
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
                keyIndex++;
            }
        }

        if (keyExists)  // If key exists, then remove old value
        {
            stringList.remove(keyIndex);
        }
        else    // If key does not exist, then append to the end
        {
            keyIndex = stringList.size() - 1;
        }

        // Add new value for key
        stringList.add(keyIndex, "  \"" + key + "\": \"" + val + "\",");

        List<String> newList = new ArrayList<>();

        // Ensure all rows have trailing comma
        for (String line : stringList)
        {
            // Skip enclosing braces
            if (!"{".equals(line) && !"}".equals(line) && (newList.size() - 1 < stringList.size() - 2))
            {
                if (line.charAt(line.length() - 1) != ',')
                {
                    newList.add(line.substring(0, line.length() - 1) + "\",");
                    continue;
                }

                newList.add(line);
            }
        }

        DateFormat format = new SimpleDateFormat("ddMMMyyyy", Locale.ENGLISH);

        // Sort new list
        Collections.sort(newList, new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                Date d1 = null;
                Date d2 = null;
                try
                {
                    String k1 = getKeyFromLine(o1);
                    String k2 = getKeyFromLine(o2);
                    d1 = format.parse(k1);
                    d2 = format.parse(k2);
                }
                catch (Exception exc)
                {
                    System.out.print(exc.getMessage());
                }

                return d1.compareTo(d2);
            }
        });

        // Remove trailing comma in last item in list
        String l = newList.get(newList.size() - 1);
        l = l.substring(0, l.length() - 2) + "\"";
        newList.remove(newList.size() - 1);
        newList.add(l);

        // Prepend and append enclosing braces
        newList.add(0, "{");
        newList.add("}");

        // Finally, write file to disk
        FileUtil.writeFile(newList, path);
    }
}
