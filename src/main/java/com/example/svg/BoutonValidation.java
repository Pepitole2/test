package com.example.svg;

import javax.swing.AbstractAction;


import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

public class BoutonValidation extends AbstractAction {

   // private Svg svg=new Svg();
    private Draw draw =new Draw(); 
    private PopUp fenetre;
    private String fichier;
    private IsValide isvalide = new IsValide();

    public BoutonValidation(PopUp fenetre, String texte){
		super(texte);
		
		this.fenetre = fenetre;
	}

    @Override
    public void actionPerformed(ActionEvent e) {
        String date1 = fenetre.getEntredate1().getText();
        String date2 = fenetre.getEntredate2().getText();
        fichier =fenetre.getEntrefichierString().getText();
        
        //transmition des donner de la fenétre popUp aprés véref

        if(isvalide.isDateValid(date1)==true){
            //System.out.println("la date1"+date1+" est valide");
            draw.setDate_debut(date1);
        }else{
            JOptionPane.showMessageDialog(null, "La date 1 : " + date1 +" n'est pas valide ", "Erreur Date",
                    JOptionPane.ERROR_MESSAGE);
        }
        if (isvalide.isDateValid(date2) == true) {
            //System.out.println("la date2 : " + date2 + " est valide");
            draw.setDate_fin(date2);
        } else {
            JOptionPane.showMessageDialog(null, "La date : " + date2 + " n'est pas valide ", "Erreur Date",
                    JOptionPane.ERROR_MESSAGE);
        }
        if(isvalide.isFileValid(fichier)==false){
            JOptionPane.showMessageDialog(null, "Le fichier n'est pas valide ", "Erreur Fichier",
                    JOptionPane.ERROR_MESSAGE);
        }else{
            draw.setFilePath(fichier);
        }

        
            //passage a la prochaine fenetre
            //Lancement de la fenetre svg aprés ultime véification            

        if(isvalide.isDateValid(date1) == true && isvalide.isDateValid(date2) == true && isvalide.isFileValid(fichier)){
            fenetre.dispose();
            try {
                draw.drawnPanel();
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        
    }



    public String getFichier(){
        return fichier;
    }
    
}
