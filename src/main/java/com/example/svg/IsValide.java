package com.example.svg;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
 
public class IsValide {

    public IsValide(){}

    public boolean isDateValid(String date) {
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            df.setLenient(false);
            df.parse(date);
            if (date.length() == 10) {
                return true;
            } else {
                return false;
            }

        } catch (ParseException e) {
            return false;
        }
    }

    public boolean isFileValid(String nomfichier, File fichier) {
        if (nomfichier.endsWith(".yaml") && fichier.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isFileValid(String nomfichier) {
        File file = new File(nomfichier);
        if (nomfichier.endsWith(".yaml") && file.exists()) {
            System.out.println("bon format de fichier et il existe");
            return true;
        } else {
            return false;
        }
    }
    
}
