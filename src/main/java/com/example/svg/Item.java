package com.example.svg;

import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.util.List;



public class Item {

    private static final int TAILLE_ITEM=18;
    private int TAILLE_JOUR;
    private int ORIGINE_DESSIN_X;
    private int ORIGINE_DESSIN_Y;
    private int MARGE_GAUCHE;
    private int HAUTEUR_LIGNE;
    private Triangle triangle=new Triangle();       
    private int test=0;
    private List<Integer> ligne_INTRADEF_x1=new ArrayList<Integer>();
    private List<Integer> ligne_INTRADEF_y1=new ArrayList<Integer>();

    private List<Integer> ligne_INTRADEF_x1_MEP = new ArrayList<Integer>();
    private List<Integer> ligne_INTRADEF_y1_MEP = new ArrayList<Integer>();

    public Item(int TAILLE_JOUR,int ORIGINE_DESSIN_X,int ORIGINE_DESSIN_Y,int MARGE_GAUCHE,int HAUTEUR_LIGNE)
    {
        this.TAILLE_JOUR=TAILLE_JOUR;
        this.ORIGINE_DESSIN_X=ORIGINE_DESSIN_X;
        this.ORIGINE_DESSIN_Y=ORIGINE_DESSIN_Y;
        this.MARGE_GAUCHE=MARGE_GAUCHE;
        this.HAUTEUR_LIGNE=HAUTEUR_LIGNE;
    }

    public void drawItem()
    {
        //A CODER TA FINIT LA HIER
    }

    public void ligne(Graphics2D g, Color color,int x1,int y1,int x2,int y2)
    {
        g.setColor(color);
        g.drawLine(x1,y1,x2,y2);
        g.setColor(Color.black);
    }


    public void drawLigneCircleMEPP(Graphics2D g,Color color, int tab)
    {
    List<Integer> liste_testx1= new ArrayList<Integer>(ligne_INTRADEF_x1);
    List<Integer> liste_testy1= new ArrayList<Integer>(ligne_INTRADEF_y1); // on clone les liste affin de détecter qu'elle point na pas son binôme

    
    for (int y = 0; y < ligne_INTRADEF_y1_MEP.size(); y++) {
        for (int a = y + 1; a < ligne_INTRADEF_y1.size(); a++) {
            if (ligne_INTRADEF_y1.get(y).equals(ligne_INTRADEF_y1.get(a))) {
                g.setColor(color);
                g.drawLine(ligne_INTRADEF_x1.get(y) + TAILLE_ITEM / 2,
                        ligne_INTRADEF_y1.get(y) + TAILLE_ITEM / 2, ligne_INTRADEF_x1.get(a) + TAILLE_ITEM / 2,
                        ligne_INTRADEF_y1.get(a) + TAILLE_ITEM / 2);
                g.setColor(Color.black);
                liste_testx1.remove (ligne_INTRADEF_x1.get(a));
                liste_testx1.remove(ligne_INTRADEF_x1.get(y));
                liste_testy1.remove(ligne_INTRADEF_y1.get(a));
                liste_testy1.remove(ligne_INTRADEF_y1.get(y));
            }
                
        }
        
    }
    for (int i = 0; i < liste_testx1.size(); i++)// Si l'un des deux cercle n'est pas dessiner , on prolonge le trait
                                                 // jusqu'a la marge
    {
        g.setColor(color);
        g.drawLine(MARGE_GAUCHE + 24, liste_testy1.get(i) + TAILLE_ITEM / 2, liste_testx1.get(i) + TAILLE_ITEM / 2,
                liste_testy1.get(i) + TAILLE_ITEM / 2);
        g.setColor(Color.black);
    }   
    
}

//_____________________________________________________________________________________________________

    public void drawLigneCircleMEP(Graphics2D g, Color color, int tab) {
        List<Integer> liste_testx1 = new ArrayList<Integer>(ligne_INTRADEF_x1_MEP);
        List<Integer> liste_testy1 = new ArrayList<Integer>(ligne_INTRADEF_y1_MEP);
        for (int y = 0; y < ligne_INTRADEF_y1_MEP.size(); y++) {
            for (int a = y + 1; a < ligne_INTRADEF_y1_MEP.size(); a++) {
                if (ligne_INTRADEF_y1_MEP.get(y).equals(ligne_INTRADEF_y1_MEP.get(a))) {
                    g.setColor(color);
                    g.drawLine(ligne_INTRADEF_x1_MEP.get(y) + TAILLE_ITEM / 2, ligne_INTRADEF_y1_MEP.get(y) + TAILLE_ITEM / 2,
                            ligne_INTRADEF_x1_MEP.get(a) + TAILLE_ITEM / 2, ligne_INTRADEF_y1_MEP.get(a) + TAILLE_ITEM / 2);
                    g.setColor(Color.black);
                    liste_testx1.remove(ligne_INTRADEF_x1_MEP.get(a));
                    liste_testx1.remove(ligne_INTRADEF_x1_MEP.get(y));
                    liste_testy1.remove(ligne_INTRADEF_y1_MEP.get(a));
                    liste_testy1.remove(ligne_INTRADEF_y1_MEP.get(y));
                }
            }
        }
    
        System.out.println(liste_testy1);
        List<Integer> testy1 = new ArrayList<Integer>(liste_testy1);   //On copi les listes 
        List<Integer> testx1 = new ArrayList<Integer>(liste_testx1);
        List<Integer> liste_test_y2 = new ArrayList<Integer>(testy1);
        List<Integer> liste_test_x2 = new ArrayList<Integer>(testx1);
        for (int i = 0; i < testy1.size(); i++)// Si l'un des deux cercle n'est pas dessiner , on prolonge le trait jusqu'a la marge
        {                                           //si la marge l aplus proche est a gauche
            for(int a=0;a<ligne_INTRADEF_y1.size();a++)
            {
                if(testy1.get(i).equals(ligne_INTRADEF_y1.get(a)))
                {
                    g.setColor(color);
                    g.drawLine(tab+ MARGE_GAUCHE+ 24, liste_testy1.get(i) + TAILLE_ITEM / 2, liste_testx1.get(i) + TAILLE_ITEM / 2,
                    liste_testy1.get(i) + TAILLE_ITEM / 2);
                    g.setColor(Color.black);
                    liste_test_y2.remove(ligne_INTRADEF_y1.get(a));
                }

            }
        }
        if(liste_test_y2.size()>1)//si la marge la plus proche et a droite
        {
            for (int i = 0; i < liste_test_y2.size(); i++)
            {
                g.setColor(color);
                g.drawLine(MARGE_GAUCHE + 24, liste_test_y2.get(i) + TAILLE_ITEM / 2,
                        liste_test_x2.get(i) + TAILLE_ITEM / 2, liste_test_y2.get(i) + TAILLE_ITEM / 2);
                g.setColor(Color.black);
            }
        }
            
        
    }

    


//-----------------------Methode_DrawCircle-Surcharé-------------------------------
//elle transette au les cordonnées pour afficher les lignes entre les cercle
    public void drawCircleMEPP(Graphics2D g, int i,int jour_d, List<Integer> jour_affichage, Color color) {
        for (int a = 0; a < jour_affichage.size(); a++) {
          
            if (i == jour_affichage.get(a)) {
                Shape circle = new Ellipse2D.Double(MARGE_GAUCHE - 6 + ((i-jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2,
                        ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM, TAILLE_ITEM, TAILLE_ITEM);
                g.setPaint(color);
                g.fill(circle);
                g.setColor(Color.BLACK);
                ligne_INTRADEF_x1.add((MARGE_GAUCHE - 6 + ((i-jour_d)* TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2));
                ligne_INTRADEF_y1.add(ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM);
            
            }

        }
    }



    public void drawCircleMEPP(Graphics2D g, int i, int jour_d, List<Integer> jour_affichage,List<Integer> jour_affichage2,Color color) {
        for (int a = 0; a < jour_affichage.size(); a++) {
            if (i == jour_affichage.get(a)) {
                Shape circle = new Ellipse2D.Double(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2,
                        ORIGINE_DESSIN_Y + ((a+jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM, 
                        TAILLE_ITEM, TAILLE_ITEM);
                g.setPaint(color);
                g.fill(circle);
                g.setColor(Color.BLACK);
                ligne_INTRADEF_x1.add(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                ligne_INTRADEF_y1.add(ORIGINE_DESSIN_Y + ((a + jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);
            }
        }
    }

    public void drawCircleMEPP(Graphics2D g, int i, int jour_d, List<Integer> jour_affichage, List<Integer> jour_affichage2,List<Integer> jour_affichage3,
            Color color) {
        for (int a = 0; a < jour_affichage.size(); a++) {
            if (i == jour_affichage.get(a)) {
                Shape circle = new Ellipse2D.Double(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2,
                        ORIGINE_DESSIN_Y + ((a +jour_affichage2.size()+jour_affichage3.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM, TAILLE_ITEM, TAILLE_ITEM);
                g.setPaint(color);
                g.fill(circle);
                g.setColor(Color.BLACK);
                ligne_INTRADEF_x1.add(MARGE_GAUCHE - 6 + ((i - jour_d)* TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                ligne_INTRADEF_y1.add(ORIGINE_DESSIN_Y
                        + ((a + jour_affichage2.size() + jour_affichage3.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);
            }
        }
    }

    //encore de la surcharge

    public void drawCircleMEP(Graphics2D g, int i, int jour_d, List<Integer> jour_affichage, Color color) {
        for (int a = 0; a < jour_affichage.size(); a++) {

            if (i == jour_affichage.get(a)) {

                Shape circle = new Ellipse2D.Double(
                        MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2,
                        ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM, TAILLE_ITEM, TAILLE_ITEM);
                g.setPaint(color);
                g.fill(circle);
                g.setColor(Color.BLACK);
                ligne_INTRADEF_x1_MEP
                        .add((MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2));
                ligne_INTRADEF_y1_MEP.add(ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM);

            }

        }
    }


    public void drawCircleMEP(Graphics2D g, int i, int jour_d, List<Integer> jour_affichage,List<Integer> jour_affichage2,Color color) {
        for (int a = 0; a < jour_affichage.size(); a++) {
            if (i == jour_affichage.get(a)) {
                Shape circle = new Ellipse2D.Double(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2,
                        ORIGINE_DESSIN_Y + ((a+jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM, 
                        TAILLE_ITEM, TAILLE_ITEM);
                g.setPaint(color);
                g.fill(circle);
                g.setColor(Color.BLACK);
                ligne_INTRADEF_x1_MEP.add(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                ligne_INTRADEF_y1_MEP.add(ORIGINE_DESSIN_Y + ((a + jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);
            }
        }
    }

    public void drawCircleMEP(Graphics2D g, int i, int jour_d, List<Integer> jour_affichage, List<Integer> jour_affichage2,List<Integer> jour_affichage3,
            Color color) {
        for (int a = 0; a < jour_affichage.size(); a++) {
            if (i == jour_affichage.get(a)) {
                Shape circle = new Ellipse2D.Double(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2,
                        ORIGINE_DESSIN_Y + ((a +jour_affichage2.size()+jour_affichage3.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM, TAILLE_ITEM, TAILLE_ITEM);
                g.setPaint(color);
                g.fill(circle);
                g.setColor(Color.BLACK);
                ligne_INTRADEF_x1_MEP.add(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                ligne_INTRADEF_y1_MEP.add(ORIGINE_DESSIN_Y
                        + ((a + jour_affichage2.size() + jour_affichage3.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);
            }
        }
    }

    //-------------------draw--------------------triangle-----------------------------------

    public void drawTriangleMEP(Graphics2D g, int i, int jour_d, List<Integer> jour_affichage, Color color,
            ArrayList<String> Statut_INTRADEF) 
    {
    for (int a = 0; a < jour_affichage.size(); a++) {
           
            if (i == jour_affichage.get(a)) //ICI REVOIR 
            {
            
            if(Statut_INTRADEF.get(a).equals("URGENT") && jour_affichage.get(a)==i)
                    {
                        triangle.drawMe(g, color,Color.red,
                             MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2 + 10,
                             ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM * 2 - 3);
                        ligne_INTRADEF_x1_MEP.add((MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2));
                        ligne_INTRADEF_y1_MEP.add(ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM);
                    }
                    else
                    {
                        triangle.drawMe(
                                g, color, color, MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X
                                        - TAILLE_ITEM / 2 + 10,
                                ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM * 2 - 3);
                        ligne_INTRADEF_x1_MEP.add(
                                (MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2));
                        ligne_INTRADEF_y1_MEP.add(ORIGINE_DESSIN_Y + (a * HAUTEUR_LIGNE) - TAILLE_ITEM);
                    }

            }

        }
    }


    public void drawTriangleMEP(Graphics2D g, int i, int jour_d, List<Integer> jour_affichage,
            List<Integer> jour_affichage2, Color color, ArrayList<String> Statut_INTRADEF) 
    {
        for (int a = 0; a < jour_affichage.size(); a++) {
            if (i == jour_affichage.get(a)) 
            {
             if(Statut_INTRADEF.get(a).equals("URGENT") && jour_affichage.get(a)==i)
             {
                triangle.drawMe(g, color,Color.RED,
                        MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2 + 10,
                        ORIGINE_DESSIN_Y + ((a + jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM * 2 - 3);
                ligne_INTRADEF_x1_MEP
                        .add(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                ligne_INTRADEF_y1_MEP
                        .add(ORIGINE_DESSIN_Y + ((a + jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);
            }
            else
            {
            triangle.drawMe(g, color,color,
                        MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2 + 10,
                        ORIGINE_DESSIN_Y + ((a + jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM * 2 - 3);
                ligne_INTRADEF_x1_MEP
                        .add(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                ligne_INTRADEF_y1_MEP
                        .add(ORIGINE_DESSIN_Y + ((a + jour_affichage2.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);
            
            
            }
        }
    }}

    public void drawTriangleMEP(Graphics2D g, int i, int jour_d, List<Integer> jour_affichage,
            List<Integer> jour_affichage2, List<Integer> jour_affichage3, Color color,
            ArrayList<String> Statut_INTRADEF) {
        for (int a = 0; a < jour_affichage.size(); a++) {
            if (i == jour_affichage.get(a)) 
            {
            if(Statut_INTRADEF.get(a).equals("URGENT") && jour_affichage.get(a)==i)
             {
                triangle.drawMe(g, color,Color.red,
                        MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2 + 10,
                        ORIGINE_DESSIN_Y + ((a + jour_affichage2.size() + jour_affichage3.size()) * HAUTEUR_LIGNE)
                                - TAILLE_ITEM*2 - 3);
                ligne_INTRADEF_x1_MEP
                        .add(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                ligne_INTRADEF_y1_MEP.add(ORIGINE_DESSIN_Y
                        + ((a + jour_affichage2.size() + jour_affichage3.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);
            }
            else
            {
                triangle.drawMe(g, color,color,
                        MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2 + 10,
                        ORIGINE_DESSIN_Y + ((a + jour_affichage2.size() + jour_affichage3.size()) * HAUTEUR_LIGNE)
                                - TAILLE_ITEM*2 - 3);
                ligne_INTRADEF_x1_MEP
                        .add(MARGE_GAUCHE - 6 + ((i - jour_d) * TAILLE_JOUR) + ORIGINE_DESSIN_X - TAILLE_ITEM / 2);
                ligne_INTRADEF_y1_MEP.add(ORIGINE_DESSIN_Y
                        + ((a + jour_affichage2.size() + jour_affichage3.size()) * HAUTEUR_LIGNE) - TAILLE_ITEM);   
            }
        }}
    }





    public void drawRectangle(Graphics2D g,int withd,int height,int a,Color color)
    {   
        g.setColor(color);
        g.drawRect(ORIGINE_DESSIN_X,ORIGINE_DESSIN_Y,withd,height);
        g.setColor(Color.BLACK);
    }




    
}
