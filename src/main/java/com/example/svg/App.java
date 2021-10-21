package com.example.svg;

import java.io.IOException;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;


@Command(name = "App", version = "ASCIIArt 1.0", mixinStandardHelpOptions = true,description = "Méhode princial")
public class App implements Runnable{

    private IsValide isvalide= new IsValide();

    @Option(names = "--date-debut", defaultValue = "01/01/2021")
    String date_debut;

    @Option(names = "--date-fin", defaultValue = "31/12/2021")
    String date_fin;

    @Option(names = "--lancement")int x;

    @Parameters(index="0",defaultValue="Nofile",description="chemin d'accés au fichier")
    String filePath;


    
    public static void main(String[] args) throws IOException {

    
  
        System.exit(new CommandLine(new App()).execute(args));

        //Console console = new Console();
        //console.runConsole();
}
@Override
public void run() {
    // TODO Auto-generated method stub
   System.out.println("Le chemind du fichier est : " + filePath);

    if(isvalide.isDateValid(date_debut)==true)
    {
        System.out.println("date debut :" + date_debut); 
    }else
    {
        System.out.println("date debut non valide");
    }

    if (isvalide.isDateValid(date_fin) == true) {
        System.out.println("date fin : " + date_fin);
    }else
    {
        System.out.println("date fin non valide");
    }

    //Si il n'y a pas de fichier de renseigner en ligne de commande alos:
    //on appelle la fenetre popup et la console pour pourvir rentré les paramétres.
    if(filePath.equals("Nofile"))
    {   
  
        PopUp pu = new PopUp();
        pu.run();
        Console console = new Console();
        console.runConsole();
    }

    //si le fichier entré en ligne de commande est valide ainsi que les dates
    //on appelle la fonction svg
    if(isvalide.isFileValid(filePath)==true && isvalide.isDateValid(date_debut) == true && isvalide
            .isDateValid(date_fin) == true)
    {   
        
        Draw draw=new Draw();
        draw.setFilePath(filePath);
        draw.setDate_debut(date_debut);
        draw.setDate_fin(date_fin);
        try {
            draw.drawnPanel();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Console console = new Console();
        console.runConsole();
    } 
}



}



