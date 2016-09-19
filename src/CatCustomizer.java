import jodd.json.JsonParser;
import jodd.json.JsonSerializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by joe on 9/15/16.
 */
public class CatCustomizer {

    public static Cat cat = new Cat();
    static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        System.out.println("Thank you for visiting the Cat Cafe!" +
                "\nPlease enter your preferences so we know what cat will be your new furry feline friend:");

        try {
            cat = loadFile();
            System.out.println("...\nYou have already selected a cat!");
        } catch (Exception e) {
            System.out.println("Get ready for your new feline friend!");
            cat.update();
            saveFile();
        }

        Choice();
    }

    public static String Choice() throws Exception {

        String selection = "";
        while (!(selection.equals("4"))) {
            System.out.println("-----");
            System.out.println("Please enter your selection:");
            System.out.println("[1] View cat");
            System.out.println("[2] Update cat");
            System.out.println("[3] Save cat");
            System.out.println("[4] Return cat");

            selection = keyboard.nextLine();
            switch (selection) {
                case "1":
                    loadFile();
                    System.out.println(cat);
                    break;
                case "2":
                    cat.update();
                    break;
                case "3":
                    saveFile();
                    System.out.println("Your cat was saved!");
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Please choose an option.");
                    break;
            }
        }
        return selection;
    }

    public static void saveFile() throws FileNotFoundException, IOException {
        JsonSerializer s = new JsonSerializer();
        String json = s.serialize(cat);

        File f = new File("file.json");
        FileWriter fw = new FileWriter(f);
        fw.write(json);
        fw.close();
    }

    public static Cat loadFile() throws FileNotFoundException {
        //read file in
        File f = new File("file.json");
        Scanner s = new Scanner(f);
        s.useDelimiter("\\Z");
        String contents = s.next();
        s.close();

        JsonParser p = new JsonParser();
        return p.parse(contents, Cat.class);
    }

    public static void writeFile(String fileName, String fileContent) throws IOException {
        File f = new File(fileName);
        FileWriter fw = new FileWriter(f);
        fw.write(fileContent);
        fw.close();
    }
}

