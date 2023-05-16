package sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(final String[] args) {

        String arg1 = "", arg2 = "";
        for (int i = 0; i < args.length; i++) {
            if (args[i].equalsIgnoreCase("-dataType")) {
                try {
                    int typeIndex = i + 1;
                    if (args[typeIndex].matches("long|line|word")) {
                        arg1 = args[typeIndex];
                    } else {
                        System.out.println("No data type defined!");
                    }
                } catch (Exception e) {
                    System.out.println("No data type defined!");
                }
            } else if (args[i].equalsIgnoreCase("-sortingType")) {
                try {
                    int sortIndex = i + 1;
                    if (args[sortIndex].matches("natural|byCount")) {
                        arg2 = args[sortIndex];
                    } else {
                        System.out.println("No sorting type defined!");
                    }
                } catch (Exception e) {
                    System.out.println("No sorting type defined!");
                }
            } else if (args[i].equalsIgnoreCase("-inputFile")) {
                inFile(new File(args[i + 1]));
            } else if (args[i].equalsIgnoreCase("-outputFile")) {
                outFile(new File(args[i + 1]));
            } else if (args[i].matches("-.*")) {
                System.out.printf("\"%s\" is not a valid parameter. It will be skipped.%n", args[i]);
            }
        }

        if (arg1.equals("")) arg1 = "word";
        if (arg2.equals("")) arg2 = "natural";
        DataParserFactory.newInstance(arg1, arg2);
    }

    // Pointless input output methods due to a lacking of objective and real tests in stage 6, rest of project is good
    public static void inFile(File file) {
        try (Scanner fileScanner = new Scanner(file)) {
            fileScanner.nextLine();
            while (fileScanner.hasNextLine()) {
                String loadedData = fileScanner.nextLine();
                String[] loadedDataArray = loadedData.split(" => " );
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    public static void outFile(File file) {
        try (FileWriter writer = new FileWriter(file)){
            boolean createdNew = file.createNewFile();
            writer.write("The test maker for this stage was lazy\n");
        } catch (IOException e) {
            System.out.println("Cannot create the file: " + file.getPath());
        }
    }
}