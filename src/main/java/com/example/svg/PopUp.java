package com.example.svg;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class PopUp extends JFrame  {

    private JTextField entredate1;
    private JTextField entredate2;
    private JTextField entrefichierString;
    private JLabel label;
    private String msgPath = "Aucun fichier Yaml selectionnée ";

    final JFileChooser fc = new JFileChooser();
//In response to a button click:

    public PopUp(){
		super();
		
		build();//On initialise notre fenêtre
	}

    private void build() {
        setTitle("Paramétrage des dates de recherches"); // titre 
        setSize(640, 480);
        setLocationRelativeTo(null); // On centre la fenêtre sur l'écran
        setResizable(true); // On permet le redimensionnement
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // On dit à l'application de se fermer lors du clic sur la croix
        setContentPane(buildContentPane());
    }

    private JPanel buildContentPane() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
    
        

        label = new JLabel("Entrer les dates au format jj/mm/aaaa    :");
        panel.add(label);
        
        entredate1 = new JTextField("01/01/2021");
        entredate1.setColumns(10);
        panel.add(entredate1);

        entredate2 = new JTextField("31/12/2021");
        entredate2.setColumns(10);
        panel.add(entredate2);
        
        entrefichierString = new JTextField(msgPath);
        entrefichierString.setColumns(40);
        panel.add(entrefichierString);


        JButton btnBrowse =new  JButton(new BoutonFichier(this,"Selection"));
        panel.add(btnBrowse);

        JButton bouton = new JButton(new BoutonValidation(this, "Validation"));
        panel.add(bouton);

        
        return panel;

    }

    public void setMsgPath(String msgPath){
        this.msgPath=msgPath;
        entrefichierString.setText(msgPath);
       // entrefichierString.repaint();
    }


    public JTextField getEntredate1() {
        return entredate1;
    }

    public JTextField getEntredate2() {
        return entredate2;
    }

    public JTextField getEntrefichierString(){
        return entrefichierString;
    }

    public JLabel getLabel() {
        return label;
    }

    public void run() {
        // On crée une nouvelle instance de notre JDialog
        PopUp fenetre = new PopUp();
        fenetre.setVisible(true);// On la rend visible
    }


}
    

