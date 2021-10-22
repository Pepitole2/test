package com.example.svg;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Tableau {

    private int ORIGINE_DESSIN_X;
    private int ORIGINE_DESSIN_Y;
    private int HAUTEUR_LIGNE;
    private int TAILLE_JOUR;
    private int MARGE_GAUCHE;
    private int nb_api_file;
    private Item item;
    private TraitementDate td=new TraitementDate();;
    private static Color color1 = Color.blue;
    private static Color color2 = (new Color(5,100,0));
   
   
    
    //pour les cercle bleu
    private List<Integer> jour_nemo_MEPP_INTRADEF= new ArrayList<Integer>();
    private List<Integer> jour_nemo_MEPP_INTERNET = new ArrayList<Integer>();
    private List<Integer> jour_nemo_MEPP_PAPI = new ArrayList<Integer>();
    private List<Integer> jour_MEPP_INTRADEF=new ArrayList<Integer>();
    private List<Integer> jour_MEPP_INTERNET = new ArrayList<Integer>();
    private List<Integer> jour_MEPP_PAPI = new ArrayList<Integer>();
    //pour les cerles verts
    private List<Integer> jour_Demande_MEP_INTRADEF= new ArrayList<Integer>();
    private List<Integer> jour_Demande_MEP_INTERNET= new ArrayList<Integer>();
    private List<Integer> jour_Demande_MEP_PAPI = new ArrayList<Integer>();
    private List<Integer> jour_MEP_INTRADEF = new ArrayList<Integer>();
    private List<Integer> jour_MEP_INTERNET = new ArrayList<Integer>();
    private List<Integer> jour_MEP_PAPI = new ArrayList<Integer>();
    // STATUT
    private ArrayList<String> Statut_INTRADEF = new ArrayList<String>();
    private ArrayList<String> Statut_INTERNET = new ArrayList<String>();
    private ArrayList<String> Statut_PAPI = new ArrayList<String>();



   

    public Tableau( int ORIGINE_DESSIN_X,int ORIGINE_DESSIN_Y,int HAUTEUR_LIGNE,int TAILLE_JOUR,int MARGE_GAUCHE,int nb_api_file)
    {
        this.ORIGINE_DESSIN_X=ORIGINE_DESSIN_X;
        this.ORIGINE_DESSIN_Y=ORIGINE_DESSIN_Y;
        this.HAUTEUR_LIGNE=HAUTEUR_LIGNE;
        this.TAILLE_JOUR=TAILLE_JOUR;
        this.MARGE_GAUCHE=MARGE_GAUCHE;
        this.nb_api_file=nb_api_file;
        this.item=new Item(TAILLE_JOUR, ORIGINE_DESSIN_X, ORIGINE_DESSIN_Y, MARGE_GAUCHE,HAUTEUR_LIGNE);
    }



    public void drawWeeks(Graphics2D g, String date_debut, String date_fin) // methode qui va afficher la grille et tout
                                                                            // les détails
    {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date_d = LocalDate.parse(date_debut, formatter);
        LocalDate date_f = LocalDate.parse(date_fin, formatter);
        int nombre_jour_afficher = date_f.getDayOfYear() - date_d.getDayOfYear() + 1;// nombre de jour --> on construit
                                                                     // le tableau grace a eux.
        int jour_d=td.haveDayofYear(date_debut)-1;
        int nb_month = date_f.getMonthValue() - date_d.getMonthValue() + 1;
        List<Integer> premier_jour_mois = new ArrayList<Integer>();
        

        
    
        for (int i = 1; i <= nb_month; i++) {
            if ((i + date_d.getMonthValue() - 1) < 10) {
                // System.out.println(i);
                LocalDate valtemp = LocalDate.parse("01/0" + (i + date_d.getMonthValue() - 1) + "/2021" , formatter);
                premier_jour_mois.add(valtemp.withDayOfMonth(1).getDayOfYear());
            } else if ((i + date_d.getMonthValue() - 1) < 13) {
                // System.out.println(i);
                LocalDate valtemp = LocalDate.parse("01/" + (i + date_d.getMonthValue() - 1) + "/2021", formatter);
                premier_jour_mois.add(valtemp.withDayOfMonth(1).getDayOfYear());
            }
        }

        for (int i = jour_d; i <= nombre_jour_afficher+jour_d; i++) 
        {   
           /* g.setColor(Color.pink);
            g.drawLine(MARGE_GAUCHE - 6 + (i * TAILLE_JOUR)+ ORIGINE_DESSIN_X, ORIGINE_DESSIN_Y - (HAUTEUR_LIGNE / 2) - 5,
                    MARGE_GAUCHE + (i * TAILLE_JOUR) + ORIGINE_DESSIN_X,
                    nb_api_file * HAUTEUR_LIGNE + (ORIGINE_DESSIN_Y - (HAUTEUR_LIGNE / 2)) - 5);// ligne qui affiche  nb de jour
            g.setColor(Color.black);*/
            
            
            for (int y = 0; y < nb_month; y++) {
                //Affichage du premier jour du mois en pointillé rouge
                if (i == premier_jour_mois.get(y)) {
                    Graphics2D g2d = (Graphics2D) g.create();
                    Stroke dashed = new BasicStroke(2, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0,
                            new float[] { 4 }, 0);
                    g2d.setStroke(dashed); // On veut affiicher le premer du mois en pointiller
                    g2d.setColor(new Color(50, 64, 90));;
                    g2d.drawLine(MARGE_GAUCHE-5 + ((i-jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X, ORIGINE_DESSIN_Y - (HAUTEUR_LIGNE / 2) - 10,
                            MARGE_GAUCHE-5 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X,
                            nb_api_file * HAUTEUR_LIGNE + (ORIGINE_DESSIN_Y - (HAUTEUR_LIGNE / 2)) - 5);
                    g2d.setColor(Color.BLACK);
                    drawNameMonth(g, MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X, 
                            ORIGINE_DESSIN_Y - (HAUTEUR_LIGNE / 2) - 10, y+date_d.getMonthValue()-1,nombre_jour_afficher);
                }
            }     
            
            drawFirstDayWeek(g, date_d, nombre_jour_afficher);
            //cercle blue
            item.drawCircleMEPP(g, i,jour_d, jour_nemo_MEPP_INTRADEF, color1); 
            item.drawCircleMEPP(g,i, jour_d,jour_nemo_MEPP_INTERNET,jour_nemo_MEPP_INTRADEF, color1);
            item.drawCircleMEPP(g,i,jour_d, jour_nemo_MEPP_PAPI,jour_nemo_MEPP_INTRADEF,jour_nemo_MEPP_INTERNET, color1);
            item.drawCircleMEPP(g,i, jour_d, jour_MEPP_INTRADEF, color1);
            item.drawCircleMEPP(g, i, jour_d, jour_MEPP_INTERNET, jour_MEPP_INTRADEF, color1);
            item.drawCircleMEPP(g, i, jour_d, jour_MEPP_PAPI, jour_MEPP_INTERNET, jour_MEPP_INTRADEF, color1);
            //cercle vert
            item.drawCircleMEP(g, i, jour_d, jour_Demande_MEP_INTRADEF, color2);
            item.drawCircleMEP(g, i, jour_d, jour_Demande_MEP_INTERNET ,jour_Demande_MEP_INTRADEF , color2);
            item.drawCircleMEP(g, i,jour_d,  jour_Demande_MEP_PAPI, jour_Demande_MEP_INTRADEF, jour_Demande_MEP_INTERNET, color2);

            item.drawTriangleMEP(g, i, jour_d, jour_MEP_INTRADEF, color2, Statut_INTRADEF);
            item.drawTriangleMEP(g, i, jour_d, jour_MEP_INTERNET ,jour_MEPP_INTRADEF, color2, Statut_INTERNET);
            item.drawTriangleMEP(g, i, jour_d, jour_MEP_PAPI, jour_MEPP_INTERNET, jour_MEPP_INTRADEF, color2,
                    Statut_PAPI);
    
            
        }

        drawNumWeeks(g, nombre_jour_afficher, jour_d);
        System.out.println("MEP INTRADEF  " + jour_MEP_INTRADEF);
        System.out.println("Statut INtra  " + Statut_INTRADEF);
        System.out.println("Statut INter " + Statut_INTERNET);
        System.out.println("Statut  papo" + Statut_PAPI);
        item.drawLigneCircleMEPP(g, Color.blue, nombre_jour_afficher * TAILLE_JOUR);
        item.drawLigneCircleMEP(g, (new Color(5,100,0)), nombre_jour_afficher*TAILLE_JOUR);
        
    }

    public void drawNameMonth(Graphics2D g,int x,int y,int mois,int nombre_jour_afficher)
    {
        x=x+TAILLE_JOUR*nombre_jour_afficher/30;
        y=y-10;
        Graphics2D g4 = (Graphics2D) g.create();
        g4.setFont(new Font("TimesRoman", Font.BOLD, 15));
        if(mois==0){
             g4.drawString("Janvier",x,y-12);
        }if(mois==1){
            g4.drawString("Février", x, y - 12);
        }
        if (mois == 2) {
            g4.drawString("Mars", x, y - 12);
        }
        if (mois == 3) {
            g4.drawString("Avril", x, y - 12);
        }
        if (mois == 4) {
            g4.drawString("Mai", x, y - 12);
        }
        if (mois == 5) {
            g4.drawString("Juin", x, y - 12);
        }
        if (mois == 6) {
            g4.drawString("Juillet", x, y - 12);
        }
        if (mois == 7) {
            g4.drawString("Aout", x, y - 12);
        }
        if (mois == 8) {
            g4.drawString("Septembre", x, y - 12);
        }
        if (mois == 9) {
            g4.drawString("Octobre", x, y - 12);
        }
        if (mois == 10) {
            g4.drawString("Novembre", x, y - 12);
        }
        if (mois == 11) {
            g4.drawString("Decembre", x, y - 12);
        }
       
    }
    

    public void drawFirstDayWeek(Graphics2D g,LocalDate date_d,int nombre_jour_afficher)
    {
        int margelocal=MARGE_GAUCHE-1;
        int jour; // Si le premier jour n'est pas lundi, alors on fait la différence pour trouver le début de semaine dans le tableau
            if (date_d.getDayOfWeek() == DayOfWeek.MONDAY) {
                jour = 0;
                for (int a = 0; a < nombre_jour_afficher - 7; a = a + 7) 
                {
                    g.setColor(Color.gray );
                    g.drawLine(ORIGINE_DESSIN_X+ margelocal + a * TAILLE_JOUR + (jour * TAILLE_JOUR), ORIGINE_DESSIN_Y -(HAUTEUR_LIGNE/2)-5,
                            ORIGINE_DESSIN_X + margelocal + a * TAILLE_JOUR + (jour * TAILLE_JOUR),
                            ORIGINE_DESSIN_Y - (HAUTEUR_LIGNE / 2)+ HAUTEUR_LIGNE * nb_api_file-5);
                            g.setColor(Color.black);
                }
            } else 
            {
                jour = 7 - date_d.getDayOfWeek().getValue() + 1;
                for (int a = 0; a < nombre_jour_afficher - 7; a = a + 7) 
                {   
                    g.setColor(Color.gray);
                    g.drawLine(ORIGINE_DESSIN_X + margelocal + a * TAILLE_JOUR + (jour * TAILLE_JOUR), ORIGINE_DESSIN_Y-(HAUTEUR_LIGNE/2)-5,
                            ORIGINE_DESSIN_X + margelocal + a * TAILLE_JOUR + (jour * TAILLE_JOUR),
                            ORIGINE_DESSIN_Y - (HAUTEUR_LIGNE / 2)+ HAUTEUR_LIGNE * nb_api_file-5); 
                            g.setColor(Color.BLACK);
                }
            }
        }

    //----string l enumero de semaine
    public void drawNumWeeks(Graphics2D g, int nombre_jour_afficher,int jour_d)
    {
        int jour=0;
       
            for (int i= jour_d; i < nombre_jour_afficher+jour_d- 7; i = i + 7) 
            {
                if(i/7==0 )
                {
                    g.drawString("S" + 53,
                            ORIGINE_DESSIN_X + MARGE_GAUCHE + (i-jour_d) * TAILLE_JOUR + (jour * TAILLE_JOUR) - 10,
                            ORIGINE_DESSIN_Y - (HAUTEUR_LIGNE / 2)-14);
                }
                else
                {
                    g.drawString("S" + i / 7, ORIGINE_DESSIN_X + MARGE_GAUCHE + (i-jour_d) * TAILLE_JOUR + (jour * TAILLE_JOUR)-10,
                        ORIGINE_DESSIN_Y - (HAUTEUR_LIGNE / 2) -14); 
                }
            
            }
        
        
        
    }

    public void  setStatut_INTRADEF(ArrayList<String> list){
        this.Statut_INTRADEF=list;
    }

    public void  setStatut_INTERNET(ArrayList<String> list){
        this.Statut_INTERNET=list;
    } 

    public void  setStatut_PAPI(ArrayList<String> list){
        this.Statut_PAPI=list;
    }



    public void setJour_MEP_INTRADEF(List<Integer> list)
    {
        this.jour_MEP_INTRADEF=list;
    }

    public void setJour_MEP_INTERNET(List<Integer> list) {
        this.jour_MEP_INTERNET = list;
    }
    
    public void setJour_MEP_PAPI(List<Integer> list) {
        this.jour_MEP_PAPI = list;
    }

    public void setJour_Demande_MEP_INTRADEF(List<Integer>list)
    {
        this.jour_Demande_MEP_INTRADEF=list;
    }
    
    public void setJour_Demande_MEP_INTERNET(List<Integer> list) {
        this.jour_Demande_MEP_INTERNET = list;
    }
    
    public void setJour_Demande_MEP_PAPI(List<Integer> list) {
        this.jour_Demande_MEP_PAPI = list;
    }


     public void setJour_nemo_MEPP_INTRADEF(List<Integer> list)
    {
        this.jour_nemo_MEPP_INTRADEF=list;
    }

    public void setJour_nemo_MEPP_INTERNET(List<Integer> list) {
        this.jour_nemo_MEPP_INTERNET = list;
    }

    public void setJour_nemo_MEPP_PAPI(List<Integer> list) {
        this.jour_nemo_MEPP_PAPI= list;
    }

    public void setJour__MEPP_INTRADEF(List<Integer> list){
        this.jour_MEPP_INTRADEF=list;
    }

    public void setJour__MEPP_INTERNET(List<Integer> list) {
        this.jour_MEPP_INTERNET= list;
    }

    public void setJour__MEPP_PAPI(List<Integer> list) {
        this.jour_MEPP_PAPI = list;
    }

 


}