package at.htlinn.ccc;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Tools {
    public static String inputDir = System.getProperty("user.dir") + File.separator + "input" + File.separator;
    public static String levelFilePattern = "level$l-$n.txt";
    public static String levelPathPattern = "level$l";
    public static String exampleNumber = "eg";
    public static int firstInputNr = 1;
    //public static int lastInputNr = 4;

    public static String[] getLevelInput(int levelNr) throws java.io.IOException {
        ArrayList<String> output = new ArrayList<>();

        String dir = inputDir + levelPathPattern.replace("$l", Integer.toString(levelNr)) + File.separator;
        String levelFile = levelFilePattern.replace("$l", Integer.toString(levelNr));

        output.add(exampleNumber.equals("")? "" : new String(Files.readAllBytes(Paths.get(dir + levelFile.replace("$n", exampleNumber)))));

        int i=firstInputNr;
        do
        {
            output.add(new String(Files.readAllBytes(Paths.get(dir + levelFile.replace("$n", Integer.toString(i++))))));
        }
        while (new File(dir + levelFile.replace("$n", Integer.toString(i))).exists());


        return output.toArray(new String[0]);
    }

    public static String[][] split(String[] s, String separator) {
        String[][] output = new String[s.length][];

        for (int i = 0; i < s.length; i++)
            output[i] = s[i].split(separator);

        return output;
    }

    public static int[] splitToInt(String s, String separator)
    {
        String[] split = s.split(separator);
        int[] output = new int[split.length];
        for(int i=0; i<split.length; i++)
        {
            output[i] = Integer.parseInt(split[i]);
        }
        return output;
    }

    public static String[] unifyEOL(String[] s) {
        for (int i = 0; i < s.length; i++)
            s[i] = s[i].replace("\n\r", "\n").replace("\r\n", "\n").replace("\r", "\n");

        return s;
    }

    public static void copyToClipboard(String text) {
        StringSelection clipboardString = new StringSelection(text);

        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(clipboardString, clipboardString);
    }
}