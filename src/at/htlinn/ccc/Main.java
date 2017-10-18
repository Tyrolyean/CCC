package at.htlinn.ccc;

import at.htlinn.ccc.Levels.Level;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int levelNr = 1;
        String[][] input;
        Scanner sc = new Scanner(System.in);
        Level l = new Level(levelNr);

        Tools.levelFilePattern = "level$l-$n.txt";
        Tools.levelPathPattern = "level$l";
        Tools.exampleNumber = "eg";
        Tools.firstInputNr = 1;
        Tools.lastInputNr = 4;

        try {
            input = Tools.split(Tools.unifyEOL(Tools.getLevelInput(levelNr)), "\n");
        } catch (Exception e) {
            System.out.println("Exception thrown!");
            System.out.println("StackTrace: ");
            e.printStackTrace(System.out);
            return;
        }

        System.out.println(l.main(input[0]));
        System.out.print("Does the output match the example output? (Y/N): ");
        if(sc.nextLine().toUpperCase().equals("Y"))
        {
            for (int i = 1; i < input.length; i++) {
                Tools.copyToClipboard(l.main(input[i]));
                if(i != input.length-1) {
                    System.out.print("Press [ENTER] to copy next result...");
                    sc.nextLine();
                }
                else
                    System.out.println("\nDone.");
            }
        }
    }
}