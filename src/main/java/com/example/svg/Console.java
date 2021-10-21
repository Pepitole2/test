package com.example.svg;


import java.util.Scanner;

public class Console {

    private ConsoleInput consolinput = new ConsoleInput();
    private Svg svg = new Svg();


    public Console(){}

    public void runConsole(){

        Scanner clavier = new Scanner(System.in);
        consolinput.pathFileInput(clavier);
        consolinput.dateStartInput(clavier);
        consolinput.dateEndInput(clavier);

        System.out.println("[FilePath = " + consolinput.getPathfile() + " , Date_Start = " + consolinput.getDatestart()
                + " , Date_End =" + consolinput.getDateend() + "]");

        svg.setDate_debut(consolinput.getDatestart());
        svg.setDate_fin(consolinput.getDateend());
        svg.setVartempon(consolinput.getPathfile());// transmition du file


        // passage a la fenetre suivante
        clavier.close();
        svg.TestSvg();
    

    }
}
