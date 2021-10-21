package com.example.svg;

import java.io.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class BoutonFichier extends AbstractAction {
    

    private PopUp fenetre;
    public JTextField txtField;
    public String fileID;
    private String filename;
    private String newfilename;
    private JFileChooser chooser = new JFileChooser();
    private File file = chooser.getSelectedFile();

    private IsValide isvalide =new IsValide();
   
    
    public BoutonFichier(PopUp fenetre, String texte){
		super(texte);
		
		this.fenetre = fenetre;
	}


    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        chooser.setDialogTitle("Select Location");
        chooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("YAML FILES", "yaml");
        chooser.setFileFilter(filter);

        if (chooser.showSaveDialog(fenetre) == JFileChooser.APPROVE_OPTION)
        { 
            File file = chooser.getSelectedFile();
            filename=file.getPath();
            newfilename = filename.replace("\\", "/");
           // filename.replaceAll("\\", File.separator);

            if (isvalide.isFileValid(filename, file)){
                System.out.println(newfilename);
                fenetre.setMsgPath(newfilename);
            }else{
                JOptionPane.showMessageDialog(null, "Le fichier n'est pas valide ", "Erreur Fichier",
                        JOptionPane.ERROR_MESSAGE);
            }
            
            
        }
    }

  

    public File getFile() {
        return file;
    }

    public String getFilename(){
        return newfilename;
    }


}