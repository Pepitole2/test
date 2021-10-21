package com.example.svg;

import java.util.Scanner;
import java.io.File;

public class ConsoleInput {


        public ConsoleInput() {
        }

        private String pathfile = "No patfile";
        private String datestart = "01/01/2021";
        private String dateend = "31/12/2021";

        private IsValide isvalide = new IsValide();

        public void pathFileInput(Scanner clavier) {
            System.out.print("Saisir le chemin du fichier :");
            String test = clavier.nextLine();

            File f = new File(test);

            if (isvalide.isFileValid(test, f) == true) {
                pathfile = test;
            } else {
                System.out.println("Entrer un fichier valide :");
                pathFileInput(clavier);
            }

        }

        public void dateStartInput(Scanner clavier) {
            System.out.print("Date de départ  :");
            String test = clavier.nextLine();
            if (isvalide.isDateValid(test)) {
                datestart = test;
            } else {
                System.out.println("Date non valide");
                dateStartInput(clavier);
            }
        }

        public void dateEndInput(Scanner clavier) {
            System.out.print("Saisir date de fin : ");
            String test = clavier.nextLine();
            if (isvalide.isDateValid(test)) {
                dateend = test;
            } else {
                System.out.println("Date non valide");
                dateStartInput(clavier);
            }

        }

        public String getPathfile() {
            return pathfile;
        }

        public String getDatestart() {
            return datestart;
        }

        public String getDateend() {
            return dateend;
        }

    
    
}
