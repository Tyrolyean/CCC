package at.htlinn.ccc;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Tools
{
    public static String inputDir = System.getProperty("user.dir") + File.separator+"input" + File.separator;
    public static String levelFilePattern = "level$l-$n";
    public static String levelPathPattern = "level$l";
    public static String exampleNumber = "eg";
    public static int firstInputNr = 1;
    public static int lastInputNr = 4;

    public static String[] getLevelInput(int levelNumber) throws java.io.IOException
    {
       String[] output = new String[lastInputNr];

        String dir = inputDir+levelPathPattern.replace("$l", Integer.toString(levelNumber)) + File.separator;
        String levelFile = levelFilePattern.replace("$l", Integer.toString(levelNumber));

        if(!exampleNumber.equals(""))
            output[0] = new String(Files.readAllBytes(Paths.get(dir+levelFile.replace("$n", exampleNumber))));

        for(int i = firstInputNr; i<= lastInputNr; i++)
        {
            int index = 1;
            output[index++] = new String(Files.readAllBytes(Paths.get(dir+levelFile.replace("$n", Integer.toString(i)))));
        }

        return output;
    }

    public static void copyToClipboard(String text)
    {

        StringSelection clipboardString = new StringSelection(text);

        Clipboard clipboard  = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(clipboardString,clipboardString);
    }
}
