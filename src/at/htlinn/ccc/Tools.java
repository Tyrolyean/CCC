package at.htlinn.ccc;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Tools {
    public static String inputDir = System.getProperty("user.dir") + File.separator + "input" + File.separator;
    public static String levelFilePattern = "level$l-$n.txt";
    public static String levelPathPattern = "level$l";
    public static String exampleNumber = "eg";
    public static int firstInputNr = 1;
    public static int lastInputNr = 4;

    public static String[] getLevelInput(int levelNr) throws java.io.IOException {
        String[] output = new String[lastInputNr + 1];

        String dir = inputDir + levelPathPattern.replace("$l", Integer.toString(levelNr)) + File.separator;
        String levelFile = levelFilePattern.replace("$l", Integer.toString(levelNr));

        if (!exampleNumber.equals(""))
            output[0] = new String(Files.readAllBytes(Paths.get(dir + levelFile.replace("$n", exampleNumber))));

        int index = 1;
        for (int i = firstInputNr; i <= lastInputNr; i++) {
            output[index++] = new String(Files.readAllBytes(Paths.get(dir + levelFile.replace("$n", Integer.toString(i)))));
        }


        return output;
    }

    public static String[][] split(String[] s, String separator) {
        String[][] output = new String[s.length][];

        for (int i = 0; i < s.length; i++)
            output[i] = s[i].split(separator);

        return output;
    }

    public static String[] unifyEOL(String[] s) {
        for (int i = 0; i < s.length; i++)
            s[i] = s[i].replace("\n\r", "\n").replace("\r", "\n");

        return s;
    }

    public static void copyToClipboard(String text) {
        StringSelection clipboardString = new StringSelection(text);

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(clipboardString, clipboardString);
    }
}
