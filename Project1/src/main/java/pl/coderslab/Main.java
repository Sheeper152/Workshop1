package pl.coderslab;

import org.xml.sax.helpers.ParserAdapter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final String FILE_NAME = "tasks.csv";
    static final String[] OPTIONS = {"add", "remove", "list", "exit"};

    public static void main(String[] args) {
        System.out.println(ConsoleColors.BLUE + "Please select an option:");

        System.out.println(ConsoleColors.RESET + "add");
        System.out.println("remove");
        System.out.println("list");
        System.out.println("exit");
        tasks = PobieranieDanych(FILE_NAME);
        tasks = DodawanieDanych(FILE_NAME);
    }

    static String[][] tasks;

    public static String[][] PobieranieDanych(String FileName) {

        Path dir = Paths.get(FILE_NAME);
        if (!Files.exists(dir)) {
            System.out.println("File not exist.");
            System.exit(0);
        }
        String tab[][] = null;
        try {
            List<String> strings = Files.readAllLines(dir);
            tab = new String[strings.size()][strings.get(0).split(",").length];

            for (int i = 0; i < strings.size(); i++) {
                String[] split = strings.get(i).split(",");
                for (int j = 0; j < split.length; j++) {
                    tab[i][j] = split[j];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("A może to?");
        }

        return tab;
    }

    public static String[][] DodawanieDanych(String FileName2) {

        Path path1 = Paths.get("/home/bartosz/Dokumenty/kurs/Workshop1/Project1/tasks.csv");
        System.out.println(Files.exists(path1));
        Scanner scanner = new Scanner(System.in);
        String dodanieAdd = scanner.nextLine();
        if (dodanieAdd.equals("add")) {
            System.out.println("Please add task description");
            try {
                String tab[][] = tasks;

                for (int i = 0; i < tab.length; i++) {
                    String dodanieZdania = scanner.nextLine();
                    Files.writeString(path1, dodanieZdania, StandardOpenOption.APPEND);
                    for (int j = 0; j < tab[i].length; j++) ;
                    System.out.println("Podaj datę");
                    String dodanieDaty = scanner.nextLine();
                    Files.writeString(path1, dodanieDaty, StandardOpenOption.APPEND);
                    System.out.println("Podaj ważność");
                    String isItImportant = scanner.nextLine();
                    Files.writeString(path1, isItImportant, StandardOpenOption.APPEND);


                }


            } catch (IOException exeption) {
                System.out.println("wpisuj jak nalezy");

            }
        }


        return tasks;
    }
}


